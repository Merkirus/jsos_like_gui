package com.labor.classes.osoba.wyplata.strategiaWyplatyU;

public class UmiejetnosciU implements StrategiaWyplatyU {

    @Override
    public double wyplata(int liczbaNadgodzin, int liczbaJezykowObcych, String trybPracy, String umiejetnosci) {

        int odUmiejetnosci = 0;
        if (umiejetnosci.equals("Przeciętne")) { odUmiejetnosci = 100; }
        else if (umiejetnosci.equals("Dobre")) { odUmiejetnosci = 200; }
        else if (umiejetnosci.equals("Bardzo dobre")) { odUmiejetnosci = 300; }
        else if (umiejetnosci.equals("Wybitne")) { odUmiejetnosci = 400; }

        return 400*liczbaJezykowObcych + 800*odUmiejetnosci;
    }

    @Override
    public String toString() {
        return "Wypłata na podstawie kwalifikacji";
    }
}
