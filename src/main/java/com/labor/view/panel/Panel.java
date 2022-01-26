package com.labor.view.panel;


import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.Student;

import java.util.ArrayList;

public interface Panel {

    void zrobGUI();

    void setListySpisu(ArrayList<Kurs> listaKursow,
                       ArrayList<Student> listaStudentow,
                       ArrayList<Student> listaStypendystow,
                       ArrayList<Pracownik> listaPracownikow);


    void aktualizuj();

}
