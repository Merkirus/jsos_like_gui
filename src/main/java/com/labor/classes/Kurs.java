package com.labor.classes;

import com.labor.classes.osoba.Osoba;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.Student;
import com.labor.model.observerKurs.ObserwatorKurs;
import com.labor.model.observerKurs.PodmiotKurs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Kurs implements Serializable, PodmiotKurs {

    private String nazwaKursu;
    private int ects;
    private Pracownik wykladowca;
    private ArrayList<Student> studenci;
    private HashMap<Student, ArrayList<Integer>> dziennik;

    private ObserwatorKurs obserwatorKurs;

    public Kurs(String nazwaKursu, Pracownik wykladowca, int ects) {
        this.studenci = new ArrayList<>();
        this.dziennik = new HashMap<>();
        this.nazwaKursu = nazwaKursu;
        this.wykladowca = wykladowca;
        this.ects = ects;
    }

    public void dajOcene(Student student, int ocena) {
        dziennik.get(student).add(ocena);
    }

    public double wyciagnijSredniaOcen(Student student) {
        double srednia = 0;
        int iloscOcen = 0;
        for (Integer ocena : dziennik.get(student)) {
            srednia+=ocena;
            iloscOcen++;
        }
        return srednia/iloscOcen;
    }

    public void sprawdzCzyStudentZdal(Student student) {
        if (wyciagnijSredniaOcen(student)>=5) {
            student.dodajWybitnaSrednia();
        } else if (wyciagnijSredniaOcen(student)<3) {
            student.dodajNiezaliczenie();
        }
        powiadomObserwatoraKurs(student);
    }

    @Override
    public void zarejestrujObserwatoraKurs(ObserwatorKurs obserwator) {
        obserwatorKurs = obserwator;
    }

    @Override
    public void powiadomObserwatoraKurs(Student student) {
        obserwatorKurs.aktualizuj(student);
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public int getEcts() {
        return ects;
    }

    public void dodajStudenta(Student student) {
        if (!studenci.contains(student)) {
            studenci.add(student);
            dziennik.put(student, new ArrayList<>());
        }
    }

    public ArrayList<Student> getStudenci() {
        return studenci;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public void setStudenci(ArrayList<Student> studenci) {
        this.studenci = studenci;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public Pracownik getWykladowca() {
        return wykladowca;
    }

    public void setWykladowca(Pracownik wykladowca) {
        this.wykladowca = wykladowca;
    }

    public HashMap<Student, ArrayList<Integer>> getDziennik() {
        return dziennik;
    }
}
