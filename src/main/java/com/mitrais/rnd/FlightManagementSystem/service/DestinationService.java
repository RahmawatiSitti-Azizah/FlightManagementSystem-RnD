package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface DestinationService {
    public void save(String name) throws EntityExistsException;
    public List<Destination> getAvailableDestination();
    public Destination getDestinationCityByName(String name) throws EntityNotFoundException;
}
