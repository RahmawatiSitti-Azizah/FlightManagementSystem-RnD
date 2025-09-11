package com.mitrais.rnd.FlightManagementSystem.constant;

public class ErrorMesssageConstant {
    public static final String DESTINATION_ALREADY_EXISTS  = "Destination name already exists please use other name";
    public static final String SAME_DEPARTURE_DESTINATION_ERROR  = "Departure and destination must be different. Please check your input.\n";
    private static final String ERROR_INPUT = "%s is not available. Please enter available %s";
    public static final String ERROR_INPUT_NON_NUMBER  = "Please enter number: ";
    public static final String ROUTE_NOT_FOUND = "Route not found. Please enter other route: ";
	
	public static final String NO_SEAT_AVAILABLE = "No seats available on this flight. Please select other flight";

    public static String showErrorInput(String column) {
        return String.format(ERROR_INPUT, column, column);
    }
}
