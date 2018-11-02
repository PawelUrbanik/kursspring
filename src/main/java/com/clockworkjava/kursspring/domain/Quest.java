package com.clockworkjava.kursspring.domain;

public class Quest {
    private String desription;

    public Quest(String desription) {
        this.desription = desription;
    }

    @Override
    public String toString() {
        return "Zadanie: "+desription;
    }
}
