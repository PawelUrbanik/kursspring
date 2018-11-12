package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getAllKnights(Model model)
    {
        List<Knight> knights= knightService.getAllKnights();
        model.addAttribute("knights",knights);
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model)
    {
        model.addAttribute("knight", new Knight());
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String getAllKnights(Knight knight)
    {
        knightService.saveKnight(knight);
        return "redirect:/knights";
    }
}