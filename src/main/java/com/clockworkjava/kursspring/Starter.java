package com.clockworkjava.kursspring;


import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(String... args) throws Exception {


        questRepository.createRandomQuest();
        System.out.println(questRepository);
        questRepository.createRandomQuest();
        System.out.println(questRepository);
        questRepository.createRandomQuest();
        System.out.println(questRepository);

        questService.assignRandomQuest("Lancelot");
        questService.assignRandomQuest("Percival");
    }
}
