package com.clockworkjava.kursspring;


import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Quest saveThePrincessQuest = new Quest("Uratuj księżniczkę");
        Knight lancelot = new Knight("Lancelot", 21, saveThePrincessQuest);
        System.out.println(lancelot);

        Quest killTheDragon = new Quest("Zabij smoka");
        Knight pricival = new Knight("Pricival", 32);
        System.out.println(pricival);
        pricival.setQuest(killTheDragon);
        System.out.println(pricival);
    }
}