package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/knights")
    public String getAllKnights(Model model)
    {
        List<Knight> knights= knightService.getAllKnights();
        model.addAttribute("knights",knights);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model)
    {
        model.addAttribute("knight", new Knight());
        model.addAttribute("playerInformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String getAllKnights(Knight knight)
    {
        knightService.saveKnight(knight);
        return "redirect:/knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight",knight);
        model.addAttribute("playerInformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id)
    {
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}
