package com.labor.view.panel.listy;

import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.PracownikU;
import com.labor.events.PracownikNDEvent;
import com.labor.events.PracownikUEvent;
import com.labor.view.panel.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaPracownikow extends ListaAbstract {

    private String flaga;
    private String flagaTrue = "true";
    private String flagaFalseND = "falseND";
    private String flagaFalseU = "falseU";

    private WidokPracownikaND panelPracownikaND;
    private WidokPracownikaU panelPracownikaU;

    private JPanel wyswietlPracownikow;

    private JPanel panelKart;

    private ListaPracownikow tabelaPracownikow = this;

    private ArrayList<Pracownik> listaWybranyPracownik;
    private Pracownik wybranyPracownik;

    public ListaPracownikow() {
        flaga = flagaTrue;

        panelKart = new JPanel(new CardLayout());

        wyswietlPracownikow = new JPanel();
        panelPracownikaND = new WidokPracownikaND(this);
        panelPracownikaU = new WidokPracownikaU(this);

        konfigurujKarty();

        nazwyKolumn = new Object[] {
                "Imię",
                "Nazwisko",
                "Zatrudnienie",
                "Numer ID",
                "Pensja",
                "Numer pracownika"
        };

        dodajMouseListener(new MyMouseListener() {
            @Override
            public void wykonaj() {
                wybranyPracownik = (Pracownik) tabelka.getValueAt(tabelka.getSelectedRow(), 5);

                if (wybranyPracownik instanceof PracownikU) {
                    flaga = flagaFalseU;
                } else if (wybranyPracownik instanceof PracownikND) {
                    flaga = flagaFalseND;
                }
                listaWybranyPracownik = new ArrayList<>();
                listaWybranyPracownik.add(wybranyPracownik);

                CardLayout cl = (CardLayout) (panelKart.getLayout());
                cl.show(panelKart, flaga);

                panelPracownikaND.setListy(null, null, listaWybranyPracownik);
                panelPracownikaU.setListy(null, null, listaWybranyPracownik);
                panelPracownikaND.aktualizuj();
                panelPracownikaU.aktualizuj();
                panelPracownikaND.zrobGUI();
                panelPracownikaU.zrobGUI();
            }
        });
    }

    private void konfigurujKarty() {
        panelKart.add(wyswietlPracownikow, flagaTrue);
        panelKart.add(panelPracownikaND, flagaFalseND);
        panelKart.add(panelPracownikaU, flagaFalseU);

        add(panelKart);

        panelKart.setVisible(true);
    }

    public void setFlaga(String flaga) {
        this.flaga = flaga;
        CardLayout cl = (CardLayout) (panelKart.getLayout());
        cl.show(panelKart, flaga);
    }

    @Override
    public void dodajTabelke() {
        super.dodajTabelke();

        remove(tabelka);
        wyswietlPracownikow.add(tabelka);

        for (Pracownik pracownik : listaPracownikow) {
            String zatrudnienie = "";
            if (pracownik instanceof PracownikND) {
                zatrudnienie = "Pracownik ND";
            } else {
                zatrudnienie = "Pracownik U";
            }
            Object[] wiersz = {pracownik.getImie(),
                    pracownik.getNazwisko(),
                    zatrudnienie,
                    pracownik.getNumerID(),
                    pracownik.getWyplata(),
                    pracownik
            };
            model.addRow(wiersz);
        }
        repaint();
    }

    @Override
    public void aktualizuj() {
        dodajTabelke();
    }

    public PracownikNDEvent zapiszPracownikND() {
        return panelPracownikaND.zapisz();
    }

    public PracownikUEvent zapiszPracownikaU() {
        return panelPracownikaU.zapisz();
    }

    public void dodajAktualizujNDListener(ActionListener actionListener) {
        panelPracownikaND.dodajZapiszListener(actionListener);
    }

    public void dodajAktualizujUListener(ActionListener actionListener) {
        panelPracownikaU.dodajZapiszListener(actionListener);
    }
}
