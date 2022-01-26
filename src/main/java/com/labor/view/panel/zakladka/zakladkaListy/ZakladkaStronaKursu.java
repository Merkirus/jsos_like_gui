package com.labor.view.panel.zakladka.zakladkaListy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.events.StudentEvent;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaStronaKursu extends Zakladka<StudentEvent> {

    private Kurs kurs;
    private JLabel _wyborStudenta;
    private JComboBox<Student> wyborStudenta;

    private ArrayList<Student> listaStudentow;
    private Student wybranyStudent;

    public ZakladkaStronaKursu() {
        super();
        _wyborStudenta = new JLabel("Wybierz studenta");
        wyborStudenta = new JComboBox<>();

        konfiguruj();
    }

    private void konfigurujComboBox() {

        remove(wyborStudenta);
        wyborStudenta = new JComboBox<>();
        add(wyborStudenta);

        for (Student student : listaStudentow) {
            wyborStudenta.addItem(student);
        }

        wyborStudenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranyStudent = (Student) wyborStudenta.getSelectedItem();
            }
        });
        repaint();
    }

    private void konfiguruj() {
        add(_wyborStudenta);
        add(wyborStudenta);
    }

    @Override
    public void aktualizuj() {
        if (listaStudentow!=null) {
            konfigurujComboBox();
        }
    }

    @Override
    public StudentEvent zapisz() {
        return new StudentEvent(wybranyStudent, kurs);
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {

        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {
        this.listaStudentow = listaStudentow;
        if (listaKursow!=null) {
            this.kurs = listaKursow.get(0);
        }
    }
}
