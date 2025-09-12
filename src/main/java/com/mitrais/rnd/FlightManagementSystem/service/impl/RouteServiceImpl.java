package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import com.mitrais.rnd.FlightManagementSystem.entity.*;
import com.mitrais.rnd.FlightManagementSystem.enums.BookingStatus;
import com.mitrais.rnd.FlightManagementSystem.enums.FlightStatus;
import com.mitrais.rnd.FlightManagementSystem.exception.RouteErrorException;
import com.mitrais.rnd.FlightManagementSystem.repository.RouteRepository;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import com.mitrais.rnd.FlightManagementSystem.service.SeatService;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
	private final RouteRepository repository;
	private final SystemService systemService;
	private final SeatService seatService;
	private final BookingService bookingService;
	
	@Override
	public void addRoute(Route route) throws Exception {
		if (route.getFromDestination().getId().equals(route.getToDestination().getId())){
			throw new RouteErrorException();
		}
		repository.save(route);
		seatService.populateSeatsOnRoute(route);
	}
	
	@Override
	public List<Route> findRouteByDepartureDestination(Destination departure, Destination destination){
		int flightDay = Integer.parseInt(systemService.getCurrentSystemDay().getConfigValue());
		List<Route> routes = repository.findByFromDestinationIdAndToDestinationIdAndFlightDayGreaterThanEqual(departure.getId(), destination.getId(), flightDay);
		return routes;
	}

	@Override
	@Transactional
	public void updateRouteStatus(Route route, FlightStatus status) {
		List<Seat> seats = seatService.getOccupiedSeatByRoute(route);
		List<Booking> bookings = seats.stream().map(seat -> seat.getPassenger()).toList();
		bookingService.updateBookingStatus(bookings, BookingStatus.ARRIVED);
		route.setStatus(status.getCode());
		repository.save(route);
	}

	@Override
	public List<Route[]> findRouteTransitByDepartureDestination(Destination departure, Destination destination) {
		int flightDay = Integer.parseInt(systemService.getCurrentSystemDay().getConfigValue());
		List<Route> departureTransitRoute = repository.findByFromDestinationIdAndFlightDayGreaterThan(departure.getId(), flightDay);
		List<Route> destinationTransitRoute = repository.findByToDestinationIdAndFlightDayGreaterThan(destination.getId(), flightDay);
		List<Route[]> transitRoutesList = departureTransitRoute.stream()
				.map(departureRoute -> new Route[] {
						departureRoute,
						destinationTransitRoute.stream()
								.filter(destinationRoute ->
										departureRoute.getToDestination().getId().equals(destinationRoute.getFromDestination().getId())
												&& departureRoute.getFlightDay() == destinationRoute.getFlightDay())
								.findFirst()
								.orElse(null)
				})
				.toList();
		transitRoutesList = transitRoutesList.stream().filter(routes -> routes.length == 2 && routes[1]!=null).toList();
		return transitRoutesList;
	}

	@Override
    public List<Route> getCurrentDayRoute(){
        SystemConfig currentSystemDay = systemService.getCurrentSystemDay();
        Integer currentDay = Integer.parseInt(currentSystemDay.getConfigValue());
        return repository.findByFlightDayAndStatus(currentDay, FlightStatus.SCHEDULED.getCode());
    }
}
