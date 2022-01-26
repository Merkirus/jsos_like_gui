package com.labor.view.panel;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.view.panel.zakladka.Zakladka;
import com.labor.view.panel.zakladka.zakladkaKreator.ZakladkaPracownik;
import com.labor.view.panel.zakladka.zakladkaKreator.ZakladkaStudent;
import com.labor.view.panel.zakladka.zakladkaKreator.ZakladkaKurs;

import javax.swing.*;
import java.util.ArrayList;


public class Kreator extends JFrame implements Panel {

    private static final int WYS = 500;
    private static final int SZE = 500;

    private Zakladka<Kurs> panelKurs;
    private Zakladka<Student> panelStudent;
    private Zakladka<Pracownik> panelPracownik;
    private JTabbedPane listwa;

    private ArrayList<Kurs> listaKursow;
    private ArrayList<Student> listaStudentow;
    private ArrayList<Pracownik> listaPracownikow;

    public Kreator() {
        setTitle("Kreator");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(WYS, SZE);
        panelKurs = new ZakladkaKurs();
        panelStudent = new ZakladkaStudent();
        panelPracownik = new ZakladkaPracownik();
        listwa = new JTabbedPane();
    }

    private void stworzZakladki() {
        listwa.addTab("Kurs", null, panelKurs);
        listwa.addTab("Student",null, panelStudent);
        listwa.addTab("Pracownik", null, panelPracownik);
    }

    @Override
    public void zrobGUI() {
        getContentPane().add(listwa);
        stworzZakladki();
        panelKurs.setListy(listaKursow, listaStudentow, listaPracownikow);
        if (listaPracownikow!=null) {panelKurs.aktualizuj();}
        panelStudent.setListy(listaKursow, listaStudentow, listaPracownikow);
        panelPracownik.setListy(listaKursow, listaStudentow, listaPracownikow);
        setVisible(true);
    }

    @Override
    public void aktualizuj() {
        panelStudent.setListy(listaKursow, listaStudentow, listaPracownikow);
        panelStudent.aktualizuj();
        panelKurs.setListy(listaKursow, listaStudentow, listaPracownikow);
        panelKurs.aktualizuj();
        panelPracownik.setListy(listaKursow, listaStudentow, listaPracownikow);
        panelPracownik.aktualizuj();
    }

    public Zakladka getPanelStudent() {
        return panelStudent;
    }

    public Zakladka getPanelKurs() {
        return panelKurs;
    }

    public Zakladka getPanelPracownik() {
        return panelPracownik;
    }

    @Override
    public void setListySpisu(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Student> listaStypendystow, ArrayList<Pracownik> listaPracownikow) {
        this.listaKursow = listaKursow;
        this.listaPracownikow = listaPracownikow;
    }

}
