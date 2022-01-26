package com.labor.events;

import com.labor.classes.Kurs;
import com.labor.classes.osoba.Student;

public class StudentEvent {

    private Student student;
    private Kurs kurs;

    public StudentEvent(Student student, Kurs kurs) {
        this.student = student;
        this.kurs = kurs;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public Student getStudent() {
        return student;
    }
}
