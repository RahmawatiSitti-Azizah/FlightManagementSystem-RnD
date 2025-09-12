package com.mitrais.rnd.FlightManagementSystem.util;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.Seat;
import com.mitrais.rnd.FlightManagementSystem.enums.BookingStatus;

public class ObjectTransformer {
	public static Booking bookingFromRoute (String bookingId, Route route, Seat assignedSeat) {
		AppUser user = UserContextHolder.getUserContext();
		return new Booking(null, bookingId, null, route.getAircraft(), route.getFromDestination(), route.getToDestination(), route.getFlightDay(), BookingStatus.ISSUED.name(), assignedSeat, user);
	}
}
