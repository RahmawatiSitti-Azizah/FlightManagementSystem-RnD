package com.mitrais.rnd.FlightManagementSystem.controller;

import static com.mitrais.rnd.FlightManagementSystem.constant.MenuText.*;

import com.mitrais.rnd.FlightManagementSystem.service.DestinationService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class DestinationManagementDisplay implements Displayable{
    private final DestinationService service;
    @Setter
    private Displayable nextScreen;
    @Override
    public void display() {
        System.out.println(ADD_DESTINATION_HEADER);
        System.out.print(ENTER_DESTINATION_NAME);
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            service.save(name);
            System.out.println(getDestinationSuccessfullyAdded(name));
        } catch (EntityExistsException e){
            System.out.println(e.getMessage());
        }
        return nextScreen;
    }
}
