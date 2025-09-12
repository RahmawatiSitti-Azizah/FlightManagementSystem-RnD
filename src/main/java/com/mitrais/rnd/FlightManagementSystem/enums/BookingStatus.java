package com.mitrais.rnd.FlightManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BookingStatus {
	CREATED( "created"),
	ARRIVED( "arrived"),
	CANCELED("canceled");
	
	private final String code;
	
	public static BookingStatus fromCode(String code) {
		for (BookingStatus option : BookingStatus.values()) {
			if (option.getCode().equals(code)) {
				return option;
			}
		}
		return null;
	}
}
