package com.mitrais.rnd.FlightManagementSystem.repository;

import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AircraftRepository extends JpaRepository<Aircraft, UUID> {

}
