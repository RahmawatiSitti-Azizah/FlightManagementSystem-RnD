package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;
import com.mitrais.rnd.FlightManagementSystem.repository.BookingRepository;
import com.mitrais.rnd.FlightManagementSystem.repository.RouteRepository;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import com.mitrais.rnd.FlightManagementSystem.util.BookingIdGenerator;
import com.mitrais.rnd.FlightManagementSystem.util.ObjectTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
	private final RouteRepository routeRepository;

    @Override
    public Booking createBooking(Route route) throws NoSeatException {
		String bookingId = BookingIdGenerator.generateBookingId(route.getFromDestination(), route.getToDestination());
		
		if (route.getAvailableSeats() == 0) {
			throw new NoSeatException();
		}
		int seatNumber = route.getAircraft().getSeatCapacity() - route.getAvailableSeats() + 1;
		int availableSeat = route.getAvailableSeats() - 1;
		Booking booking = ObjectTransformer.bookingFromRoute(bookingId, route, seatNumber);
		
        bookingRepository.save(booking);
		routeRepository.updateSeatAvailable(booking.getAircraft().getId(), availableSeat );
		return booking;
    }
}
