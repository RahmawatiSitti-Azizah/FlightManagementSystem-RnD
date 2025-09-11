package com.mitrais.rnd.FlightManagementSystem.repository;

import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
	@Query("SELECT r FROM Route r WHERE r.fromDestination.id = :departureId AND r.toDestination.id = :destinationId")
    Optional<List<Route>> findByFromDestinationToDestination(UUID departureId, UUID destinationId);
	@Query("update Route r set r.availableSeats = :availableSear where r.id = :routeId")
	void updateSeatAvailable(UUID routeId, int availableSeat);
}
