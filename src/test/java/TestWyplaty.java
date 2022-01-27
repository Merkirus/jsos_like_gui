import com.labor.classes.osoba.Pracownik;
import com.labor.classes.osoba.PracownikND;
import com.labor.classes.osoba.PracownikU;
import com.labor.classes.osoba.wyplata.StrategiaWyplaty;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.CzasPracyND;
import com.labor.classes.osoba.wyplata.strategiaWyplatyND.UmiejetnosciND;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.CzasPracyU;
import com.labor.classes.osoba.wyplata.strategiaWyplatyU.UmiejetnosciU;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWyplaty {

    Pracownik pracownikND;
    Pracownik pracownikU;

    StrategiaWyplaty strategiaWyplaty;

    @BeforeEach
    void ustawPracownikow() {
        pracownikND = new PracownikND("Rafał", "Mielniczuk", "Duszniki", 2002, 121212, 13);
        pracownikU = new PracownikU("Rafał", "Mielniczuk", "Duszniki", 2002, 121212, 13);
    }

    @Test
    void ustawStrategieCzasuND() {

        strategiaWyplaty = new CzasPracyND();

        ((PracownikND) pracownikND).dodajNowyKurs();
        ((PracownikND) pracownikND).dodajNowyKurs();

        ((PracownikND) pracownikND).setLiczbaNadgodzin(20);

        int result = 500*2 + 100*20;

        pracownikND.zmienStrategiaWyplaty(strategiaWyplaty);

        pracownikND.obliczWyplate();

        assertEquals(result, pracownikND.getWyplata());

        ((PracownikND) pracownikND).zakonczKurs();

        pracownikND.obliczWyplate();

        result = 500 + 100*20;

        assertEquals(result, pracownikND.getWyplata());
    }

    @Test
    void ustawStrategieUmiejetnosciND() {

        strategiaWyplaty = new UmiejetnosciND();

        ((PracownikND) pracownikND).setLiczbaPublikacja(5);

        int result = 2000*5;

        pracownikND.zmienStrategiaWyplaty(strategiaWyplaty);

        pracownikND.obliczWyplate();

        assertEquals(result, pracownikND.getWyplata());
    }

    @Test
    void ustawStrategieCzasuU() {

        strategiaWyplaty = new CzasPracyU();

        ((PracownikU) pracownikU).setLiczbaNadgodzin(50);
        ((PracownikU) pracownikU).setTrybPracy("Popołudniowy");

        pracownikU.zmienStrategiaWyplaty(strategiaWyplaty);
        pracownikU.obliczWyplate();

        // Popołudniowy = 200
        int result = 100*50 + 50*200;

        assertEquals(result, pracownikU.getWyplata());

        ((PracownikU) pracownikU).setTrybPracy("Nocny");

        pracownikU.obliczWyplate();

        // Nocny = 800
        result = 100*50 + 50*800;

        assertEquals(result, pracownikU.getWyplata());
    }

    @Test
    void ustawStrategieUmiejetnosciU() {

        strategiaWyplaty = new UmiejetnosciU();

        ((PracownikU) pracownikU).setLiczbaJezykowObcych(5);
        ((PracownikU) pracownikU).setUmiejetnosci("Dobre");

        pracownikU.zmienStrategiaWyplaty(strategiaWyplaty);
        pracownikU.obliczWyplate();

        // Dobre = 200
        int result = 400*5 + 800*200;

        assertEquals(result, pracownikU.getWyplata());

        ((PracownikU) pracownikU).setUmiejetnosci("Wybitne");
        pracownikU.obliczWyplate();

        // Wybitne = 400
        result = 400*5 + 800*400;

        assertEquals(result, pracownikU.getWyplata());
    }

    @AfterEach
    void zniszczKlasy() {
        pracownikU = null;
        pracownikND = null;
        strategiaWyplaty = null;
    }

}
