package com.labor.view.panel;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.events.OcenaEvent;
import com.labor.view.panel.listy.ListaKursow;
import com.labor.view.panel.listy.ListaPracownikow;
import com.labor.view.panel.listy.ListaStudentow;
import com.labor.view.panel.listy.ListaStypendystow;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Listy extends JFrame implements Panel {

    private static final int WYS = 800;
    private static final int SZE = 500;

    private JTabbedPane listwa;
    private ListaKursow widokKursow;
    private ListaPracownikow widokPracownikow;
    private ListaStudentow widokStudentow;
    private ListaStypendystow widokStypendystow;

    private ArrayList<Kurs> listaKursow;
    private ArrayList<Student> listaStudentow;
    private ArrayList<Student> listaStypendystow;
    private ArrayList<Pracownik> listaPracownikow;

    public Listy() {
        listwa = new JTabbedPane();
        widokKursow = new ListaKursow();
        widokPracownikow = new ListaPracownikow();
        widokStudentow = new ListaStudentow();
        widokStypendystow = new ListaStypendystow();

        dodajZakladki();
        konfiguruj();
    }

    private void konfiguruj() {
        setTitle("Spis");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(WYS, SZE);
    }

    private void dodajZakladki() {
        listwa.addTab("Lista kursów", null, widokKursow);
        listwa.addTab("Lista pracowników", null, widokPracownikow);
        listwa.addTab("Lista studentów", null, widokStudentow);
        listwa.addTab("Lista stypendystów", null, widokStypendystow);
    }

    @Override
    public void zrobGUI() {
        getContentPane().add(listwa);
        dodajZakladki();
        widokKursow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokKursow.dodajTabelke();
        widokPracownikow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokPracownikow.dodajTabelke();
        widokStudentow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokStudentow.dodajTabelke();
        widokStypendystow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokStypendystow.dodajTabelke();
        setVisible(true);
    }

    @Override
    public void aktualizuj() {
        widokKursow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokKursow.aktualizuj();
        widokPracownikow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokPracownikow.aktualizuj();
        widokStudentow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokStudentow.aktualizuj();
        widokStypendystow.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        widokStypendystow.aktualizuj();
    }

    @Override
    public void setListySpisu(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Student> listaStypendystow, ArrayList<Pracownik> listaPracownikow) {
        this.listaKursow = listaKursow;
        this.listaStudentow = listaStudentow;
        this.listaPracownikow = listaPracownikow;
        this.listaStypendystow = listaStypendystow;
    }

    public ListaKursow getWidokKursow() {
        return widokKursow;
    }

    public ListaPracownikow getWidokPracownikow() {
        return widokPracownikow;
    }
}
