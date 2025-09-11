package com.mitrais.rnd.FlightManagementSystem.constant;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.SystemConfig;
import org.springframework.stereotype.Component;

@Component
public class MenuText {
    private static final String ADMIN_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Register Aircraft\n2.Register Destination \n3.Create Route\n4.System Operation";
    private static final String PASSENGER_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Book Flight\n2.My Bookings";
    private static final String DESTINATION_SUCCESSFULLY_ADDED = "%s added as a destination!";
    private static final String SUCCESS_ADD_AIRCRAFT = "Aircraft %s with %s capacity is successfully saved!\n\n";
    private static final String CURRENT_DAY_DISPLAY = "Current day is now: %s";
    private static final String SUCCESS_ADD_ROUTE = "%s -> %s (Day %s with Aircraft %s) is successfully saved!";
    private static final String FLIGHT_SCHEDULE_TODAY = "Flight %s -> %s is scheduled for today.";
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

    public static String getCurrentDayDisplay(SystemConfig currentSystemDay){
        return String.format(CURRENT_DAY_DISPLAY, currentSystemDay.getConfigValue());
    }

    public static String generateTodayFlightScheduleText(Route route){
        return String.format(FLIGHT_SCHEDULE_TODAY, route.getFromDestination().getName(), route.getToDestination().getName());
    }
}
