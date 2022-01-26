package com.labor.view.panel.zakladka.zakladkaKreator;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Osoba;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.Student;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaKurs extends Zakladka<Kurs> {

    private ArrayList<Pracownik> listaPracownikow;

    private JLabel _nazwaKursu;
    private JTextField nazwaKursu;
    private JLabel _wykladowcaKursu;
    private JComboBox<Osoba> wykladowcaKursu;
    private JLabel _punktyECTS;
    private JComboBox<String> punktyECTS;

    private String wybranePunktyECTS;
    private Pracownik wybranyWykladowcaKursu;


    public ZakladkaKurs() {
        super();
        _nazwaKursu = new JLabel("Nazwa kursu");
        nazwaKursu = new JTextField(20);
        _wykladowcaKursu = new JLabel("Wykładowca");
        wykladowcaKursu = new JComboBox<>();
        _punktyECTS = new JLabel("Punkty ECTS");
        punktyECTS = new JComboBox<>();

        konfigurujComboBoxECTS();
        konfiguruj();
    }

    private void konfigurujComboBoxWykladowca() {

        remove(wykladowcaKursu);
        wykladowcaKursu = new JComboBox<>();
        add(wykladowcaKursu);

        ArrayList<Pracownik> wykladowcy = new ArrayList<>();

        for (Pracownik pracownik : listaPracownikow) {
            if (pracownik instanceof PracownikND) {
                wykladowcy.add(pracownik);
            }
        }

        for (Pracownik wykladowca : wykladowcy) {
            wykladowcaKursu.addItem(wykladowca);
        }

        wykladowcaKursu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranyWykladowcaKursu = (Pracownik) wykladowcaKursu.getSelectedItem();
            }
        });
        repaint();
    }

    private void konfigurujComboBoxECTS() {

        String[] liczbaPunktow = {"1", "2", "3", "4", "5", "6"};

        for (String wartosc : liczbaPunktow) {
            punktyECTS.addItem(wartosc);
        }

        punktyECTS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranePunktyECTS = (String) punktyECTS.getSelectedItem();
            }
        });

    }

    private void konfiguruj() {
        add(_nazwaKursu);
        add(nazwaKursu);
        add(_punktyECTS);
        add(punktyECTS);
        add(_wykladowcaKursu);
        add(wykladowcaKursu);
    }

    private void clear() {
        nazwaKursu.setText("");
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public Kurs zapisz() {

        Kurs kurs = new Kurs(nazwaKursu.getText(), wybranyWykladowcaKursu, Integer.parseInt(wybranePunktyECTS));

        clear();

        return kurs;
    }

    @Override
    public void aktualizuj() {
        konfigurujComboBoxWykladowca();
    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow,
                         ArrayList<Student> listaStudentow,
                         ArrayList<Pracownik> listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
    }
}
