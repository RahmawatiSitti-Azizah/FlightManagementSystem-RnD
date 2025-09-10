package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.repository.AircraftRepository;

import com.mitrais.rnd.FlightManagementSystem.service.AircraftService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    private final AircraftRepository repository;

    @Override
    public void registerAircraft(Aircraft aircraft) {
        repository.save(aircraft);
    }

    @Override
    public List<Aircraft> getAvailableAircraft() {
        return repository.findAll();
    }

    @Override
    public Aircraft getAircraftByName(String name) throws EntityNotFoundException {
        return repository.findByName(name).orElseThrow();
    }
}
