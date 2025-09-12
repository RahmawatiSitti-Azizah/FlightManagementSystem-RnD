package com.mitrais.rnd.FlightManagementSystem.handler;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Component
public class ChooseFlightHandler {
	private final BookingService bookingService;
	
	public void showDirectRoutes(List<Route> routes) {
		System.out.println(MenuText.FOUND_DIRECT_FLIGHTS);
		int index=0;
		for (Route route: routes) {
			System.out.println(MenuText.getShowFlight(++index, route));
		}
	}

	public void showTransitRoutes(List<Route[]> routes) {
		System.out.println(MenuText.FOUND_DIRECT_FLIGHTS);
		int index=0;
		for (Route[] route: routes) {
			System.out.println(MenuText.getShowTransitFlight(++index, route));
		}
	}
	
	public Route scanFlightOption(List<Route> routes, Scanner scanner) {
		System.out.print(MenuText.SELECT_FLIGHT);
		
		try {
			int routeIndex = Integer.parseInt(scanner.nextLine());
			return routes.get(routeIndex-1);
		} catch (Exception e) {
			System.out.println(ErrorMesssageConstant.ERROR_INPUT_NON_NUMBER);
			return scanFlightOption(routes, scanner);
		}
	}

	public Route[] scanTransitFlightOption(List<Route[]> routes, Scanner scanner) {
		System.out.print(MenuText.SELECT_FLIGHT);

		try {
			int routeIndex = Integer.parseInt(scanner.nextLine());
			return routes.get(routeIndex-1);
		} catch (Exception e) {
			System.out.println(ErrorMesssageConstant.ERROR_INPUT_NON_NUMBER);
			return scanTransitFlightOption(routes, scanner);
		}
	}
	
	public boolean confirmSelectedFlight(Route route, Scanner scanner) {
		System.out.println(MenuText.getFlightConfirmation(route.getFromDestination().getName(), route.getToDestination().getName(), route.getFlightDay(), route.getAvailableSeats()));
		System.out.print(MenuText.CONFIRM_THIS_BOOKING_MESSAGE);
		String input = scanner.nextLine();
		return input.equals("y");
	}

	public boolean confirmSelectedTransitFlight(Route[] routes, Scanner scanner) {
		for (Route route: routes) {
			System.out.println(MenuText.getFlightConfirmation(route.getFromDestination().getName(), route.getToDestination().getName(), route.getFlightDay(), route.getAvailableSeats()));
		}
		System.out.print(MenuText.CONFIRM_THIS_BOOKING_MESSAGE);
		String input = scanner.nextLine();
		return input.equals("y");
	}
	
	public Booking createBooking(Route route) throws NoSeatException {
		try {
			return bookingService.createBooking(route);
		} catch (NoSeatException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (DuplicateKeyException e) {
			System.out.println("same booking");
			throw e;
		}
	}

	public Booking[] createBooking(Route[] route) throws NoSeatException {
		try {
			return bookingService.createBooking(route);
		} catch (NoSeatException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (DuplicateKeyException e) {
			System.out.println("same booking");
			throw e;
		}
	}
}

