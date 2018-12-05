package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    QuestRepository questRepository;

    public List<Knight> getAllKnights()
    {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {

        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest()!= null)
            {
                return knight.getQuest().isCompleted();
            }else {
                return false;
            }
        };

        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward()).sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight -> {
            knight.setQuest(null);
        });

        return sum;
    }

    @Transactional
    public void getMyGold()
    {
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight ->
        {
            if (knight.getQuest()!= null)
            {
                boolean completed = knight.getQuest().isCompleted();
                if (completed)
                {
                    questRepository.updateQuest(knight.getQuest());
                }
            }

        });

        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + collectRewards());
    }
}
