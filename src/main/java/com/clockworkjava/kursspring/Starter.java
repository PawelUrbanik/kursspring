package com.clockworkjava.kursspring;


import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class Starter implements CommandLineRunner {


    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {


        questRepository.createRandomQuest();
        System.out.println(questRepository);
        questRepository.createRandomQuest();
        System.out.println(questRepository);
        questRepository.createRandomQuest();
        System.out.println(questRepository);
        knightRepository.createKnight("Lancelot", 23);
        knightRepository.createKnight("Percival", 33);

        playerInformationRepository.createPlayerInformation(new PlayerInformation());

        questService.assignRandomQuest("Lancelot");
        questService.assignRandomQuest("Percival");
    }
}
