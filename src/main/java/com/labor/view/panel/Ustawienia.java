package com.labor.view.panel;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.StrategiaWyplatyND;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.StrategiaWyplatyU;
import com.labor.view.panel.zakladka.Zakladka;
import com.labor.view.panel.zakladka.zakladkaUstawienia.ZakladkaND;
import com.labor.view.panel.zakladka.zakladkaUstawienia.ZakladkaU;

import javax.swing.*;
import java.util.ArrayList;

public class Ustawienia extends JFrame implements Panel {

    private static final int WYS = 200;
    private static final int SZE = 200;

    private Zakladka<StrategiaWyplatyND> panelND;
    private Zakladka<StrategiaWyplatyU> panelU;
    private JTabbedPane listwa;

    private ArrayList<Pracownik> listaPracownikow;

    public Ustawienia() {
        setTitle("Ustawienia");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(WYS, SZE);
        panelND = new ZakladkaND();
        panelU = new ZakladkaU();
        listwa = new JTabbedPane();
    }

    @Override
    public void setListySpisu(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Student> listaStypendystow, ArrayList<Pracownik> listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
    }

    private void stworzZakladki() {
        listwa.addTab("PracownikND", null, panelND);
        listwa.addTab("PracownikU", null, panelU);
    }

    @Override
    public void zrobGUI() {
        getContentPane().add(listwa);
        stworzZakladki();
        panelND.setListy(null, null, listaPracownikow);
        panelU.setListy(null, null, listaPracownikow);
        setVisible(true);
    }

    @Override
    public void aktualizuj() {

    }

    public Zakladka<StrategiaWyplatyND> getPanelND() {
        return panelND;
    }

    public Zakladka<StrategiaWyplatyU> getPanelU() {
        return panelU;
    }
}
