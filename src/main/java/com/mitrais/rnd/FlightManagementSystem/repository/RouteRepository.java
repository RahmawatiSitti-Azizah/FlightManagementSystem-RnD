package com.mitrais.rnd.FlightManagementSystem.repository;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
    public List<Route> findByFlightDayAndStatus(int flightDay, String status);
	@Query("SELECT r FROM Route r WHERE r.fromDestination.id = :departureId AND r.toDestination.id = :destinationId")
    List<Route> findByFromDestinationToDestination(UUID departureId, UUID destinationId);
    List<Route> findByFromDestinationId(UUID id);
    List<Route> findByToDestinationId(UUID id);
}
