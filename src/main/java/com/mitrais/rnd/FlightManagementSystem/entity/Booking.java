package com.mitrais.rnd.FlightManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String booking_id;
    @OneToOne
    @JoinColumn(name = "aircraft_id", nullable = true)
    private Aircraft aircraft;
    @OneToOne
    @JoinColumn(name = "transit_destination_id", nullable = true)
    private Destination transitDestination;
    @OneToOne
    @JoinColumn(name = "from_destination_id", nullable = true)
    private Destination fromDestination;
    @OneToOne
    @JoinColumn(name = "to_destination_id", nullable = true)
	private Destination toDestination;
	@OneToOne
	@JoinColumn(name="seat_id", nullable = false)
	private int seatId;
    private int flightDay;
    private String status;
}
