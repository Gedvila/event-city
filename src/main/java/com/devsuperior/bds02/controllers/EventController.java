package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.services.EventService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }
}
