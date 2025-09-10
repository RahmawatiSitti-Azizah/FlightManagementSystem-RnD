package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import com.mitrais.rnd.FlightManagementSystem.constant.AdminOptions;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class AdminMenuDisplay implements Displayable{
    private final DestinationManagementDisplay destinationManagementDisplay;

    @Override
    public void display() {
        System.out.println(MenuText.getAdminMenuDisplayText(UserContextHolder.getUserContext().getName()));
    }

    private Displayable manageMenu() {
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.nextLine();
        AdminOptions menuOption = AdminOptions.fromCode(menu);

        switch (menuOption) {
            case AIRCRAFTREGISTER:
                System.out.println("aircraft");
                break;
            case ADD_DESTINATION:
                System.out.println("add destination");
                destinationManagementDisplay.setNextScreen(this);
                return destinationManagementDisplay;
            case CREATE_ROUTE:
                System.out.println("create route");
                break;
            case SYSTEM_OPERATION:
                System.out.println("system operation");
                break;
            default:
                System.out.println("error");
                break;
        }
        return null;
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return manageMenu();
    }
}
