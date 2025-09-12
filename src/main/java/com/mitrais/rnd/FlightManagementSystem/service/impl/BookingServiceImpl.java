package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.Seat;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;
import com.mitrais.rnd.FlightManagementSystem.repository.BookingRepository;
import com.mitrais.rnd.FlightManagementSystem.repository.RouteRepository;
import com.mitrais.rnd.FlightManagementSystem.repository.SeatRepository;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import com.mitrais.rnd.FlightManagementSystem.service.SeatService;
import com.mitrais.rnd.FlightManagementSystem.util.BookingIdGenerator;
import com.mitrais.rnd.FlightManagementSystem.util.ObjectTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
	private final RouteRepository routeRepository;
	private final SeatRepository seatRepository;
	
	private final SeatService seatService;

    @Override
    public Booking createBooking(Route route) throws NoSeatException {
		String bookingId = BookingIdGenerator.generateBookingId(route.getFromDestination(), route.getToDestination());
		
		if (route.getAvailableSeats() == 0) {
			throw new NoSeatException();
		}
		
		Seat seatNumber = seatService.getAvailableSeat(route);
		Booking booking = ObjectTransformer.bookingFromRoute(bookingId, route, seatNumber);
		
		int availableSeat = route.getAvailableSeats() - 1;
		
        bookingRepository.save(booking);
		
		route.setAvailableSeats(availableSeat);
		routeRepository.save(route);
		
		seatNumber.setAvailable(false);
		seatRepository.save(seatNumber);
		
		return booking;
    }
}
