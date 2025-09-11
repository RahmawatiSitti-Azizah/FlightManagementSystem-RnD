package com.mitrais.rnd.FlightManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PassengerOptions {
    BOOK_FLIGHT( "1"),
    MY_BOOKING( "2"),
    NO_OPTIONS("0");

    private final String code;

    public static PassengerOptions fromCode(String code) {
        for (PassengerOptions option : PassengerOptions.values()) {
            if (option.getCode().equals(code)) {
                return option;
            }
        }
        return PassengerOptions.NO_OPTIONS;
    }
}
