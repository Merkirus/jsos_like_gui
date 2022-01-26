package com.labor.view.panel.zakladka.zakladkaKreator;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaStudent extends Zakladka<Student> {

    private JLabel _imie;
    private JTextField imie;
    private JLabel _nazwisko;
    private JTextField nazwisko;
    private JLabel _miejsceUrodzenia;
    private JTextField miejsceUrodzenia;
    private JLabel _dataUrodznenia;
    private JTextField dataUrodzenia;
    private JLabel _pesel;
    private JTextField pesel;
    private JLabel _numerIndeksu;
    private JTextField numerIndeksu;
    private JLabel _rocznik;
    private JTextField rocznik;

    public ZakladkaStudent() {
        super();
        _imie = new JLabel("Imię");
        imie = new JTextField(20);
        _nazwisko = new JLabel("Nazwisko");
        nazwisko = new JTextField(20);
        _miejsceUrodzenia = new JLabel("Miejsce urodzenia");
        miejsceUrodzenia = new JTextField(20);
        _dataUrodznenia = new JLabel("Data urodzenia");
        dataUrodzenia = new JTextField(20);
        _pesel = new JLabel("Pesel");
        pesel = new JTextField(20);
        _numerIndeksu = new JLabel("Numer indeksu");
        numerIndeksu = new JTextField(20);
        _rocznik = new JLabel("Rocznik");
        rocznik = new JTextField(20);

        konfiguruj();
    }


    private void konfiguruj() {
        add(_imie);
        add(imie);
        add(_nazwisko);
        add(nazwisko);
        add(_miejsceUrodzenia);
        add(miejsceUrodzenia);
        add(_dataUrodznenia);
        add(dataUrodzenia);
        add(_pesel);
        add(pesel);
        add(_numerIndeksu);
        add(numerIndeksu);
        add(_rocznik);
        add(rocznik);
    }

    private void clear() {
        imie.setText("");
        nazwisko.setText("");
        miejsceUrodzenia.setText("");
        dataUrodzenia.setText("");
        pesel.setText("");
        numerIndeksu.setText("");
        rocznik.setText("");
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public Student zapisz() {

        Student student = new Student(
                imie.getText(),
                nazwisko.getText(),
                miejsceUrodzenia.getText(),
                Integer.parseInt(dataUrodzenia.getText()),
                Integer.parseInt(pesel.getText()),
                Integer.parseInt(numerIndeksu.getText()),
                Integer.parseInt(rocznik.getText()));

        clear();

        return student;
    }

    @Override
    public void aktualizuj() {

    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {

    }
}
