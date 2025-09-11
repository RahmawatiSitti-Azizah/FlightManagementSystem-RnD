package com.mitrais.rnd.FlightManagementSystem.controller.passenger;


import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.exception.BookingNotComfirmedException;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;
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
	
	private Route chooseFlight(List<Route> availableRoutes, Scanner scanner) throws BookingNotComfirmedException {
		Route chosenRoute = chooseRoute(availableRoutes, scanner);
		if (chooseFlightHandler.confirmSelectedFlight(chosenRoute, scanner)) {
			try {
				return chosenRoute;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return chooseFlight(availableRoutes, scanner);
			}
		} else {
			throw new BookingNotComfirmedException();
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

        List<Route> availableRoutes = searchFlightHandler.searchForFlight();
		Scanner scanner = new Scanner(System.in);
		
		try {
			Route chosenFlight = chooseFlight(availableRoutes, scanner);
			Booking booking = chooseFlightHandler.createBooking(chosenFlight);
			
			System.out.println(MenuText.getSuccessBookingText(booking));
		} catch (BookingNotComfirmedException e) {
			return backMenuDisplay;
		} catch (NoSeatException e) {
			return proceedToNextDisplay();
		}

        return backMenuDisplay;
    }
}