package com.labor.events;

import com.labor.classes.osoba.Pracownik;

public class PracownikNDEvent {

    private Pracownik pracownik;
    private int liczbaPublikacja;
    private int liczbaNadgodzin;

    public PracownikNDEvent(Pracownik pracownik, int liczbaNadgodzin, int liczbaPublikacja) {
        this.pracownik = pracownik;
        this.liczbaNadgodzin = liczbaNadgodzin;
        this.liczbaPublikacja = liczbaPublikacja;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public int getLiczbaNadgodzin() {
        return liczbaNadgodzin;
    }

    public int getLiczbaPublikacja() {
        return liczbaPublikacja;
    }
}
