package com.labor.view.panel.listy;

import com.labor.classes.osoba.Student;

public class ListaStudentow extends ListaAbstract {

    public ListaStudentow() {

        nazwyKolumn = new Object[] {
                "Imię",
                "Nazwisko",
                "Numer indeksu",
                "Rocznik"
        };
    }

    @Override
    public void dodajTabelke() {
        super.dodajTabelke();

        for (Student student : listaStudentow) {
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
