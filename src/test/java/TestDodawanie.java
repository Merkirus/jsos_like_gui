import com.labor.classes.Kurs;
import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.Student;
import com.labor.model.Spis;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestDodawanie {

    Spis model;

    @BeforeEach
    void przygotujKlase() {
        model = new Spis();
    }

    @Test
    void dodajStudenta() {

        Student student = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 1);

        model.aktualizacjaStudent(student);

        assertTrue(model.getListaStudentow().contains(student));
    }

    @Test
    void dodajPracownika() {

        Pracownik pracownik = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13);

        model.aktualizacjaPracownik(pracownik);

        assertTrue(model.getListaPracownikow().contains(pracownik));
    }

    @Test
    void dodajKurs() {

        Pracownik pracownik = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13);

        Kurs kurs = new Kurs("Algebra", pracownik, 5);

        model.aktualizacjaKurs(kurs);

        assertTrue(model.getListaKursow().contains(kurs));
    }

    @Test
    void usunKurs() {

        Pracownik pracownik = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13);

        Kurs kurs = new Kurs("Algebra", pracownik, 5);

        model.aktualizacjaKurs(kurs);

        assertTrue(model.getListaKursow().contains(kurs));

        model.usunKurs(kurs);

        assertFalse(model.getListaKursow().contains(kurs));
    }

    @Test
    void sprawdzWykladowce() {

        Pracownik pracownik = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13);

        Kurs kurs = new Kurs("Algebra", pracownik, 5);

        model.aktualizacjaKurs(kurs);

        int i = model.getListaKursow().indexOf(kurs);

        assertEquals(pracownik, model.getListaKursow().get(i).getWykladowca());
    }

    @Test
    void sprawdzStudenta() {

        Student student = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 1);

        Pracownik pracownik = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13);

        Kurs kurs = new Kurs("Algebra", pracownik, 5);

        kurs.dodajStudenta(student);

        model.aktualizacjaKurs(kurs);

        int i = model.getListaKursow().indexOf(kurs);

        assertTrue(model.getListaKursow().get(i).getStudenci().contains(student));
    }

    @AfterEach
    void zniszczKlase() {
        model = null;
    }

}
