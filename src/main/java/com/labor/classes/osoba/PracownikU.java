package com.labor.classes.osoba;

import com.labor.classes.osoba.wyplata.strategiaWyplatyU.StrategiaWyplatyU;

public class PracownikU extends Pracownik<StrategiaWyplatyU> {

    private int liczbaNadgodzin;
    private String trybPracy;
    private String umiejetnosci;
    private int liczbaJezykowObcych;

    public PracownikU(String imie, String nazwisko, String miejsceUrodzenia, int dataUrodzenia, int pesel, int numerID) {
        super(imie, nazwisko, miejsceUrodzenia, dataUrodzenia, pesel, numerID);
    }

    @Override
    public void zmienStrategiaWyplaty(StrategiaWyplatyU strategiaWyplaty) {
        this.strategiaWyplaty = strategiaWyplaty;
    }

    @Override
    public void obliczWyplate() {
        this.wyplata = ((StrategiaWyplatyU) strategiaWyplaty).wyplata(liczbaNadgodzin, liczbaJezykowObcych, trybPracy, umiejetnosci);
    }

    public void setLiczbaJezykowObcych(int liczbaJezykowObcych) {
        this.liczbaJezykowObcych = liczbaJezykowObcych;
    }

    public void setLiczbaNadgodzin(int liczbaNadgodzin) {
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    public void setTrybPracy(String trybPracy) {
        this.trybPracy = trybPracy;
    }

    public void setUmiejetnosci(String umiejetnosci) {
        this.umiejetnosci = umiejetnosci;
    }
}
