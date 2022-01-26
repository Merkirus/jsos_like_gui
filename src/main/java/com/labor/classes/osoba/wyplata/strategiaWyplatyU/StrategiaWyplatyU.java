package com.labor.classes.osoba.wyplata.strategiaWyplatyU;

import com.labor.classes.osoba.wyplata.StrategiaWyplaty;

public interface StrategiaWyplatyU extends StrategiaWyplaty {
    double wyplata(int liczbaNadgodzin, int liczbaJezykowObcych, String trybPracy, String umiejetnosci);
}
