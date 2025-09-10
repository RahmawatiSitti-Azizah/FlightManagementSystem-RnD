package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;
import jakarta.persistence.EntityNotFoundException;

public interface AuthenticationService {
    public AppUser login(String username, String password) throws EntityNotFoundException;
}
