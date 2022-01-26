package com.labor.view.panel.zakladka.zakladkaKreator;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.PracownikU;
import com.labor.classes.osoba.Student;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaPracownik extends Zakladka<Pracownik> {

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
    private JLabel _numerID;
    private JTextField numerID;
    private JLabel _rodzajPracownika;
    private JComboBox<String> rodzajPracownika;
    private String wybranyRodzajPracownika;

    public ZakladkaPracownik() {
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
        _numerID = new JLabel("Numer ID");
        numerID = new JTextField(20);
        _rodzajPracownika = new JLabel("Rodzaj pracownika");
        rodzajPracownika = new JComboBox<>();

        konfigurujJComboBox();
        konfiguruj();
    }

    private void konfigurujJComboBox() {

        String[] rodzajePracownikow = {"Naukowo-dydaktyczny", "Uczelni"};

        for (String rodzaj : rodzajePracownikow) {
            rodzajPracownika.addItem(rodzaj);
        }

        rodzajPracownika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybranyRodzajPracownika = (String) rodzajPracownika.getSelectedItem();
            }
        });

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
        add(_numerID);
        add(numerID);
        add(_rodzajPracownika);
        add(rodzajPracownika);
    }

    private void clear() {
        imie.setText("");
        nazwisko.setText("");
        miejsceUrodzenia.setText("");
        dataUrodzenia.setText("");
        pesel.setText("");
        numerID.setText("");
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public Pracownik zapisz() {

        Pracownik pracownik = switch (wybranyRodzajPracownika) {
            case "Naukowo-dydaktyczny" -> new PracownikND(imie.getText(),
                    nazwisko.getText(),
                    miejsceUrodzenia.getText(),
                    Integer.parseInt(dataUrodzenia.getText()),
                    Integer.parseInt(pesel.getText()),
                    Integer.parseInt(numerID.getText()));
            case "Uczelni" -> new PracownikU(imie.getText(),
                    nazwisko.getText(),
                    miejsceUrodzenia.getText(),
                    Integer.parseInt(dataUrodzenia.getText()),
                    Integer.parseInt(pesel.getText()),
                    Integer.parseInt(numerID.getText()));
            default -> null;
        };

        clear();

        return pracownik;
    }

    @Override
    public void aktualizuj() {

    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {

    }
}
