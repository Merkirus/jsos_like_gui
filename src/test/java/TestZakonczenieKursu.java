import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.Student;
import com.labor.model.Spis;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestZakonczenieKursu {

    Kurs kurs;
    Student student;
    Spis model;
    Pracownik pracownik;

    @BeforeEach
    void ustawKlasy() {
        model = new Spis();
        pracownik = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 121212, 13);
        kurs = new Kurs("Analiza matematyczna", pracownik, 6);
        student = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 1);
    }

    @Test
    void zakonczKurs() {

        model.aktualizacjaPracownik(pracownik);

        model.aktualizacjaKurs(kurs);

        assertEquals(1, ((PracownikND) kurs.getWykladowca()).getLiczbaProwadzonychKursow());

        int i  = model.getListaPracownikow().indexOf(pracownik);

        assertEquals(1, ((PracownikND) model.getListaPracownikow().get(i)).getLiczbaProwadzonychKursow());

        model.usunKurs(kurs);

        assertEquals(0, model.getListaKursow().size());

        assertEquals(0, ((PracownikND) model.getListaPracownikow().get(i)).getLiczbaProwadzonychKursow());
    }

    @Test
    void wyrzucenieStudenta() {

        model.aktualizacjaStudent(student);

        model.aktualizacjaKurs(kurs);

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 2);
        kurs.dajOcene(student, 2);

        kurs.sprawdzCzyStudentZdal(student);

        assertEquals(1, student.getLiczbaNiezaliczen());

        kurs = new Kurs("Algebra", pracownik, 2);

        model.aktualizacjaKurs(kurs);

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 2);
        kurs.dajOcene(student, 2);

        kurs.sprawdzCzyStudentZdal(student);

        kurs = new Kurs("Logika", pracownik, 3);

        model.aktualizacjaKurs(kurs);

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 2);
        kurs.dajOcene(student, 2);

        kurs.sprawdzCzyStudentZdal(student);

        // Dla 3 student zostaje wyrzucony
        assertEquals(3, student.getLiczbaNiezaliczen());

        assertEquals(0, model.getListaStudentow().size());
    }

    @Test
    void proponowanieStypendystow() {

        model.aktualizacjaStudent(student);

        model.aktualizacjaKurs(kurs);

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 5);
        kurs.dajOcene(student, 5);

        kurs.sprawdzCzyStudentZdal(student);

        assertEquals(1, student.getLiczbaWybitnychSrendnich());

        kurs = new Kurs("Algebra", pracownik, 2);

        model.aktualizacjaKurs(kurs);

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 5);
        kurs.dajOcene(student, 5);

        kurs.sprawdzCzyStudentZdal(student);

        kurs = new Kurs("Logika", pracownik, 3);

        model.aktualizacjaKurs(kurs);

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 5);
        kurs.dajOcene(student, 5);

        kurs.sprawdzCzyStudentZdal(student);

        // Dla 3 student staje się stypendtystą
        assertEquals(3, student.getLiczbaWybitnychSrendnich());

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student);

        assertEquals(arrayList, model.getListaStypendystow());
    }

    @AfterEach
    void zniszczKlasy() {

        kurs = null;
        student = null;
        model = null;

    }

}
