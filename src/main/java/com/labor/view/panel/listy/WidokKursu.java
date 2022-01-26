package com.labor.view.panel.listy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.events.OcenaEvent;
import com.labor.events.StudentEvent;
import com.labor.view.panel.zakladka.Zakladka;
import com.labor.view.panel.zakladka.zakladkaListy.ZakladkaStronaKursu;
import com.labor.view.panel.zakladka.zakladkaListy.ZakladkaWyswietlStud;
import com.labor.view.panel.zakladka.zakladkaListy.ZakladkaZakonczKurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WidokKursu extends JPanel{

    private JTabbedPane listwa;
    private Zakladka<StudentEvent> panelDodajStudenta;
    private Zakladka<Kurs> panelZakoncz;
    private ZakladkaWyswietlStud panelWyswietlStudentow;

    private JButton zakoncz;

    private ArrayList<Kurs> listaKursow;
    private ArrayList<Student> listaStudentow;

    public WidokKursu(ListaKursow tabelaKursow) {
        listwa = new JTabbedPane();
        panelDodajStudenta = new ZakladkaStronaKursu();
        panelZakoncz = new ZakladkaZakonczKurs();
        panelWyswietlStudentow = new ZakladkaWyswietlStud();
        zakoncz = new JButton("X");
        zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabelaKursow.setFlaga("true");
            }
        });

        add(zakoncz);
        zakoncz.setHorizontalAlignment(JButton.CENTER);
        zakoncz.setVerticalAlignment(JButton.CENTER);

        dodajZakladke("Wyświetl studentów", panelWyswietlStudentow);
        dodajZakladke("Dodaj studenta", panelDodajStudenta);
        dodajZakladke("Zakończ kurs", panelZakoncz);
    }

    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listaPracownikow) {
        this.listaKursow = listaKursow;
        this.listaStudentow = listaStudentow;
    }

    public void dodajZakladke(String nawzwa, JPanel panel) {
        listwa.addTab(nawzwa, null, panel);
    }

    public void aktualizuj() {
        panelDodajStudenta.setListy(listaKursow, listaStudentow, null);
        panelDodajStudenta.aktualizuj();
        panelWyswietlStudentow.setListy(listaKursow, null, null);
        panelWyswietlStudentow.aktualizuj();
        panelZakoncz.setListy(listaKursow, null, null);
        panelZakoncz.aktualizuj();
    }

    public void zrobGUI() {
        add(listwa);
        setVisible(true);
    }

    public ZakladkaWyswietlStud getPanelWyswietlStudentow() {
        return panelWyswietlStudentow;
    }

    public Zakladka<Kurs> getPanelZakoncz() {
        return panelZakoncz;
    }

    public Zakladka<StudentEvent> getPanelDodajStudenta() {
        return panelDodajStudenta;
    }
}
