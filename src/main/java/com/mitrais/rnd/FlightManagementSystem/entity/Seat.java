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
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@OneToOne
	@JoinColumn(name="route_id", nullable = true)
	private Route route;
	private int seatNumber;
	@Column(columnDefinition = "boolean default true")
	private boolean isAvailable;
}
