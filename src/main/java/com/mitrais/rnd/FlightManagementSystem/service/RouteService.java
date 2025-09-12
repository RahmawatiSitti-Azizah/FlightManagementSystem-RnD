package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.enums.FlightStatus;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface RouteService {
    public void addRoute(Route route) throws Exception;
    public List<Route> getCurrentDayRoute();
    public List<Route> findRouteByDepartureDestination(Destination departure, Destination destination);
    public void updateRouteStatus(Route route, FlightStatus status);
    public List<Route[]> findRouteTransitByDepartureDestination(Destination departure, Destination destination);
}
