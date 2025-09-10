package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.controller.DestinationManagementDisplay;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.controller.RegisterAircraftDisplay;
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
    private final CreateRouteDisplay createRouteDisplay;

    @Override
    public void display() {
        System.out.println(MenuText.getAdminMenuDisplayText(UserContextHolder.getUserContext().getName()));
    }

    private Displayable getNextDisplay() {
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.nextLine();
        AdminOptions menuOption = AdminOptions.fromCode(menu);

        switch (menuOption) {
            case AIRCRAFTREGISTER:
                registerAircraftDisplayScreen.setBackMenu(this);
                return registerAircraftDisplayScreen;
            case ADD_DESTINATION:
                destinationManagementDisplay.setNextScreen(this);
                return destinationManagementDisplay;
            case CREATE_ROUTE:
                createRouteDisplay.setBackMenuDisplay(this);
                return createRouteDisplay;
            case SYSTEM_OPERATION:
                System.out.println("system operation");
                break;
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
