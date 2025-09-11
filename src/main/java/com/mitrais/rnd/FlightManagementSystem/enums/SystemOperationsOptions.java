package com.mitrais.rnd.FlightManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SystemOperationsOptions {
    ADVANCE_DAY( "1","Advance to next day"),
    RUN_FLIGHT( "2","Run Flight"),
    ENABLE_DISABLE_BOOKING( "3","Enable/Disable Booking Service"),
    BACK_TO_MAIN_MENU("0","Back to Admin menu");

    private final String code;
    private final String display;

    public static SystemOperationsOptions fromCode(String code) {
        for (SystemOperationsOptions option : SystemOperationsOptions.values()) {
            if (option.getCode().equals(code)) {
                return option;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return code + ". " + display;
    }
}
