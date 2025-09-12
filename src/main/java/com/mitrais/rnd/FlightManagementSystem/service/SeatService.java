package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.Seat;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;

import java.util.List;

public interface SeatService {
	public void populateSeatsOnRoute(Route route);
	public Seat getAvailableSeat(Route route) throws NoSeatException;
	public List<Seat> getOccupiedSeatByRoute(Route route);
}
