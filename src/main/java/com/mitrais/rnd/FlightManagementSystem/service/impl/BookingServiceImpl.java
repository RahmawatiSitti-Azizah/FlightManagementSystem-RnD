package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.entity.*;
import com.mitrais.rnd.FlightManagementSystem.enums.BookingStatus;
import com.mitrais.rnd.FlightManagementSystem.exception.ContraintBookingDayException;
import com.mitrais.rnd.FlightManagementSystem.exception.NoSeatException;
import com.mitrais.rnd.FlightManagementSystem.repository.BookingRepository;
import com.mitrais.rnd.FlightManagementSystem.repository.RouteRepository;
import com.mitrais.rnd.FlightManagementSystem.repository.SeatRepository;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import com.mitrais.rnd.FlightManagementSystem.service.SeatService;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import com.mitrais.rnd.FlightManagementSystem.util.BookingIdGenerator;
import com.mitrais.rnd.FlightManagementSystem.util.ObjectTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
	private final BookingRepository bookingRepository;
	private final RouteRepository routeRepository;
	private final SeatRepository seatRepository;
	
	private final SeatService seatService;
	private final SystemService systemService;
	
	@Override
	public Booking createBooking(Route route) throws NoSeatException, ContraintBookingDayException {
		SystemConfig currentSystemDay = systemService.getCurrentSystemDay();
		Integer currentDay = Integer.parseInt(currentSystemDay.getConfigValue());
		if (route.getFlightDay() <= currentDay) {
			throw new ContraintBookingDayException();
		} else {
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
	
	@Override
	public List<Booking> getListBookingByRoute(Route route) {
		List<Booking> result = bookingRepository.findBySeatRouteId(route.getId());
		return result;
	}
	
	@Override
	public void updateBookingStatus(List<Booking> bookings, BookingStatus status) {
		bookings = bookings.stream().map(booking -> {booking.setStatus(status.name());
			return booking;}).toList();
		bookingRepository.saveAll(bookings);
	}
	
	@Override
	@Transactional
	public Booking[] createBooking(Route[] routes) throws NoSeatException, ContraintBookingDayException {
		Booking[] result = new Booking[2];
		int index = 0;
		for (Route route : routes) {
			result[index++] = createBooking(route);
		}
		result[0].setTransit_booking_id(result[1].getBooking_id());
		result[1].setTransit_booking_id(result[0].getBooking_id());
		bookingRepository.saveAll(Arrays.asList(result));
		return result;
		
	}
	
	@Override
	public List<Booking> getBookingBy(AppUser appUser, BookingStatus status) {
		return bookingRepository.findByUserIdAndStatus(appUser.getId(), status.name());
	}
}
