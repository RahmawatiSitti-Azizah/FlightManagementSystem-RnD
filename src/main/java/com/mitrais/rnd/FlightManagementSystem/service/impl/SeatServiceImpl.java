package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.Seat;
import com.mitrais.rnd.FlightManagementSystem.repository.SeatRepository;
import com.mitrais.rnd.FlightManagementSystem.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
	
	private final SeatRepository seatRepository;
	
	@Override
	public void populateSeatsOnRoute(Route route) {
		int index = 0;
		List<Seat> seats = new ArrayList<>();

		do {
			Seat seat = new Seat(null, route.getId(), ++index, true);
			seats.add(seat);
		} while (index<route.getAircraft().getSeatCapacity());
		
		seatRepository.saveAll(seats);
	}
}
