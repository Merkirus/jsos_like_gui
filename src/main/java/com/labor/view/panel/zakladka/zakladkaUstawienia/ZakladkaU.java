package com.labor.view.panel.zakladka.zakladkaUstawienia;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.StrategiaWyplatyU;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.CzasPracyU;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.UmiejetnosciU;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaU extends Zakladka<StrategiaWyplatyU> {

    private JLabel _strategiaWyplatyU;
    private JComboBox<StrategiaWyplatyU> strategiaWyplatyJComboBoxU;

    private ArrayList<Pracownik> listaPracownikow;
    private StrategiaWyplatyU wybranaStrategiaWyplaty;

    public ZakladkaU() {
        _strategiaWyplatyU = new JLabel("Sposób wypłaty");
        strategiaWyplatyJComboBoxU = new JComboBox<>();

        konfigurujComboBox();
        konfiguruj();
    }

    private void konfigurujComboBox() {

        StrategiaWyplatyU[] rodzajeStrategii = {new CzasPracyU(), new UmiejetnosciU()};

        for (StrategiaWyplatyU strategiaWyplaty : rodzajeStrategii) {
            strategiaWyplatyJComboBoxU.addItem(strategiaWyplaty);
        }

        strategiaWyplatyJComboBoxU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranaStrategiaWyplaty = (StrategiaWyplatyU) strategiaWyplatyJComboBoxU.getSelectedItem();
            }
        });
    }

    private void konfiguruj() {
        add(_strategiaWyplatyU);
        add(strategiaWyplatyJComboBoxU);
    }

    @Override
    public StrategiaWyplatyU zapisz() {
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
