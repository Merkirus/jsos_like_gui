package com.labor.view;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.view.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class StronaGlowna extends JFrame {

    private static final int WYS = 300;
    private static final int SZE = 300;

    private JLabel uczelnia;
    private Kreator kreator;
    private Listy listy;
    private Ustawienia ustawienia;
    private JButton przyciskListy;
    private JButton przyciskKreator;
    private JButton przyciskUstawienia;

    public StronaGlowna() {
        setTitle("Nowy JSOS");
        this.uczelnia = new JLabel("Politechnika Wrocławska");

        uczelnia.setSize(WYS-30, SZE-30);

        Font labelFont = uczelnia.getFont();
        String labelText = uczelnia.getText();

        int stringWidth = uczelnia.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = uczelnia.getWidth();

        double widthRatio = (double)componentWidth / (double)stringWidth;

        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = uczelnia.getHeight();

        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        uczelnia.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));

        this.kreator = new Kreator();
        this.listy = new Listy();
        this.ustawienia = new Ustawienia();

        konfiguracja();
    }

    private void konfiguracja() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WYS, SZE);
        setVisible(true);
        setResizable(true);

        JPanel panelPoludnie = new JPanel();

        getContentPane().add(BorderLayout.SOUTH, panelPoludnie);

        przyciskUstawienia = new JButton("Ustawienia");
        przyciskKreator = new JButton("Kreator");
        przyciskListy = new JButton("Spis");

        uczelnia.setHorizontalAlignment(JLabel.CENTER);
        uczelnia.setVerticalAlignment(JLabel.CENTER);

        add(uczelnia);

        panelPoludnie.add(przyciskListy);
        panelPoludnie.add(przyciskKreator);
        panelPoludnie.add(przyciskUstawienia);
    }

    public void dodajOtworzUstawienia(ActionListener actionListener) {
        przyciskUstawienia.addActionListener(actionListener);
    }

    public void dodajOtworzListy(ActionListener actionListener) {
        przyciskListy.addActionListener(actionListener);
    }

    public void dodajOtworzKreator(ActionListener actionListener) {
        przyciskKreator.addActionListener(actionListener);
    }

    public void otworzUstawienia(ArrayList<Kurs> listaKursow,
                                 ArrayList<Student> listaStudentow,
                                 ArrayList<Student> listaStypendystow,
                                 ArrayList<Pracownik> listaPracownikow) {
        ustawienia.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        ustawienia.zrobGUI();
    }

    public void otworzListy(ArrayList<Kurs> listaKursow,
                                   ArrayList<Student> listaStudentow,
                                   ArrayList<Student> listaStypendystow,
                                   ArrayList<Pracownik> listaPracownikow) {
        listy.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        listy.zrobGUI();
    }

    public void otworzKreator(ArrayList<Kurs> listaKursow,
                              ArrayList<Student> listaStudentow,
                              ArrayList<Student> listaStypendystow,
                              ArrayList<Pracownik> listaPracownikow) {
        kreator.setListySpisu(listaKursow, listaStudentow, listaStypendystow, listaPracownikow);
        kreator.zrobGUI();
    }

    public void aktualizuj(ArrayList<Kurs> listaKursow,
                           ArrayList<Student> listaStudentow,
                           ArrayList<Student> listaSypendystow,
                           ArrayList<Pracownik> listaPracownikow) {
        kreator.setListySpisu(listaKursow, listaStudentow, listaSypendystow, listaPracownikow);
        kreator.aktualizuj();
        listy.setListySpisu(listaKursow, listaStudentow, listaSypendystow, listaPracownikow);
        listy.aktualizuj();
    }

    public Listy getListy() {
        return listy;
    }

    public Kreator getKreator() {
        return kreator;
    }

    public Ustawienia getUstawienia() {
        return ustawienia;
    }
}
