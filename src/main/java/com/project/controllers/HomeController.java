package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Year;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "Howdy, World");
        return "index";
    }
}
