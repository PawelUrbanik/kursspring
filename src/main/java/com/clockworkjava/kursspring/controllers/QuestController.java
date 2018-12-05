package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.services.KnightService;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer knightId, Model model)
    {
        Knight knight = knightService.getKnight(knightId);
        List<Quest> allNotStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuest", allNotStartedQuests);
        return "assignQuest";
    }

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String assignQuest(Knight knight)
    {
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.updateQuest(quest);
        return "redirect:/knights";
    }

    @RequestMapping("/checkQuests")
    public String checkQuests()
    {

        knightService.getMyGold();

        return "redirect:/knights";
    }
}
