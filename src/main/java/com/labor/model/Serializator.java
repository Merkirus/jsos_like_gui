package com.labor.model;

import com.labor.model.observer.Obserwator;
import com.labor.model.observer.Podmiot;

import java.io.*;


public class Serializator implements Obserwator {

    private Spis spis;
    private Podmiot podmiot;

    public Serializator() {

    }

    public void setObserwator(Podmiot podmiot) {
        this.podmiot = podmiot;
        podmiot.zarejestrujObserwatora(this);
    }

    @Override
    public void aktualizacja(Spis spis) {
        this.spis = spis;
        zapisz();
    }

    public void zapisz() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("dane/Spis.ser"))) {

            os.writeObject(spis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Spis wczytajDane() {

        File plik = new File("dane/Spis.ser");

        if (plik.length() != 0L) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(plik))) {

                return (Spis) is.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Spis();
    }

}
