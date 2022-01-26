package com.labor.classes.osoba.wyplata.strategiaWyplatyND;

public class CzasPracyND implements StrategiaWyplatyND {
    @Override
    public double wyplata(int liczbaKursow, int licznaNadgodzin, int liczbaPublikacji) {
        return 500*liczbaKursow + 100*licznaNadgodzin;
    }

    @Override
    public String toString() {
        return "Wypłata na podstawie czasu pracy";
    }
}
