package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.repository.DestinationRepository;
import com.mitrais.rnd.FlightManagementSystem.service.DestinationService;
import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository repository;
    @Override
    public void save(String name) throws EntityExistsException {
        if(repository.findByNameIgnoreCase(name).isPresent()){
            throw new EntityExistsException(ErrorMesssageConstant.DESTINATION_ALREADY_EXISTS);
        }
        repository.save(new Destination(null, name, UserContextHolder.getUserContext().getId()));
    }

    @Override
    public List<Destination> getAvailableDestination() {
        return repository.findAll();
    }

    @Override
    public Destination getDestinationCityByName(String name) throws EntityNotFoundException {
        return repository.findByNameIgnoreCase(name).orElseThrow(() -> new EntityNotFoundException(ErrorMesssageConstant.showErrorInput("City")));
    }
}
