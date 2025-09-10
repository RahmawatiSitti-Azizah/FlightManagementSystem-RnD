package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.constant.AdminOptions;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.entity.User;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AdminMenuDisplay implements Displayable{
    @Setter
    private User user;

    private final MenuText text = new MenuText();

    @Override
    public void display() {
        System.out.println(text.getAdminMenuDisplayText(user.getName()));
        manageMenu();
    }

    private void manageMenu() {
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
            case SYSTEM_OPERATION:
                System.out.println("system operation");
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    @Override
    public Displayable proceedToNextDisplay() {
        return null;
    }
}
