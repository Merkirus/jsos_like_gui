package com.labor.controller;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.PracownikU;
import com.labor.classes.osoba.Student;
import com.labor.classes.osoba.wyplata.StrategiaWyplaty;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.StrategiaWyplatyND;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.StrategiaWyplatyU;
import com.labor.events.OcenaEvent;
import com.labor.events.PracownikNDEvent;
import com.labor.events.PracownikUEvent;
import com.labor.events.StudentEvent;
import com.labor.view.StronaGlowna;
import com.labor.model.Spis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Kontroler {

    private StronaGlowna view;
    private Spis model;

    public Kontroler(StronaGlowna view, Spis model) {
        this.view = view;
        this.model = model;

        view.dodajOtworzKreator(new OtworzKreator());
        view.dodajOtworzListy(new OtworzListy());
        view.dodajOtworzUstawienia(new OtworzUstawienia());
        view.getKreator().getPanelStudent().dodajZapiszListener(new DodajStudenta());
        view.getKreator().getPanelKurs().dodajZapiszListener(new ZaktualizujListeKursow());
        view.getKreator().getPanelPracownik().dodajZapiszListener(new DodajPracownika());
        view.getUstawienia().getPanelND().dodajZapiszListener(new WybierzStrategieND());
        view.getUstawienia().getPanelU().dodajZapiszListener(new WybierzStrategieU());
        view.getListy().getWidokKursow().dodajOceneListener(new DodajOceneStudentowi());
        view.getListy().getWidokKursow().dodajStudentaListener(new DodajStudentaDoKursu());
        view.getListy().getWidokKursow().dodajZakonczKursListener(new ZakonczKurs());
        view.getListy().getWidokPracownikow().dodajAktualizujNDListener(new AktualizujPracownikaND());
        view.getListy().getWidokPracownikow().dodajAktualizujUListener(new AktualizujPraconwikaU());
    }

    class OtworzListy implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.otworzListy(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class OtworzKreator implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.otworzKreator(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class OtworzUstawienia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.otworzUstawienia(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class ZaktualizujListeKursow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Kurs dane = (Kurs) view.getKreator().getPanelKurs().zapisz();
            model.aktualizacjaKurs(dane);
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class DodajPracownika implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Pracownik pracownik = (Pracownik) view.getKreator().getPanelPracownik().zapisz();
            model.aktualizacjaPracownik(pracownik);
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class DodajStudenta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = (Student) view.getKreator().getPanelStudent().zapisz();
            model.aktualizacjaStudent(student);
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class DodajStudentaDoKursu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StudentEvent dane = (StudentEvent) view.getListy().getWidokKursow().dodajStudentaDoKursu();
            Student student = dane.getStudent();
            Kurs kurs = dane.getKurs();
            int i = model.getListaKursow().indexOf(kurs);
            model.getListaKursow().get(i).dodajStudenta(student);
            model.aktualizacjaZmiennej();
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class AktualizujPracownikaND implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            PracownikNDEvent pracownikNDEvent = view.getListy().getWidokPracownikow().zapiszPracownikND();

            Pracownik pracownik = pracownikNDEvent.getPracownik();

            int i = model.getListaPracownikow().indexOf(pracownik);

            ((PracownikND) model.getListaPracownikow().get(i)).setLiczbaPublikacja(pracownikNDEvent.getLiczbaPublikacja());
            ((PracownikND) model.getListaPracownikow().get(i)).setLiczbaNadgodzin(pracownikNDEvent.getLiczbaNadgodzin());

            model.getListaPracownikow().get(i).obliczWyplate();

            model.aktualizacjaZmiennej();
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class AktualizujPraconwikaU implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            PracownikUEvent pracownikUEvent = view.getListy().getWidokPracownikow().zapiszPracownikaU();

            Pracownik pracownik = pracownikUEvent.getPracownik();

            int i = model.getListaPracownikow().indexOf(pracownik);

            ((PracownikU) model.getListaPracownikow().get(i)).setUmiejetnosci(pracownikUEvent.getUmiejetnosci());
            ((PracownikU) model.getListaPracownikow().get(i)).setTrybPracy(pracownikUEvent.getTrybPracy());
            ((PracownikU) model.getListaPracownikow().get(i)).setLiczbaNadgodzin(pracownikUEvent.getLiczbaNadgodzin());
            ((PracownikU) model.getListaPracownikow().get(i)).setLiczbaJezykowObcych(pracownikUEvent.getLiczbaJezykowObcych());

            model.getListaPracownikow().get(i).obliczWyplate();

            model.aktualizacjaZmiennej();
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class WybierzStrategieND implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            StrategiaWyplatyND strategiaWyplatyND = view.getUstawienia().getPanelND().zapisz();

            for (Pracownik pracownik : model.getListaPracownikow()) {
                if (pracownik instanceof PracownikND) {
                    pracownik.zmienStrategiaWyplaty(strategiaWyplatyND);
                    pracownik.obliczWyplate();
                }
            }

            model.aktualizacjaZmiennej();
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class WybierzStrategieU implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            StrategiaWyplatyU strategiaWyplatyU = view.getUstawienia().getPanelU().zapisz();

            for (Pracownik pracownik : model.getListaPracownikow()) {
                if (pracownik instanceof PracownikU) {
                    pracownik.zmienStrategiaWyplaty(strategiaWyplatyU);
                    pracownik.obliczWyplate();
                }
            }

            model.aktualizacjaZmiennej();
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

    class DodajOceneStudentowi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            OcenaEvent ocenaEvent = view.getListy().getWidokKursow().zapiszOcene();

            Kurs kurs = ocenaEvent.getKurs();
            Student student = ocenaEvent.getStudent();
            int ocena = ocenaEvent.getOcena();
            int i = model.getListaKursow().indexOf(kurs);
            model.getListaKursow().get(i).dajOcene(student, ocena);
            model.aktualizacjaZmiennej();
        }
    }

    class ZakonczKurs implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Kurs kurs = view.getListy().getWidokKursow().zakonczKurs();
            ArrayList<Student> listaStudentow = kurs.getStudenci();

            for (Student student : listaStudentow) {
                kurs.sprawdzCzyStudentZdal(student);
            }
            model.usunKurs(kurs);
            view.aktualizuj(model.getListaKursow(), model.getListaStudentow(), model.getListaStypendystow(), model.getListaPracownikow());
        }
    }

}
