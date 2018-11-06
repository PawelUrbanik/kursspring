package com.clockworkjava.kursspring.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
