package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;

public interface AuthenticationService {
    public AppUser login(String username, String password);
}
