package com.clockworkjava.kursspring;


import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import com.clockworkjava.kursspring.utils.Role;
import com.clockworkjava.kursspring.utils.RoleRepository;
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

    @Autowired
    RoleRepository roleRepository;

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

        PlayerInformation playerInformation1 = new PlayerInformation("User1", "user");
        playerInformationRepository.createPlayerInformation(playerInformation1);
        PlayerInformation playerInformation2= new PlayerInformation("User2", "admin");
        playerInformationRepository.createPlayerInformation(playerInformation2);

        Role user1RoleUSER = new Role("User1", "USER");
        Role user2RoleUSER = new Role("User2", "USER");
        Role user2RoleADMIN = new Role("User2", "ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);


        questService.assignRandomQuest("Lancelot");
        questService.assignRandomQuest("Percival");
    }
}
