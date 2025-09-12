package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.enums.BookingStatus;
import com.mitrais.rnd.FlightManagementSystem.exception.ContraintBookingDayException;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;

import java.util.List;

public interface BookingService {
    public Booking createBooking(Route route) throws NoSeatException, ContraintBookingDayException;
    public List<Booking> getListBookingByRoute(Route route);
    public void updateBookingStatus(List<Booking> bookings, BookingStatus status);
    public Booking[] createBooking(Route[] route) throws NoSeatException, ContraintBookingDayException;
    public List<Booking> getBookingBy(AppUser appUser, BookingStatus status);
}
