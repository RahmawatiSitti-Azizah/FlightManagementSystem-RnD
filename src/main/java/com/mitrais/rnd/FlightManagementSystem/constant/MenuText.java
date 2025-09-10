package com.mitrais.rnd.FlightManagementSystem.constant;

import org.springframework.stereotype.Component;

@Component
public class MenuText {
    private static final String ADMIN_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Aircraft Management\n2.Destination Management\n3.Route Creation\n4.System Operation";
    private static final String PASSENGER_MENU_DISPLAY = "Welcome, %s!\nPlease select menu\n1.Book Flight\n2.My Bookings";
    public static final String NEXT_DAY_DISPLAY = "";

    public static String getAdminMenuDisplayText(String name) {
        return String.format(ADMIN_MENU_DISPLAY, name);
    }

    public static String getPassengerMenuDisplayText(String name) {
        return String.format(PASSENGER_MENU_DISPLAY, name);
    }

}
