package com.clockworkjava.kursspring;


import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {


    @Autowired
    Castle castle;

    @Autowired
    Tournament tournament;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);
        tournament.dual();
        System.out.println(tournament);
        System.out.println(castle);

//        Quest saveThePrincessQuest = new Quest("Uratuj księżniczkę");
//        Knight lancelot = new Knight("Lancelot", 21, saveThePrincessQuest);
//        System.out.println(lancelot);
//
//        Quest killTheDragon = new Quest("Zabij smoka");
//        Knight pricival = new Knight("Pricival", 32);
//        System.out.println(pricival);
//        pricival.setQuest(killTheDragon);
//        System.out.println(pricival);
    }
}
