package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.entity.User;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeMenuDisplay implements Displayable{
    @Setter
    private User user;

    private final MenuText text = new MenuText();

    @Override
    public void display() {
        displayAdminMenu();
    }

    private void displayAdminMenu() {
        AdminMenuDisplay adminMenu = new AdminMenuDisplay();
        adminMenu.setUser(user);
        adminMenu.display();
    }

    private void displayPassengerMenu() {
        System.out.println(text.getPassengerMenuDisplayText(user.getName()));
    }

    @Override
    public Displayable proceedToNextDisplay() {
        return null;
    }
}
