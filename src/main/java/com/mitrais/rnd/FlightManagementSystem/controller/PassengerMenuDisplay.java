package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.constant.PassengerOptions;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class PassengerMenuDisplay implements Displayable{

    @Override
    public void display() {
        System.out.println(MenuText.getAdminMenuDisplayText(UserContextHolder.getUserContext().getName()));
        manageMenu();
    }

    private void manageMenu() {
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.nextLine();
        PassengerOptions menuOption = PassengerOptions.fromCode(menu);
        switch (menuOption) {
            case BOOK_FLIGHT:
                System.out.println("book flight");
                break;
            case MY_BOOKING:
                System.out.println("my booking");
                break;
            default:
                System.out.println("default");
                break;
        }
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return null;
    }
}
