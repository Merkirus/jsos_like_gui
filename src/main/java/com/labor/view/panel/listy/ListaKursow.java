package com.labor.view.panel.listy;

import com.labor.classes.Kurs;
import com.labor.events.OcenaEvent;
import com.labor.events.StudentEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaKursow extends ListaAbstract {

    private String flaga;
    private String flagaTrue = "true";
    private String flagaFalse = "false";

    private ListaKursow tabelaKursow = this;
    private WidokKursu panelKursu;

    private JPanel panelKart;
    private JPanel wyswietlKursy;
    private JPanel wyswietlWybranyKurs;

    private Kurs wybranyKurs;
    private ArrayList<Kurs> listaWybranyKurs;

    public ListaKursow() {
        flaga = flagaTrue;
        panelKart = new JPanel();
        panelKart.setLayout(new CardLayout());
        panelKursu = new WidokKursu(this);

        nazwyKolumn = new Object[]{
                "Nazwa kursu",
                "Prowadzący",
                "ECTS",
                "Ilość studentów",
                "Numer kursu"
        };

        konfigurujKarty();

        dodajMouseListener(new MyMouseListener() {
            @Override
            public void wykonaj() {
                flaga = flagaFalse;

                wybranyKurs = (Kurs) tabelka.getValueAt(tabelka.getSelectedRow(), 4);
                listaWybranyKurs = new ArrayList<>();
                listaWybranyKurs.add(wybranyKurs);

                CardLayout cl = (CardLayout) (panelKart.getLayout());
                cl.show(panelKart, flaga);

                panelKursu.setListy(listaWybranyKurs, listaStudentow, null);
                panelKursu.aktualizuj();
                panelKursu.zrobGUI();
            }
        });
    }

    @Override
    public void aktualizuj() {
        dodajTabelke();
        panelKursu.setListy(listaWybranyKurs, listaStudentow, null);
        panelKursu.aktualizuj();
    }

    @Override
    public void dodajTabelke() {
        super.dodajTabelke();

        remove(tabelka);
        wyswietlKursy.add(tabelka);

        for (Kurs kurs : listaKursow) {
            Object[] wiersz = {kurs.getNazwaKursu(), kurs.getWykladowca(), kurs.getEcts(), kurs.getStudenci().size(), kurs};
            model.addRow(wiersz);
        }
        repaint();
    }

    private void konfigurujKarty() {
        wyswietlKursy = new JPanel();
        wyswietlWybranyKurs = new JPanel();
        panelKart.add(wyswietlKursy, flagaTrue);
        panelKart.add(panelKursu, flagaFalse);

        add(panelKart);

        panelKart.setVisible(true);
    }

    public void setFlaga(String flaga) {
        this.flaga = flaga;
        CardLayout cl = (CardLayout) (panelKart.getLayout());
        cl.show(panelKart, flaga);
    }

    public void dodajOceneListener(ActionListener actionListener) {
        panelKursu.getPanelWyswietlStudentow().getPanelDodajOcene().dodajZapiszListener(actionListener);
    }

    public OcenaEvent zapiszOcene() {
        return (OcenaEvent) panelKursu.getPanelWyswietlStudentow().getPanelDodajOcene().zapisz();
    }

    public void dodajZakonczKursListener(ActionListener actionListener) {
        panelKursu.getPanelZakoncz().dodajZapiszListener(actionListener);
    }

    public Kurs zakonczKurs() {
        return (Kurs) panelKursu.getPanelZakoncz().zapisz();
    }

    public void dodajStudentaListener(ActionListener actionListener) {
        panelKursu.getPanelDodajStudenta().dodajZapiszListener(actionListener);
    }

    public StudentEvent dodajStudentaDoKursu() {
        return (StudentEvent) panelKursu.getPanelDodajStudenta().zapisz();
    }
}
