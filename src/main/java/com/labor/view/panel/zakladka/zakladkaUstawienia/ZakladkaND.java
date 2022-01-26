package com.labor.view.panel.zakladka.zakladkaUstawienia;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.StrategiaWyplatyND;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.StrategiaWyplatyU;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.CzasPracyND;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.UmiejetnosciND;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaND extends Zakladka<StrategiaWyplatyND> {

    private JLabel _strategiaWyplatyND;
    private JComboBox<StrategiaWyplatyND> strategiaWyplatyJComboBoxND;

    private ArrayList<Pracownik> listaPracownikow;
    private StrategiaWyplatyND wybranaStrategiaWyplaty;

    public ZakladkaND() {
        _strategiaWyplatyND = new JLabel("Sposób wypłaty");
        strategiaWyplatyJComboBoxND = new JComboBox<>();

        konfigurujComboBox();
        konfiguruj();
    }

    private void konfigurujComboBox() {

        StrategiaWyplatyND[] rodzajeStrategii = {new CzasPracyND(), new UmiejetnosciND()};

        for (StrategiaWyplatyND strategiaWyplaty : rodzajeStrategii) {
            strategiaWyplatyJComboBoxND.addItem(strategiaWyplaty);
        }

        strategiaWyplatyJComboBoxND.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranaStrategiaWyplaty = (StrategiaWyplatyND) strategiaWyplatyJComboBoxND.getSelectedItem();
            }
        });

    }

    private void konfiguruj() {
        add(_strategiaWyplatyND);
        add(strategiaWyplatyJComboBoxND);
    }

    @Override
    public StrategiaWyplatyND zapisz() {
        return wybranaStrategiaWyplaty;
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public void aktualizuj() {

    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {
        this.listaPracownikow = listPracownikow;
    }
}
