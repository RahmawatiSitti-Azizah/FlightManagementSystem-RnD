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
    private final NextDayDisplay nextDayDisplay;

    @Override
    public void display() {
        System.out.println(MenuText.getAdminMenuDisplayText(UserContextHolder.getUserContext().getName()));
        manageMenu();
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
                break;
            case CREATE_ROUTE:
                System.out.println("create route");
                break;
            case GO_TO_NEXT_DAY:
                return nextDayDisplay;
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
