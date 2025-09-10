package com.mitrais.rnd.FlightManagementSystem.repository;

import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DestinationRepository extends JpaRepository<Destination, UUID> {
    Optional<Destination> findByName(String name);
}
