package com.mitrais.rnd.FlightManagementSystem.controller.passenger;


import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.exception.BookingNotConfirmedException;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;
import com.mitrais.rnd.FlightManagementSystem.handler.ChooseFlightHandler;
import com.mitrais.rnd.FlightManagementSystem.handler.SearchFlightHandler;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class BookingFlightDisplay implements Displayable {

    private final SearchFlightHandler searchFlightHandler;
	private final ChooseFlightHandler chooseFlightHandler;

    @Setter
    private Displayable backMenuDisplay;
	
	private Route chooseRoute(List<Route> availableRoutes, Scanner scanner) {
		chooseFlightHandler.showDirectRoutes(availableRoutes);
		return chooseFlightHandler.scanFlightOption(availableRoutes, scanner);
	}

	private Route[] chooseTransitRoute(List<Route[]> availableRoutes, Scanner scanner) {
		chooseFlightHandler.showTransitRoutes(availableRoutes);
		return chooseFlightHandler.scanTransitFlightOption(availableRoutes, scanner);
	}
	
	private Route chooseFlight(List<Route> availableRoutes, Scanner scanner) throws BookingNotConfirmedException {
		Route chosenRoute = chooseRoute(availableRoutes, scanner);
		if (chooseFlightHandler.confirmSelectedFlight(chosenRoute, scanner)) {
			try {
				return chosenRoute;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return chooseFlight(availableRoutes, scanner);
			}
		} else {
			throw new BookingNotConfirmedException();
		}
	}

	private Route[] chooseTransitFlight(List<Route[]> availableRoutes, Scanner scanner) throws BookingNotConfirmedException {
		Route[] chosenRoute = chooseTransitRoute(availableRoutes, scanner);
		if (chooseFlightHandler.confirmSelectedTransitFlight(chosenRoute, scanner)) {
			try {
				return chosenRoute;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return chooseTransitFlight(availableRoutes, scanner);
			}
		} else {
			throw new BookingNotConfirmedException();
		}
	}

    @Override
    public void display() {
        System.out.println(MenuText.CREATE_BOOKING);
        searchFlightHandler.showCreateBooking();
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();

        List<Route> availableDirectRoutes = searchFlightHandler.searchForFlight();
		Scanner scanner = new Scanner(System.in);
		try {
			if(availableDirectRoutes.isEmpty()){
				System.out.print(ErrorMesssageConstant.DIRECT_ROUTE_NOT_FOUND);
				List<Route[]> transitRoute = searchFlightHandler.searchForTransitFlights();
				if(!transitRoute.isEmpty()) {
					Route[] routes = chooseTransitRoute(transitRoute, scanner);
					Booking[] bookings = chooseFlightHandler.createBooking(routes);
					for (Booking booking : bookings) {
						System.out.println(MenuText.getSuccessBookingText(booking));
					}
				}else{
					System.out.println(ErrorMesssageConstant.TRANSIT_ROUTE_NOT_FOUND);
				}
			}else {
				Route chosenFlight = chooseFlight(availableDirectRoutes, scanner);
				Booking booking = chooseFlightHandler.createBooking(chosenFlight);
				System.out.println(MenuText.getSuccessBookingText(booking));
			}
		} catch (BookingNotConfirmedException e) {
			return backMenuDisplay;
		} catch (NoSeatException e) {
			return proceedToNextDisplay();
		}
        return backMenuDisplay;
    }
}