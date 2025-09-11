package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface AircraftService {
    public void registerAircraft(Aircraft aircraft);
    public List<Aircraft> getAvailableAircraft();
    public Aircraft getAircraftByName(String name) throws EntityNotFoundException;
}
