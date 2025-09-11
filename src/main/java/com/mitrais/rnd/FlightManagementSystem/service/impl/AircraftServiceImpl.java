package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.repository.AircraftRepository;

import com.mitrais.rnd.FlightManagementSystem.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    private final AircraftRepository repository;

    @Override
    public void registerAircraft(Aircraft aircraft) {
        repository.save(aircraft);
    }
}
