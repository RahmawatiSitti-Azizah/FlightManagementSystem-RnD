package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.constant.AdminOptions;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.constant.PassengerOptions;
import com.mitrais.rnd.FlightManagementSystem.entity.User;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class PassengerMenuDisplay implements Displayable{
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
        return null;
    }
}
