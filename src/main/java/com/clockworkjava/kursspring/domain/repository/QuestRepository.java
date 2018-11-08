package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    List<Quest> questList = new ArrayList<>();

    final static Random RANDOM = new Random();

    public void createQuest(String description)
    {
        questList.add(new Quest(description));
    }

    public List<Quest> getAll() {
        return questList;
    }

    public void deleteQuest(Quest quest)
    {
        questList.remove(quest);
    }

    @PostConstruct
    public void init()
    {
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}", initialDelayString = "${questInitialDealy}")
    public void createRandomQuest()
    {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj księżniczke");
        descriptions.add("Wez udział w turnieju");
        descriptions.add("Zabij bande goblinow");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(RANDOM.nextInt(descriptions.size()));
        System.out.println("Utworzyłem zadanie o opisie " + description);
        createQuest(description);
    }
}
