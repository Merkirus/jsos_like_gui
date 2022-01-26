package com.labor.classes.osoba.wyplata.strategiaWyplatyND;

public class UmiejetnosciND implements StrategiaWyplatyND {
    @Override
    public double wyplata(int liczbaKursow, int liczbaNadgodzin, int liczbaPublikacji) {
        return 2000*liczbaPublikacji;
    }

    @Override
    public String toString() {
        return "Wypłata na podstawie kwalifikacji";
    }
}
