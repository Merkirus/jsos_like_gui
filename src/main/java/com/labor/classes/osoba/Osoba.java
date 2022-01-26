package com.labor.classes.osoba;

import java.io.Serializable;

public abstract class Osoba implements Serializable {

    private String imie;
    private String nazwisko;
    private String miejsceUrodzenia;
    private int dataUrodzenia;
    private int pesel;

    public Osoba(String imie, String nazwisko, String miejsceUrodzenia, int dataUrodzenia, int pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miejsceUrodzenia = miejsceUrodzenia;
        this.dataUrodzenia = dataUrodzenia;
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getMiejsceUrodzenia() {
        return miejsceUrodzenia;
    }

    public int getDataUrodzenia() {
        return dataUrodzenia;
    }

    public int getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", miejsceUrodzenia='" + miejsceUrodzenia + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", pesel=" + pesel +
                '}';
    }
}
