package com.mitrais.rnd.FlightManagementSystem.constant;

import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.SystemConfig;
import org.springframework.stereotype.Component;

@Component
public class MenuText {
    private static final String ADMIN_MENU_DISPLAY = "====== Flight Management System ======\nWelcome, %s!\nPlease select menu";
    private static final String PASSENGER_MENU_DISPLAY = "====== Flight Management System ======\nWelcome, %s!\nPlease select menu";
    private static final String DESTINATION_SUCCESSFULLY_ADDED = "%s added as a destination!";
    private static final String SUCCESS_ADD_AIRCRAFT = "Aircraft %s with %s capacity is successfully saved!\n\n";
    private static final String CURRENT_DAY_DISPLAY = "Current day is now: %s";
    private static final String SUCCESS_ADD_ROUTE = "%s -> %s (Day %s with Aircraft %s) is successfully saved!";
    private static final String BOOKING_CREATED = "\n====== Booking confirmed ======\nBooking Details\nBooking ID: %s\nDeparture: %s\nDestination: %s\nFlight Day: %s\nSeat number: %s \n";
    private static final String FLIGHT_CONFIRMATION = "You select %s -> %s (Day %s, %s seat(s) available). ";
    private static final String FLIGHT_SCHEDULE_TODAY = "Flight %s -> %s is scheduled for today.";
    private static final String RUNNING_FLIGHT_FOR_DAY = "Running Flight for day %s";
    private static final String SUCCESS_RUNNING_FLIGHT_FOR_DAY = "All flight for day %s have been completed successfully";
    private static final String PROCESSING_FLIGHT = "Processing flight: %s -> %s";
    private static final String AIRCRAFT_NAME = "Aircraft : %s";
    private static final String PASSENGER_BOARDING = "Passenger boarding : %d";
    private static final String PASSENGER_LIST_TEXT = "- %s (seat %s)";
    private static final String FLIGHT_STATUS_CHANGE = "Flight status : %s\nFlight status : %s";
    private static final String MY_FLIGHT_DISPLAY = "%d. %s: %s -> %s on day %s, Seat %s";
    public static final String WELCOME_PROGRAM_BANNER = "---------------------------------------\nWelcome to RnD Flight Management System\n---------------------------------------";
    public static final String REGISTER_AIRCRAFT_HEADER = "===== REGISTER AIRCRAFT =====\n";
    public static final String ADD_DESTINATION_HEADER = "===== ADD DESTINATION =====";
    public static final String ENTER_DESTINATION_NAME = "Enter destination name: ";
    public static final String ENTER_AIRCRAFT_NAME = "Enter aircraft name: ";
    public static final String AIRCRAFT_CAPACITY = "Enter aircraft capacity: ";
    public static final String SYSTEM_OPERATION_HEADER = "===== System Operation =====";
    public static final String NEXT_DAY_DISPLAY = "Advancing to next day...";
    public static final String SELECT_MENU_TEXT = "Select menu number : ";
    public static final String ENTER_USERNAME = "Enter username : ";
    public static final String ENTER_PASSWORD = "Enter password : ";
    public static final String ADD_NEW_ROUTE_HEADER = "===== ADD NEW ROUTE =====\n";
    public static final String DEPARTURE_LIST = "Available Departure List: ";
    public static final String DESTINATION_LIST = "Available Destination List: ";
    public static final String AIRCRAFT_LIST = "Available Aircraft List: ";
    public static final String ENTER_DEPARTURE = "Enter Departure: ";
    public static final String ENTER_DAY = "Enter Day: ";
    public static final String ENABLE_BOOKING_SERVICE = "Enabling booking service...";
    public static final String SUCCESS_ENABLE_BOOKING_SERVICE = "Booking service enabled";
    public static final String DISABLE_BOOKING_SERVICE = "Disabling booking service...";
    public static final String SUCCESS_DISABLE_BOOKING_SERVICE = "Booking service disabled";
    public static final String CREATE_BOOKING = "===== CREATE BOOKING =====\n";
    public static final String SEARCH_FLIGHT = "Searching flight...";
    public static final String FOUND_DIRECT_FLIGHTS = "Found Direct Flights: ";
    public static final String FOUND_TRANSIT_FLIGHTS = "Found Transit Flights: ";
    public static final String SELECT_FLIGHT = "Input selected flight (number): ";
    public static final String SHOW_FLIGHT = "%s. %s -> %s (Day %s, %s available seats)";
    public static final String SHOW_TRANSIT_FLIGHT = "%s. %s -> %s (Day %s, %s available seats) %s -> %s (Day %s, %s available seats)";
    public static final String NO_FLIGHT_AVAILABLE_TODAY = "No flight scheduled for today";
    public static final String CONFIRM_THIS_BOOKING_MESSAGE = "Are you sure you want to confirm this booking? (y/n) ";
    public static final String YOUR_BOOKING = "Your booking list";
    public static final String ENTER_BOOKING_ID_TO_CANCEL = "Enter booking id to cancel : ";
    public static final String BOOKING_ID_NOT_FOUND = "Booking id not found";

