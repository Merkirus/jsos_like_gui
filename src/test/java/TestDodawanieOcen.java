import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TestDodawanieOcen {

    Kurs kurs;
    Student student;

    @BeforeEach
    void ustawKlasy() {
        Pracownik pracownikND = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 121212, 13);
        kurs = new Kurs("Analiza matematyczna", pracownikND, 6);
        student = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 1);
    }

    @Test
    void dodajOcene() {

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 5);
        kurs.dajOcene(student, 4);

        HashMap<Student, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(4);
        map.put(student, arrayList);

        assertEquals(map, kurs.getDziennik());
    }

    @Test
    void sredniaOcen() {

        kurs.dodajStudenta(student);

        kurs.dajOcene(student, 5);
        kurs.dajOcene(student, 4);
        kurs.dajOcene(student, 3);

        int result = (3+4+5)/3;

        assertEquals(result, kurs.wyciagnijSredniaOcen(student));
    }

    @AfterEach
    void zniszczKlasy() {

        kurs = null;
        student = null;

    }

}
