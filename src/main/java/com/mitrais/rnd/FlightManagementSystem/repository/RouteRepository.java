package com.mitrais.rnd.FlightManagementSystem.repository;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
    public List<Route> findByFlightDayAndStatus(int flightDay, String status);
    List<Route> findByFromDestinationIdAndToDestinationIdAndFlightDayGreaterThanEqual (UUID departureId, UUID destinationId, int flightDay);
    List<Route> findByFromDestinationIdAndFlightDayGreaterThan(UUID id, int flightDay);
    List<Route> findByToDestinationIdAndFlightDayGreaterThan(UUID id, int flightDay);
}
