package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import jakarta.persistence.EntityExistsException;

public interface RouteService {
    public void addRoute(Route route);
}
