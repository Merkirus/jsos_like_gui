package com.labor.view.panel.listy;

import com.labor.classes.osoba.Student;

import java.util.Collections;

public class ListaStypendystow extends ListaAbstract {

    public ListaStypendystow() {
        nazwyKolumn = new Object[]{
                "Imię",
                "Nazwisko",
                "Numer indeksu",
                "Rocznik"
        };
    }

    @Override
    public void dodajTabelke() {
        super.dodajTabelke();

        for (Student student : listaStypendystow) {
            Object[] wiersz = {student.getImie(), student.getNazwisko(), student.getNumerIndeksu(), student.getRocznik()};
            model.addRow(wiersz);
        }
        repaint();
    }

    @Override
    public void aktualizuj() {
        dodajTabelke();
    }
}
