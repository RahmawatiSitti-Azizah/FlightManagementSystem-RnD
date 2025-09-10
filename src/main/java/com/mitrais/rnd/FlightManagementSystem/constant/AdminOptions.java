package com.mitrais.rnd.FlightManagementSystem.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdminOptions {
    AIRCRAFTREGISTER( "1"),
    ADD_DESTINATION( "2"),
    CREATE_ROUTE( "3"),
    SYSTEM_OPERATION("4"),
    GO_TO_NEXT_DAY("5"),
    NO_OPTIONS("0");

    private final String code;

    public static AdminOptions fromCode(String code) {
        for (AdminOptions option : AdminOptions.values()) {
            if (option.getCode().equals(code)) {
                return option;
            }
        }
        return AdminOptions.NO_OPTIONS;
    }
}
