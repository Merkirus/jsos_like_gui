package com.labor.events;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Student;

public class OcenaEvent {

    private Student student;
    private Kurs kurs;
    private int ocena;

    public OcenaEvent(Student student, Kurs kurs, int ocena) {
        this.student = student;
        this.kurs = kurs;
        this.ocena = ocena;
    }

    public Student getStudent() {
        return student;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public int getOcena() {
        return ocena;
    }
}
