package com.labor.model.observer;

public interface Podmiot {
    void zarejestrujObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwatora();
}
