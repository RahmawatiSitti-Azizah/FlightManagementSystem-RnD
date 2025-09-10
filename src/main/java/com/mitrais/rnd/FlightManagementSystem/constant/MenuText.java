package com.mitrais.rnd.FlightManagementSystem.constant;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class MenuText {
    private static final String ADMIN_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Register Aircraft\n2.Register New Destination\n3.Create Route\n4.System Operation";
    private static final String PASSENGER_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Book Flight\n2.My Bookings";
    private static final String SUCCESS_ADD_AIRCRAFT = "Aircraft %s with %s capacity is successfully saved!\n\n";

    public static final String REGISTER_AIRCRAFT_HEADER = "---------------REGISTER AIRCRAFT---------------\n";
    public static final String ENTER_AIRCRAFT_NAME = "Enter aircraft name: ";
    public static final String AIRCRAFT_CAPACITY = "Enter aircraft capacity: ";

    public static String getAdminMenuDisplayText(String name) {
        return String.format(ADMIN_MENU_DISPLAY, name);
    }

    public static String getPassengerMenuDisplayText(String name) {
        return String.format(PASSENGER_MENU_DISPLAY, name);
    }

    public static String getSuccessAddAircraft(String name, int capacity) {
        return String.format(SUCCESS_ADD_AIRCRAFT, name, capacity);
    }

}
