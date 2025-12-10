package com.devsuperior.bds02.services;

import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final CityRepository cityRepository;
    public EventService(EventRepository eventRepository, CityRepository cityRepository){
        this.eventRepository = eventRepository;
        this.cityRepository = cityRepository;
    }
}
