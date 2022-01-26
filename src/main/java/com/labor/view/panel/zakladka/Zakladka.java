package com.labor.view.panel.zakladka;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public abstract class Zakladka<T> extends JPanel {

    protected JButton przyciskZapisu;

    public Zakladka() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        przyciskZapisu = new JButton("Zapisz");
        add(przyciskZapisu);
    }

    public abstract T zapisz();

    public abstract void dodajZapiszListener(ActionListener actionListener);

    public abstract void aktualizuj();

    public abstract void setListy(ArrayList<Kurs> listaKursow,
                                  ArrayList<Student> listaStudentow,
                                  ArrayList<Pracownik> listPracownikow);

}
