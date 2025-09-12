package com.mitrais.rnd.FlightManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MyBookingOptions {
    DELETE( "1", "\nDelete Booking"),
    NO_OPTIONS("0","Back to passenger menu");

    private final String code;
    private final String display;

    public static MyBookingOptions fromCode(String code) {
        for (MyBookingOptions option : MyBookingOptions.values()) {
            if (option.getCode().equals(code)) {
                return option;
            }
        }
        return MyBookingOptions.NO_OPTIONS;
    }

    @Override
    public String toString() {
        return code + ". " + display;
    }
}
