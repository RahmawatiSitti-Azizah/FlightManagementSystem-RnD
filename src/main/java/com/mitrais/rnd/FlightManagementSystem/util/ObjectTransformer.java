package com.mitrais.rnd.FlightManagementSystem.util;

import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;

public class ObjectTransformer {
	public static Booking bookingFromRoute (String bookingId, Route route, int assignedSeat) {
		return new Booking(null, bookingId, route.getAircraft(), null, route.getFromDestination(), route.getToDestination(), route.getFlightDay(), null, assignedSeat);
	}
}
