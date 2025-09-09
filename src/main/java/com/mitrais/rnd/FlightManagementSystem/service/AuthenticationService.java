package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.User;

public interface AuthenticationService {
    public User login(String username, String password);
}
