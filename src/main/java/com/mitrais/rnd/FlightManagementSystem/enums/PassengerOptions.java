package com.mitrais.rnd.FlightManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PassengerOptions {
    BOOK_FLIGHT( "1", "Book Flight"),
    MY_BOOKING( "2","My Bookings"),
    NO_OPTIONS("0","Logout");

    private final String code;
    private final String display;

    public static PassengerOptions fromCode(String code) {
        for (PassengerOptions option : PassengerOptions.values()) {
            if (option.getCode().equals(code)) {
                return option;
            }
        }
        return PassengerOptions.NO_OPTIONS;
    }

    @Override
    public String toString() {
        return code + ". " + display;
    }
}
