package com.clockworkjava.kursspring;

public enum PersonUtils2 {
    INSTANCE;

    public final String operacja(Person person)
    {
        return person.toString();
    }
}
