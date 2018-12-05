package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.PlayerInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager manager;


    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {
        manager.persist(playerInformation);
    }


    public PlayerInformation getFirst() {
        return manager.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
