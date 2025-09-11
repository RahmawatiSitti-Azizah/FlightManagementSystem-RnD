package com.mitrais.rnd.FlightManagementSystem.constant;

public class ErrorMesssageConstant {
    public static final String DESTINATION_ALREADY_EXISTS  = "Destination name already exists please use other name";
    public static final String SAME_DEPARTURE_DESTINATION_ERROR  = "Departure and destination must be different. Please check your input.\n";
    private static final String ERROR_INPUT = "%s is not available. Please enter available %s";
    public static final String ERROR_INPUT_FLIGHT_DAY  = "Flight day must be number. Please enter valid input";

    public static String showErrorInput(String column) {
        return String.format(ERROR_INPUT, column, column);
    }
}
