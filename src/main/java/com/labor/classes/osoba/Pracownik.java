package com.labor.classes.osoba;

import com.labor.classes.osoba.wyplata.StrategiaWyplaty;

public abstract class Pracownik<T> extends Osoba {

    private int numerID;
    protected StrategiaWyplaty strategiaWyplaty;
    protected double wyplata;

    public Pracownik(String imie, String nazwisko, String miejsceUrodzenia, int dataUrodzenia, int pesel, int numerID) {
        super(imie, nazwisko, miejsceUrodzenia, dataUrodzenia, pesel);
        this.numerID = numerID;
    }

    public abstract void obliczWyplate();

    public abstract void zmienStrategiaWyplaty(T strategiaWyplaty);

    public int getNumerID() {
        return numerID;
    }

    public double getWyplata() {
        return wyplata;
    }
}
