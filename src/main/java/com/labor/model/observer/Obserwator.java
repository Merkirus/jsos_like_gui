package com.labor.model.observer;

import com.labor.model.Spis;

import java.io.Serializable;


public interface Obserwator extends Serializable {
    void aktualizacja(Spis spis);
}
