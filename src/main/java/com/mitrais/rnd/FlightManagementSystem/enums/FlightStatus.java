package com.mitrais.rnd.FlightManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FlightStatus {
	SCHEDULED( "Scheduled"),
	ONFLIGHT( "On Flight"),
	ARRIVED("Arrived");
	
	private final String code;
}
