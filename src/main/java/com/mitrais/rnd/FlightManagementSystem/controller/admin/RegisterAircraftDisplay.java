package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class RegisterAircraftDisplay implements Displayable {

    private final AircraftService aircraftService;

    private Displayable menuDisplay;

    public void setBackMenu(Displayable menuDisplay) {
        this.menuDisplay = menuDisplay;
    }

    @Override
    public void display() {
        System.out.println(MenuText.REGISTER_AIRCRAFT_HEADER);
    }

    private Aircraft getAircraft(Scanner scanner) {
        System.out.print(MenuText.ENTER_AIRCRAFT_NAME);
        String aircraftName = scanner.nextLine();

        System.out.print(MenuText.AIRCRAFT_CAPACITY);
        int seatCapacity = Integer.parseInt(scanner.nextLine());

        return new Aircraft(null, aircraftName, seatCapacity);
    }

    private void addNewAircraft(Aircraft aircraft) {

        try {
            aircraftService.registerAircraft(aircraft);
            System.out.println(MenuText.getSuccessAddAircraft(aircraft.getName(), aircraft.getSeatCapacity()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();

        Scanner scanner = new Scanner(System.in);
        Aircraft aircraft = getAircraft(scanner);

        addNewAircraft(aircraft);

        return menuDisplay;
    }
}