    public static String getAdminMenuDisplayText(String name) {
        return String.format(ADMIN_MENU_DISPLAY, name);
    }

    public static String getPassengerMenuDisplayText(String name) {
        return String.format(PASSENGER_MENU_DISPLAY, name);
    }

    public static String getDestinationSuccessfullyAdded(String name){
        return String.format(DESTINATION_SUCCESSFULLY_ADDED, name);
    }
    public static String getSuccessAddAircraft(String name, int capacity) {
        return String.format(SUCCESS_ADD_AIRCRAFT, name, capacity);
    }

    public static String getSuccessAddRoute(Route route) {
        return String.format(SUCCESS_ADD_ROUTE, route.getFromDestination().getName(), route.getToDestination().getName(), route.getFlightDay(), route.getAircraft().getName());
    }

	public static String getFlightConfirmation(String departure, String destination, int day, int seat) {
		return String.format(FLIGHT_CONFIRMATION, departure, destination, day, seat);
	}

	public static String getSuccessBookingText(Booking booking){
		return String.format(BOOKING_CREATED, booking.getBooking_id(), booking.getFromDestination().getName(), booking.getToDestination().getName(), booking.getFlightDay(), booking.getSeat().getSeatNumber());
	}

	public static String getShowFlight(int index, Route route) {
		return String.format(SHOW_FLIGHT, index, route.getFromDestination().getName(), route.getToDestination().getName(), route.getFlightDay(), route.getAvailableSeats());
	}

    public static String getShowTransitFlight(int index, Route[] route) {
        return String.format(SHOW_TRANSIT_FLIGHT, index, route[0].getFromDestination().getName(), route[0].getToDestination().getName(), route[0].getFlightDay(), route[0].getAvailableSeats(),
                route[1].getFromDestination().getName(), route[1].getToDestination().getName(), route[1].getFlightDay(), route[1].getAvailableSeats());
    }

    public static String getCurrentDayDisplay(SystemConfig currentSystemDay){
        return String.format(CURRENT_DAY_DISPLAY, currentSystemDay.getConfigValue());
    }

    public static String generateTodayFlightScheduleText(Route route){
        return String.format(FLIGHT_SCHEDULE_TODAY, route.getFromDestination().getName(), route.getToDestination().getName());
    }

    public static String getRunningFlightForDay(String day){
        return String.format(RUNNING_FLIGHT_FOR_DAY, day);
    }

    public static String getSuccessRunningFlightForDay(String day){
        return String.format(SUCCESS_RUNNING_FLIGHT_FOR_DAY, day);
    }

    public static String getProcessingFlight(String departure, String destination){
        return String.format(PROCESSING_FLIGHT, departure, destination);
    }

    public static String getAircraftName(String aircraftName){
        return String.format(AIRCRAFT_NAME, aircraftName);
    }

    public static String getPassengerBoarding(int totalPassenger){
        return String.format(PASSENGER_BOARDING, totalPassenger);
    }

    public static String getProcessFlight(){
        return String.format(FLIGHT_STATUS_CHANGE, "DEPARTED", "ARRIVED");
    }

    public static String getPassengerListText(String passengerName, String passengerSeat){
        return String.format(PASSENGER_LIST_TEXT,passengerName,passengerSeat);
    }

    public static String getMyFlightDisplay(int index, Booking booking){
        return String.format(MY_FLIGHT_DISPLAY, index, booking.getBooking_id(), booking.getFromDestination().getName(), booking.getToDestination().getName(), booking.getSeat().getRoute().getFlightDay(),booking.getSeat().getSeatNumber());
    }
}
