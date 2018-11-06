package com.clockworkjava.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Tournament {

    @Autowired
    @Qualifier(value = "percival")
    Knight knight;

    public Tournament() {
    }

    public Tournament(Knight knight) {
    }

    public void dual() {
        knight.setAge(knight.getAge()+1);
    }

    @Override
    public String toString() {
        return "W turnieju bierze udział rycerz: " + knight;
    }
}
