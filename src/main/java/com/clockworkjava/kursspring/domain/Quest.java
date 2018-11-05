package com.clockworkjava.kursspring.domain;

public class Quest {
    private String desription;

    public Quest() {
        this.desription = "Uratuj księżniczke ";
    }

    @Override
    public String toString() {
        return "Zadanie: "+desription;
    }
}
