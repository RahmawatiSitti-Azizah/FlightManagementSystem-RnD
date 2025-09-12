package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import jakarta.persistence.EntityExistsException;

import java.util.List;

public interface RouteService {
    public void addRoute(Route route) throws Exception;
    public List<Route> getCurrentDayRoute();
}
