package com.labor.view.panel.zakladka.zakladkaListy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.events.OcenaEvent;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaDodajOcene extends Zakladka<OcenaEvent> {

    private JLabel opis;
    private JComboBox<Integer> ocenaComboBox;
    private JButton zakoncz;
    private JButton zapisz;

    private ZakladkaWyswietlStud parent;

    private Integer wybranaOcena;

    private Student wybranyStudent;
    private Kurs obecnyKurs;

    public ZakladkaDodajOcene(ZakladkaWyswietlStud zakladkaWyswietlStud) {
        super();
        this.parent = zakladkaWyswietlStud;
        przyciskZapisu.hide();
        opis = new JLabel("Wybierz ocenę");
        ocenaComboBox = new JComboBox<>();
        zakoncz = new JButton("X");
        zapisz = new JButton("Dodaj ocenę");
        zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setFlaga("true");
            }
        });

        konfigurujJComboBox();

        add(zakoncz);
        add(opis);
        add(ocenaComboBox);
        add(zapisz);
    }

    private void konfigurujJComboBox() {
        Integer[] listaOcen = {1, 2, 3, 4, 5};

        for (Integer ocena : listaOcen) {
            ocenaComboBox.addItem(ocena);
        }

        ocenaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranaOcena = (Integer) ocenaComboBox.getSelectedItem();
            }
        });
    }

    @Override
    public OcenaEvent zapisz() {
        int przesylanaOcena = wybranaOcena;
        OcenaEvent ocenaEvent = new OcenaEvent(wybranyStudent, obecnyKurs, przesylanaOcena);

        return ocenaEvent;
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        zapisz.addActionListener(actionListener);
    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {
        this.wybranyStudent = listaStudentow.get(0);
        this.obecnyKurs = listaKursow.get(0);
    }

    @Override
    public void aktualizuj() {

    }
}
