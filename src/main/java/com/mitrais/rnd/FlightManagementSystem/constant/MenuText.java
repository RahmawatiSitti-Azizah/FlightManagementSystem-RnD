package com.mitrais.rnd.FlightManagementSystem.constant;

import org.springframework.stereotype.Component;

@Component
public class MenuText {
    private static final String ADMIN_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Aircraft Management\n2.Destination Management\n3.Route Creation\n4.System Operation";
    private static final String PASSENGER_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Book Flight\n2.My Bookings";
    public static final String ADD_DESTINATION_HEADER = "===== ADD DESTINATION =====";
    public static final String ENTER_DESTINATION_NAME = "Enter destination name";
    private static final String DESTINATION_SUCCESSFULLY_ADDED = "%s added as a destination!";

    public static String getAdminMenuDisplayText(String name) {
        return String.format(ADMIN_MENU_DISPLAY, name);
    }

    public static String getPassengerMenuDisplayText(String name) {
        return String.format(PASSENGER_MENU_DISPLAY, name);
    }

    public static String getDestinationSuccessfullyAdded(String name){
        return String.format(DESTINATION_SUCCESSFULLY_ADDED, name);
    }
}
