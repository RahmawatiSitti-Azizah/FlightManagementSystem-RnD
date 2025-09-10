package com.mitrais.rnd.FlightManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "aircraft_id", nullable = true)
    private Aircraft aircraft;
    @OneToOne
    @JoinColumn(name = "from_destination_id", nullable = true)
    private Destination fromDestination;
    @OneToOne
    @JoinColumn(name = "to_destination_id", nullable = true)
    private Destination toDestination;
}
