package com.clockworkjava.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Tournament {

    @Autowired
//    @Qualifier(value = "percival")
    List<Knight> knights;

// MAP
//    Map<String, Knight> knight;


    public Tournament() {
    }

    public Tournament(Knight knight) {
    }

    public void setKnights(List<Knight> knights)
    {
        this.knights = knights;
    }

    public void dual() {
//        knight.setAge(knight.getAge()+1);
    }

    @Override
    public String toString() {
        return "W turnieju bierze udział rycerz: " +
                knights.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
