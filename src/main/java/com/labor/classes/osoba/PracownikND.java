package com.labor.classes.osoba;

import com.labor.classes.osoba.wyplata.StrategiaWyplaty;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.StrategiaWyplatyND;

public class PracownikND extends Pracownik<StrategiaWyplatyND> {

    private int liczbaPublikacja;
    private int liczbaNadgodzin;
    private int liczbaProwadzonychKursow;

    public PracownikND(String imie, String nazwisko, String miejsceUrodzenia, int dataUrodzenia, int pesel, int numerID) {
        super(imie, nazwisko, miejsceUrodzenia, dataUrodzenia, pesel, numerID);
    }

    @Override
    public void zmienStrategiaWyplaty(StrategiaWyplatyND strategiaWyplaty) {
        this.strategiaWyplaty = strategiaWyplaty;
        this.wyplata = strategiaWyplaty.wyplata(liczbaProwadzonychKursow, liczbaNadgodzin, liczbaPublikacja);
    }

    @Override
    public void obliczWyplate() {
        this.wyplata = ((StrategiaWyplatyND) strategiaWyplaty).wyplata(liczbaProwadzonychKursow, liczbaNadgodzin, liczbaPublikacja);
    }

    public void dodajNowyKurs() {
        liczbaProwadzonychKursow++;
    }

    public void zakonczKurs() {
        liczbaProwadzonychKursow--;
    }

    public void setLiczbaNadgodzin(int liczbaNadgodzin) {
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    public void setLiczbaPublikacja(int liczbaPublikacja) {
        this.liczbaPublikacja = liczbaPublikacja;
    }

    public int getLiczbaProwadzonychKursow() {
        return liczbaProwadzonychKursow;
    }
}
