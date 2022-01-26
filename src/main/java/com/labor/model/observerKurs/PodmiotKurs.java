package com.labor.model.observerKurs;

import com.labor.classes.osoba.Student;
import com.labor.model.observer.Obserwator;

public interface PodmiotKurs {
    void zarejestrujObserwatoraKurs(ObserwatorKurs obserwator);
    void powiadomObserwatoraKurs(Student student);
}
