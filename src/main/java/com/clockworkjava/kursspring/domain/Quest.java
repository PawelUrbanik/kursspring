package com.clockworkjava.kursspring.domain;

import org.springframework.stereotype.Component;

@Component
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
