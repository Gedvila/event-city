package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final CityRepository cityRepository;
    public EventService(EventRepository eventRepository, CityRepository cityRepository){
        this.eventRepository = eventRepository;
        this.cityRepository = cityRepository;
    }

    public EventDTO update(Long id, EventDTO dto){
        try {
            Event entity = eventRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = eventRepository.save(entity);
            return new EventDTO(entity);
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Resource Not Found");
        }
    }

    private void copyDtoToEntity(EventDTO dto, Event entity){
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());

        City city = new City();
        city.setId(dto.getCityId());
        entity.setCity(city);
    }
}
