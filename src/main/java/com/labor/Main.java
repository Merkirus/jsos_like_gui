package com.labor;

import com.labor.model.Serializator;
import com.labor.view.StronaGlowna;
import com.labor.controller.Kontroler;
import com.labor.model.Spis;

public class Main {

    public static void main(String[] args) {
        Spis model = new Spis();
        Serializator serializator = new Serializator();
        model = serializator.wczytajDane();
        serializator.setObserwator(model);
        StronaGlowna view = new StronaGlowna();
        Kontroler kontroler = new Kontroler(view, model);
    }
}
