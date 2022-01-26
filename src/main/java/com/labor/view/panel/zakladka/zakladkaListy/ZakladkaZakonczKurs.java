package com.labor.view.panel.zakladka.zakladkaListy;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.view.panel.zakladka.Zakladka;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZakladkaZakonczKurs extends Zakladka<Kurs> {

    private Kurs obecnyKurs;

    public ZakladkaZakonczKurs() {
        super();
        przyciskZapisu.setText("Zakończ");
    }

    @Override
    public Kurs zapisz() {
        return obecnyKurs;
    }

    @Override
    public void dodajZapiszListener(ActionListener actionListener) {
        przyciskZapisu.addActionListener(actionListener);
    }

    @Override
    public void setListy(ArrayList<Kurs> listaKursow, ArrayList<Student> listaStudentow, ArrayList<Pracownik> listPracownikow) {
        if (listaKursow!=null) {
            this.obecnyKurs = listaKursow.get(0);
        }
    }

    @Override
    public void aktualizuj() {

    }
}
