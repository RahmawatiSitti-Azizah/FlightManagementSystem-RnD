package com.mitrais.rnd.FlightManagementSystem.repository;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<AppUser, UUID> {
    public Optional<AppUser> findByUsernameAndPassword(String username, String password);
}
