package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {

    Map<Integer, Quest> quests = new HashMap<>();
    final static Random RANDOM = new Random();

    public void createQuest(String description)
    {
        int key = Ids.getNewId(quests.keySet());
        quests.put(key, new Quest(key, description));
    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest)
    {
        quests.remove(quest.getId());
    }

    @PostConstruct
    public void init()
    {
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + quests.toString() +
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
        //System.out.println("Utworzyłem zadanie o opisie " + description);
        createQuest(description);
    }

    public void updateQuest(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }
}
