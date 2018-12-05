package com.clockworkjava.kursspring.domain;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Knight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Value("Lancelot")
    @NotNull(message = "Pole nie może być puste")
    @Size(min = 3, message = "Imię musi składać się z co najmniej 3 znaków")
    @Size(max = 40, message = "Imię musi składać się co najwyżej z 40 znaków")
    private String name;
//    @Value("29")
    @NotNull(message = "Pole nie może być puste")
    @Min(value = 18, message = "Rycerz musi być w wieku co najmnie 18 lat")
    @Max(value = 60, message = "Maksymalny wiek rycerza to 60 lat")
    private int age;
    private int level;

//    @Autowired
    @OneToOne
    private Quest quest;

    public Knight() {
    }


    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        this.quest = quest;
        this.level = 1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level =1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuest(Quest quest) {
        if (quest!=null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Quest getQuest() {
        return quest;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu "+ name + "("+age+") Zadanie: " + quest +" id: " +getId();
    }
}
