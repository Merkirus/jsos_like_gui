package com.labor.view.panel.listy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public abstract class ListaAbstract extends JPanel {

    protected Object[] nazwyKolumn;

    protected DefaultTableModel model;
    protected JTable tabelka;

    protected ArrayList<Kurs> listaKursow;
    protected ArrayList<Student> listaStudentow;
    protected ArrayList<Student> listaStypendystow;
    protected ArrayList<Pracownik> listaPracownikow;

    public ListaAbstract() {
        tabelka = new JTable();
    }

    public void dodajTabelke() {
        model = new DefaultTableModel(null, nazwyKolumn);
        model.addRow(nazwyKolumn);
        tabelka.setModel(model);
        add(tabelka);
    }

    public void dodajMouseListener(MouseListener mouseListener) {
        tabelka.addMouseListener(mouseListener);
    }

    public void setListySpisu(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Student> listaStypendystow, ArrayList<Pracownik> listaPracownikow) {
        this.listaKursow = listaKursow;
        this.listaStudentow = listaStudentow;
        this.listaStypendystow = listaStypendystow;
        this.listaPracownikow = listaPracownikow;
        if (listaKursow==null) {
            this.listaKursow = new ArrayList<>();
        }
        if (listaStudentow==null) {
            this.listaStudentow = new ArrayList<>();
        }
        if (listaStypendystow==null) {
            this.listaStypendystow = new ArrayList<>();
        }
        if (listaPracownikow==null) {
            this.listaPracownikow = new ArrayList<>();
        }
    }

    public abstract void aktualizuj();

    abstract class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            wykonaj();
        }
        public abstract void wykonaj();
    }

}
