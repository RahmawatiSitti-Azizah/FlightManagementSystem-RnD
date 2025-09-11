package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.SystemConfig;
import com.mitrais.rnd.FlightManagementSystem.exception.RouteErrorException;
import com.mitrais.rnd.FlightManagementSystem.repository.RouteRepository;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import com.mitrais.rnd.FlightManagementSystem.service.SeatService;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
	private final RouteRepository repository;
	private final SystemService systemService;
	
	private final SeatService seatService;
	
	@Override
	public void addRoute(Route route) throws Exception {
		if (route.getFromDestination().getId().equals(route.getToDestination().getId())){
			throw new RouteErrorException();
		}
		repository.save(route);
		seatService.populateSeatsOnRoute(route);
	}
	
	@Override
	public List<Route> findRouteByDepartureDestination(Destination departure, Destination destination) throws EntityNotFoundException {
		List<Route> routes = repository.findByFromDestinationToDestination(departure.getId(), destination.getId()).orElseThrow();
		if (routes.isEmpty()) {
			throw new EntityNotFoundException((ErrorMesssageConstant.ROUTE_NOT_FOUND));
		}
		return routes;
	}

    @Override
    public List<Route> getCurrentDayRoute() throws Exception {
        SystemConfig currentSystemDay = systemService.getCurrentSystemDay();
        Integer currentDay = Integer.parseInt(currentSystemDay.getConfigValue());
        return repository.findByFlightDay(currentDay);
    }
}
