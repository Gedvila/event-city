package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DatabaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }


    public List<CityDTO> findAll(){
        List<City> result = cityRepository.findAll();
        return result.stream().map(CityDTO::new).toList();
    }

    public CityDTO insert(CityDTO dto){
        City entity = new City();
        copyDTOToEntity(entity,dto);
        entity = cityRepository.save(entity);
        return new CityDTO(entity);
    }

    public void delete(Long id){
        if (!cityRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource Not Found");
        }try {
            cityRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Dependent ID");
        }
    }

    private void copyDTOToEntity(City entity, CityDTO dto){
        entity.setName(dto.getName());
    }
}
