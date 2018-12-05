package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random RANDOM = new Random();

    public void assignRandomQuest(String knightName)
    {
        List<Quest> allQuests = questRepository.getAll();
        System.out.println(allQuests);
        Quest randomQuest = allQuests.get(RANDOM.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
//        questRepository.deleteQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuests() {
        return questRepository.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public void updateQuest(Quest quest) {
        questRepository.updateQuest(quest);
    }

    public boolean isTestCompleted(Quest quest)
    {
        return quest.isCompleted();
    }
}
