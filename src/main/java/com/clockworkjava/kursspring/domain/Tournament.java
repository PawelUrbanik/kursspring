package com.clockworkjava.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tournament {

    @Autowired
    Knight knight;

    public Tournament() {
    }

    public void dual() {
        knight.setAge(knight.getAge()+1);
    }

    @Override
    public String toString() {
        return "W turnieju bierze udział rycerz: " + knight;
    }
}
