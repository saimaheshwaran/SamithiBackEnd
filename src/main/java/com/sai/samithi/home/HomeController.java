package com.sai.samithi.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("carousel1", homeService.get("carousel-1"));
        model.addAttribute("carousel2", homeService.get("carousel-2"));
        model.addAttribute("carousel3", homeService.get("carousel-3"));
        return "home";
    }

}
