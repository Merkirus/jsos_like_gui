package com.labor.view.panel.listy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.events.PracownikNDEvent;
import com.labor.events.PracownikUEvent;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WidokPracownikaND extends Zakladka<PracownikNDEvent> {

    private JLabel _liczbaPublikacji;
    private JLabel _liczbaNadgodzin;

    private JTextField liczbaPublikacji;
    private JTextField liczbaNadgodzin;

    private JButton zakoncz;

    private Pracownik wybranyPracownik;

    private ListaPracownikow listaPracownikow;

    public WidokPracownikaND(ListaPracownikow listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
        _liczbaNadgodzin = new JLabel("Liczba nadgodzin");
        _liczbaPublikacji = new JLabel("Liczba publikacji");
        liczbaNadgodzin = new JTextField(20);
        liczbaPublikacji = new JTextField(20);

        zakoncz = new JButton("X");
        zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPracownikow.setFlaga("true");
            }
        });

        konfiguruj();
    }

    private void konfiguruj() {
        add(_liczbaPublikacji);
        add(liczbaPublikacji);
        add(_liczbaNadgodzin);
        add(liczbaNadgodzin);
        add(zakoncz);
        zakoncz.setHorizontalAlignment(JButton.CENTER);
        zakoncz.setVerticalAlignment(JButton.CENTER);
    }

    private void clear() {
        liczbaPublikacji.setText("");
        liczbaNadgodzin.setText("");
    }

    public void zrobGUI() {
        setVisible(true);
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public PracownikNDEvent zapisz() {

        PracownikNDEvent pracownikNDEvent = new PracownikNDEvent(wybranyPracownik,
                Integer.parseInt(liczbaNadgodzin.getText()),
                Integer.parseInt(liczbaPublikacji.getText())
        );

        clear();

        return pracownikNDEvent;
    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {
        this.wybranyPracownik = listPracownikow.get(0);
    }

    @Override
    public void aktualizuj() {

    }
}
