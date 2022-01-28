package com.labor.model;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.PracownikND;
import com.labor.model.observer.Obserwator;
import com.labor.model.observer.Podmiot;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;
import com.labor.model.observerKurs.ObserwatorKurs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Spis implements Podmiot, ObserwatorKurs, Serializable {

    private ArrayList<Kurs> listaKursow;
    private ArrayList<Student> listaStudentow;
    private ArrayList<Student> listaStypendystow;
    private ArrayList<Pracownik> listaPracownikow;
    private ArrayList<Obserwator> listaObserwatorow;

    public Spis() {
        this.listaKursow = new ArrayList<>();
        this.listaStudentow = new ArrayList<>();
        this.listaStypendystow = new ArrayList<>();
        this.listaPracownikow = new ArrayList<>();
        this.listaObserwatorow = new ArrayList<>();
    }

    public void aktualizacjaZmiennej() {
        powiadomObserwatora();
    }

    @Override
    public void aktualizuj(Student student) {
        if (student.getLiczbaNiezaliczen()==3) {
            listaStudentow.remove(student);
        } else if (student.getLiczbaWybitnychSrendnich()==3) {
            listaStypendystow.add(student);
            Collections.sort(listaStypendystow);
        }
        powiadomObserwatora();
    }

    @Override
    public void zarejestrujObserwatora(Obserwator obserwator) {
        listaObserwatorow.add(obserwator);
    }

    @Override
    public void usunObserwatora(Obserwator obserwator) {
        listaObserwatorow.remove(obserwator);
    }

    @Override
    public void powiadomObserwatora() {
        for (Obserwator obserwator : listaObserwatorow) {
            obserwator.aktualizacja(this);
        }
    }

    public void aktualizacjaStudent(Student student) {
        listaStudentow.add(student);
        powiadomObserwatora();
    }

    public void aktualizacjaKurs(Kurs kurs) {
        kurs.zarejestrujObserwatoraKurs(this);
        PracownikND wykladowca = (PracownikND) kurs.getWykladowca();
        wykladowca.dodajNowyKurs();
        if (wykladowca.getStrategiaWyplaty()!=null) {
            wykladowca.obliczWyplate();
        }
        listaKursow.add(kurs);
        powiadomObserwatora();
    }

    public void usunKurs(Kurs kurs) {
        PracownikND wykladowca = (PracownikND) kurs.getWykladowca();
        wykladowca.zakonczKurs();
        if (wykladowca.getStrategiaWyplaty()!=null) {
            wykladowca.obliczWyplate();
        }
        listaKursow.remove(kurs);
        powiadomObserwatora();
    }

    public void aktualizacjaPracownik(Pracownik pracownik) {
        listaPracownikow.add(pracownik);
        powiadomObserwatora();
    }

    public void setListaKursow(ArrayList<Kurs> listaKursow) {
        this.listaKursow = listaKursow;
    }

    public ArrayList<Kurs> getListaKursow() {
        return listaKursow;
    }

    public ArrayList<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    public ArrayList<Student> getListaStudentow() {
        return listaStudentow;
    }

    public ArrayList<Student> getListaStypendystow() {
        return listaStypendystow;
    }
}
