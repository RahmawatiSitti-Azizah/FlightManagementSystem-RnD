package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import jakarta.persistence.EntityExistsException;

public interface DestinationService {
    public void save(String name) throws EntityExistsException;
}
