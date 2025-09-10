package com.mitrais.rnd.FlightManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid default RANDOM_UUID()")
    private UUID id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String role;
}
