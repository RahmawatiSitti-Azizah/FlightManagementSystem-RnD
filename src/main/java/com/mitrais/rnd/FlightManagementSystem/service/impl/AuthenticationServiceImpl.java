package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;
import com.mitrais.rnd.FlightManagementSystem.repository.UserRepository;
import com.mitrais.rnd.FlightManagementSystem.service.AuthenticationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    @Override
    public AppUser login(String username, String password) {
        AppUser appUser = repository.findByUsernameAndPassword(username,password).orElseThrow(()-> new EntityNotFoundException("Invalid Username/Password"));
        return appUser;
    }
}
