package com.labor.view.panel.zakladka.zakladkaListy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.events.OcenaEvent;
import com.labor.view.panel.zakladka.Zakladka;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ZakladkaWyswietlStud extends Zakladka<OcenaEvent> {


    private String flaga;
    private String flagaTrue = "true";
    private String flagaFalse = "false";

    private ZakladkaWyswietlStud obecnaKlasa = this;

    private JPanel panelKart;
    private Zakladka<OcenaEvent> panelDodajOcene;
    private JPanel panelOcena;
    private JPanel panelStudentow;

    private final String[] nazwyKolumnek = {
            "Imię",
            "Nazwisko",
            "Numer indeksu",
            "Rocznik",
            "Dodaj ocenę"
    };

    private DefaultTableModel modelek;
    private JTable tabela;

    private Student wybranyStudent;
    private ArrayList<Student> listaStudentow;
    private ArrayList<Student> wybranyStudentLista;
    private ArrayList<Kurs> listaKursow;

    public ZakladkaWyswietlStud() {
        super();
        tabela = new JTable();
        panelKart = new JPanel();
        panelKart.setLayout(new CardLayout());
        panelDodajOcene = new ZakladkaDodajOcene(this);

        konfigurujKarty();

        tabela.addMouseListener(new DodajOceneListener());
        przyciskZapisu.hide();
    }

    public void dodajTabeleczke() {
        modelek = new DefaultTableModel(null, nazwyKolumnek);
        modelek.addRow(nazwyKolumnek);
        tabela.setModel(modelek);

        panelStudentow.add(tabela);

        for (Student student : listaStudentow) {
            Object[] wiersz = {student.getImie(),
                    student.getNazwisko(),
                    student.getNumerIndeksu(),
                    student.getRocznik(),
                    student};
            modelek.addRow(wiersz);
        }
        repaint();
    }

    private void konfigurujKarty() {
        panelStudentow = new JPanel();
        panelOcena = new JPanel();

        panelKart.add(panelStudentow, flagaTrue);
        panelKart.add(panelDodajOcene, flagaFalse);

        add(panelKart);

        panelKart.setVisible(true);
    }

    @Override
    public OcenaEvent zapisz() {
        return null;
    }

    @Override
    public void aktualizuj() {
        dodajTabeleczke();
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {

    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {
        if (listaKursow!=null) {
            this.listaKursow = listaKursow;
            this.listaStudentow = listaKursow.get(0).getStudenci();
        } else {
            this.listaStudentow = new ArrayList<>();
        }
    }

    public void setFlaga(String flaga) {
        this.flaga = flaga;
        CardLayout cl = (CardLayout) (panelKart.getLayout());
        cl.show(panelKart, flaga);
    }

    public Zakladka<OcenaEvent> getPanelDodajOcene() {
        return panelDodajOcene;
    }

    class DodajOceneListener implements MouseListener {
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            flaga = flagaFalse;

            wybranyStudent = (Student) tabela.getValueAt(tabela.getSelectedRow(), 4);
            wybranyStudentLista = new ArrayList<>();
            wybranyStudentLista.add(wybranyStudent);

            CardLayout cl = (CardLayout) (panelKart.getLayout());
            cl.show(panelKart, flaga);

            panelDodajOcene.setListy(listaKursow, wybranyStudentLista, null);
            panelDodajOcene.aktualizuj();
            panelDodajOcene.setVisible(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }
    }
}
