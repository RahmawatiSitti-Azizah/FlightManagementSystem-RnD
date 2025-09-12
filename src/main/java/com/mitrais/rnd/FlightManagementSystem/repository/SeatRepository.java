package com.mitrais.rnd.FlightManagementSystem.repository;

import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.entity.Seat;
import com.mitrais.rnd.FlightManagementSystem.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
	Optional<Seat> findFirstByRouteAndIsAvailableOrderByRouteAscIsAvailableAsc(Route route, boolean isAvailable);
	public List<Seat> findByRouteIdAndIsAvailable(UUID id, boolean isAvailable);
}
