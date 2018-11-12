package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
