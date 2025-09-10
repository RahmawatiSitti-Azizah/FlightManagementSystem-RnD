package com.mitrais.rnd.FlightManagementSystem.constant;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class MenuText {
    private static final String ADMIN_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Register Aircraft\n2.Register Destination \n3.Create Route\n4.System Operation";
    private static final String PASSENGER_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Book Flight\n2.My Bookings";
    public static final String ADD_DESTINATION_HEADER = "===== ADD DESTINATION =====";
    public static final String ENTER_DESTINATION_NAME = "Enter destination name: ";
    private static final String DESTINATION_SUCCESSFULLY_ADDED = "%s added as a destination!";
    private static final String SUCCESS_ADD_AIRCRAFT = "Aircraft %s with %s capacity is successfully saved!\n\n";

    public static final String REGISTER_AIRCRAFT_HEADER = "===== REGISTER AIRCRAFT =====\n";
    public static final String ENTER_AIRCRAFT_NAME = "Enter aircraft name: ";
    public static final String AIRCRAFT_CAPACITY = "Enter aircraft capacity: ";

    public static final String ADD_NEW_ROUTE_HEADER = "===== ADD NEW ROUTE =====\n";
    public static final String DEPARTURE_LIST = "Available Departure List: ";
    public static final String DESTINATION_LIST = "Available Destination List: ";
    public static final String AIRCRAFT_LIST = "Available Aircraft List: ";
    public static final String SELECT_DESTINATION = "Available Destination List: ";
    public static final String ENTER_DEPARTURE = "Enter Departure: ";
    public static final String SELECT_AIRCRAFT = "Available Aircraft List: ";
    private static final String ERROR_INPUT = "%s is not available. Please enter available %s";
    public static final String ENTER_DAY = "Enter Day: ";
    private static final String SUCCESS_ADD_ROUTE = "%s -> %s (Day %s with Aircraft %s) is successfully saved!";

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

    public static String showErrorInput(String column) {
        return String.format(ERROR_INPUT, column, column);
    }
    public static String getSuccessAddRoute(Route route) {
        return String.format(SUCCESS_ADD_ROUTE, route.getFromDestination().getName(), route.getToDestination().getName(), route.getFlightDay(), route.getAircraft().getName());
    }
}
