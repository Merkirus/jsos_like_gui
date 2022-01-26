package com.labor.classes.osoba;

public class Student extends Osoba implements Comparable<Student> {

    private int numerIndeksu;
    private int rocznik;

    private int liczbaNiezaliczen = 0;
    private int liczbaWybitnychSrendnich = 0;

    public Student(String imie, String nazwisko, String miejsceUrodzenia, int dataUrodzenia, int pesel, int numerIndeksu, int rocznik) {
        super(imie, nazwisko, miejsceUrodzenia, dataUrodzenia, pesel);
        this.numerIndeksu = numerIndeksu;
        this.rocznik = rocznik;
    }

    @Override
    public int compareTo(Student o) {
        if (rocznik < o.getRocznik()) return -1;
        if (rocznik > o.getRocznik()) return 1;
        return 0;
    }

    public int getRocznik() {
        return rocznik;
    }

    public int getLiczbaWybitnychSrendnich() {
        return liczbaWybitnychSrendnich;
    }

    public void dodajWybitnaSrednia() {
        liczbaWybitnychSrendnich++;
    }

    public int getLiczbaNiezaliczen() {
        return liczbaNiezaliczen;
    }

    public void dodajNiezaliczenie() {
        liczbaNiezaliczen++;
    }

    public int getNumerIndeksu() {
        return numerIndeksu;
    }
}
