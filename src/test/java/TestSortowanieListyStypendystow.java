import com.labor.classes.osoba.Student;
import com.labor.model.Spis;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestSortowanieListyStypendystow {

    static ArrayList<Student> listaStypendystow;
    static Student student1;
    static Student student2;
    static Student student3;
    static Student student4;
    static Student student5;
    Spis model;

    @BeforeAll
    static void ustawKlasy() {

        student1 = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 1);
        student2 = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 2);
        student3 = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 3);
        student4 = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 4);
        student5 = new Student("Rafał", "Mielniczuk", "Duszniki", 2002, 123123, 13, 5);

        student1.dodajWybitnaSrednia();
        student1.dodajWybitnaSrednia();
        student1.dodajWybitnaSrednia();

        student2.dodajWybitnaSrednia();
        student2.dodajWybitnaSrednia();
        student2.dodajWybitnaSrednia();

        student3.dodajWybitnaSrednia();
        student3.dodajWybitnaSrednia();
        student3.dodajWybitnaSrednia();

        student4.dodajWybitnaSrednia();
        student4.dodajWybitnaSrednia();
        student4.dodajWybitnaSrednia();

        student5.dodajWybitnaSrednia();
        student5.dodajWybitnaSrednia();
        student5.dodajWybitnaSrednia();

        listaStypendystow = new ArrayList<>();

        listaStypendystow.add(student1);
        listaStypendystow.add(student2);
        listaStypendystow.add(student3);
        listaStypendystow.add(student4);
        listaStypendystow.add(student5);
    }

    @BeforeEach
    void ustawSpis() {
        model = new Spis();

        model.aktualizacjaStudent(student1);
        model.aktualizacjaStudent(student2);
        model.aktualizacjaStudent(student3);
        model.aktualizacjaStudent(student4);
        model.aktualizacjaStudent(student5);
    }

    @Test
    void posortowanaLista1() {
        model.aktualizuj(student4);
        model.aktualizuj(student1);
        model.aktualizuj(student5);
        model.aktualizuj(student3);
        model.aktualizuj(student2);

        assertEquals(listaStypendystow, model.getListaStypendystow());
    }

    @Test
    void posortowanaLista2() {
        model.aktualizuj(student5);
        model.aktualizuj(student3);
        model.aktualizuj(student1);
        model.aktualizuj(student4);
        model.aktualizuj(student2);

        assertEquals(listaStypendystow, model.getListaStypendystow());
    }

    @Test
    void posortowanaLista3() {
        model.aktualizuj(student1);
        model.aktualizuj(student5);
        model.aktualizuj(student2);
        model.aktualizuj(student3);
        model.aktualizuj(student4);

        assertEquals(listaStypendystow, model.getListaStypendystow());
    }

    @AfterEach
    void zniszczSpis() {
        model = null;
    }

    @AfterAll
    static void zniszczKlasy() {
        student1 = null;
        student2 = null;
        student3 = null;
        student4 = null;
        student5 = null;

        listaStypendystow = null;
    }
}
