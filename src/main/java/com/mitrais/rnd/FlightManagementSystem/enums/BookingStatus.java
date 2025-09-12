package com.mitrais.rnd.FlightManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BookingStatus {
	ISSUED( "issued"),
	TRANSIT( "transit"),
	ARRIVED( "arrived"),
	CANCELED("canceled"),
	NO_OPTIONS("0");
	
	private final String code;
	
	public static BookingStatus fromCode(String code) {
		for (BookingStatus option : BookingStatus.values()) {
			if (option.getCode().equals(code)) {
				return option;
			}
		}
		return BookingStatus.NO_OPTIONS;
	}
}
