package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.components.TimeComponent;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    TimeComponent timeComponent;

    @RequestMapping("/knights")
    public String saveKnight(Model model)
    {
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        List<Knight> knights= knightService.getAllKnights();
        model.addAttribute("knights",knights);
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model)
    {
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        model.addAttribute("knight", new Knight());
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error ->{
                System.out.println(error.getObjectName()+ " " + error.getDefaultMessage());
            });
            return "knightform";
        } else {
            knightService.saveKnight(knight);
            return "redirect:/knights";
        }
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight",knight);
        model.addAttribute("timeComponent", timeComponent);
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
