package com.labor.classes.osoba.wyplata.strategiaWyplatyU;

public class CzasPracyU implements StrategiaWyplatyU {

    @Override
    public double wyplata(int liczbaNadgodzin, int liczbaJezykowObcych, String trybPracy, String umiejetnosci) {

        int odTrybu = 0;

        if (trybPracy.equals("Poranny")) { odTrybu = 200; }
        else if (trybPracy.equals("Popołudniowy")) { odTrybu = 200; }
        else if (trybPracy.equals("Wieczorny")) { odTrybu = 400; }
        else if (trybPracy.equals("Nocny")) { odTrybu = 800; }

        return 100*liczbaNadgodzin + 4*odTrybu;
    }

    @Override
    public String toString() {
        return "Wypłata na podstawie czasu pracy";
    }
}
