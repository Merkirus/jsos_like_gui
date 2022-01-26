package com.labor.events;

import com.labor.classes.osoba.Pracownik;

public class PracownikUEvent {

    private Pracownik pracownik;
    private int liczbaNadgodzin;
    private String trybPracy;
    private String umiejetnosci;
    private int liczbaJezykowObcych;

    public PracownikUEvent(Pracownik pracownik, int liczbaNadgodzin, int liczbaJezykowObcych, String trybPracy, String umiejetnosci) {
        this.pracownik = pracownik;
        this.liczbaNadgodzin = liczbaNadgodzin;
        this.liczbaJezykowObcych = liczbaJezykowObcych;
        this.trybPracy = trybPracy;
        this.umiejetnosci = umiejetnosci;
    }

    public int getLiczbaJezykowObcych() {
        return liczbaJezykowObcych;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public int getLiczbaNadgodzin() {
        return liczbaNadgodzin;
    }

    public String getTrybPracy() {
        return trybPracy;
    }

    public String getUmiejetnosci() {
        return umiejetnosci;
    }
}
