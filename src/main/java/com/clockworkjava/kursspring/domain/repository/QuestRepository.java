package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    EntityManager manager;

    final static Random RANDOM = new Random();

    @Transactional
    public void createQuest(String description)
    {
        Quest newQuest = new Quest(description);
        manager.persist(newQuest);

        System.out.println(newQuest);

    }

    public List<Quest> getAll() {
       return manager.createQuery("from Quest").getResultList();
    }
    @Transactional
    public void deleteQuest(Quest quest)
    {
        manager.remove(quest);
    }

    @Override
    public String toString() {
        return "QuestRepository{" + manager.createQuery("from Quest", Quest.class).getResultList() +'}';
    }

    @Transactional
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
    @Transactional
    public void updateQuest(Quest quest) {
        manager.merge(quest);
    }

    public Quest getQuest(Integer id)
    {
        return manager.find(Quest.class, id);
    }
}
