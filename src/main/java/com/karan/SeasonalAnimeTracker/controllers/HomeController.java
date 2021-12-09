package com.karan.SeasonalAnimeTracker.controllers;

import com.karan.SeasonalAnimeTracker.services.SeasonalAnimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    SeasonalAnimeDataService seasonalAnimeDataService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("SeasonalAnimeList", seasonalAnimeDataService.getSeasonalAnimeList());
        return "home";
    }
}
