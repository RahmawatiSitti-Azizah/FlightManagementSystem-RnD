package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;

public interface BookingService {
    public Booking createBooking(Route route) throws NoSeatException;
}
