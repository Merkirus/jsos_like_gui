package com.labor.view.panel.listy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikU;
import com.labor.classes.osoba.Student;
import com.labor.events.PracownikUEvent;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WidokPracownikaU extends Zakladka<PracownikUEvent> {

    private JLabel _liczbaNadgodzin;
    private JLabel _trybPracy;
    private JLabel _umiejetnosci;
    private JLabel _liczbaJezykowObcych;

    private JTextField liczbaNadgodzin;
    private JComboBox<String> trybPracy;
    private JComboBox<String> umiejetnosci;
    private JTextField liczbaJezykowObcych;

    private JButton zakoncz;

    private String wybranyTryb;
    private String wybranaUmiejetnosc;

    private Pracownik wybranyPracownik;

    private ListaPracownikow listaPracownikow;

    public WidokPracownikaU(ListaPracownikow listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
        _liczbaNadgodzin = new JLabel("Liczba nadgodzin");
        _trybPracy = new JLabel("Tryb pracy");
        _umiejetnosci = new JLabel("Umięjtności");
        _liczbaJezykowObcych = new JLabel("Liczba znanych języków");

        liczbaNadgodzin = new JTextField();
        trybPracy = new JComboBox<>();
        umiejetnosci = new JComboBox<>();
        liczbaJezykowObcych = new JTextField();

        zakoncz = new JButton("X");
        zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPracownikow.setFlaga("true");
            }
        });

        konfigurujComboBoxy();
        konfiguruj();
    }

    private void konfigurujComboBoxy() {

        String[] listaTrybow = {"Poranny", "Popołudniowy", "Wieczorny", "Nocny"};
        String[] listaUmiejetnosci = {"Przeciętne", "Dobre", "Bardzo dobre", "Wybitne"};

        for (String tryb : listaTrybow) {
            trybPracy.addItem(tryb);
        }

        for (String umiejetnosc : listaUmiejetnosci) {
            umiejetnosci.addItem(umiejetnosc);
        }

        trybPracy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranyTryb = (String) trybPracy.getSelectedItem();
            }
        });

        umiejetnosci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranaUmiejetnosc = (String) umiejetnosci.getSelectedItem();
            }
        });

    }

    private void konfiguruj() {
        add(_liczbaNadgodzin);
        add(liczbaNadgodzin);
        add(_liczbaJezykowObcych);
        add(liczbaJezykowObcych);
        add(_trybPracy);
        add(trybPracy);
        add(_umiejetnosci);
        add(umiejetnosci);
        add(zakoncz);
        zakoncz.setHorizontalAlignment(JButton.CENTER);
        zakoncz.setVerticalAlignment(JButton.CENTER);
    }

    private void clear() {
        liczbaNadgodzin.setText("");
        liczbaJezykowObcych.setText("");
    }

    public void zrobGUI() {
        setVisible(true);
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public PracownikUEvent zapisz() {

        PracownikUEvent pracownikUEvent = new PracownikUEvent(
                wybranyPracownik,
                Integer.parseInt(liczbaNadgodzin.getText()),
                Integer.parseInt(liczbaJezykowObcych.getText()),
                wybranyTryb,
                wybranaUmiejetnosc);

        clear();

        return pracownikUEvent;
    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {
        this.wybranyPracownik = listPracownikow.get(0);
    }

    @Override
    public void aktualizuj() {

    }

}
