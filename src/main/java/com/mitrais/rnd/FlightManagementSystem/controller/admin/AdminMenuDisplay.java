package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import com.mitrais.rnd.FlightManagementSystem.enums.AdminOptions;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class AdminMenuDisplay implements Displayable {
    private final DestinationManagementDisplay destinationManagementDisplay;
    private final RegisterAircraftDisplay registerAircraftDisplayScreen;
    private final SystemOperationDisplay systemOperationDisplay;

    @Override
    public void display() {
        System.out.println(MenuText.getAdminMenuDisplayText(UserContextHolder.getUserContext().getName()));
    }

    private Displayable getNextDisplay() {
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.nextLine();
        AdminOptions menuOption = AdminOptions.fromCode(menu);

        switch (menuOption) {
            case AIRCRAFTREGISTER: {
                registerAircraftDisplayScreen.setBackMenu(this);
                return registerAircraftDisplayScreen;
            }
            case ADD_DESTINATION: {
                destinationManagementDisplay.setNextScreen(this);
                return destinationManagementDisplay;
            }
            case CREATE_ROUTE:
                System.out.println("create route");
                break;
            case SYSTEM_OPERATION: {
                systemOperationDisplay.setBackScreen(this);
                return systemOperationDisplay;
            }
            default:
                System.out.println("error");
                break;
        }
        return this;
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return getNextDisplay();
    }
}
