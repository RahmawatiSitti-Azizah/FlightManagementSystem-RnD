package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.Seat;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;

public interface SeatService {
	public void populateSeatsOnRoute(Route route);
	public Seat getAvailableSeat(Route route) throws NoSeatException;
}
