package com.project.controllers;

import com.project.models.Event;
import com.project.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {
    EventRepository eventRepo;

    public EventController (EventRepository eventRepo){
        this.eventRepo = eventRepo;
    }

    @GetMapping("/postsCalendar")
    public String showCalendar(){
        return "demos/fullCalendar";
    }

    @GetMapping("/save-event")
    public String showEventForm(Model viewModel){
        viewModel.addAttribute("event", new Event());
        return "demos/save-event";
    }

    @PostMapping("/save-event")
    public String saveEvent(@ModelAttribute Event event){
        eventRepo.save(event);
        return "demos/save-event";
    }

}