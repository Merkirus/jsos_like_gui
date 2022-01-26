package com.labor.classes.osoba.wyplata.strategiaWyplatyND;

import com.labor.classes.osoba.wyplata.StrategiaWyplaty;

public interface StrategiaWyplatyND extends StrategiaWyplaty {
    double wyplata(int listaKursow, int liczbaNadgodzin, int liczbaPublikacji);
}
