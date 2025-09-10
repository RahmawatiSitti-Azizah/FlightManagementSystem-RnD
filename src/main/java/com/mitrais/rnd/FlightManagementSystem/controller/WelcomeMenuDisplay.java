package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeMenuDisplay implements Displayable{
    private AppUser appUser;

    public void setUser(AppUser appUser) {
        System.out.println("set user to Welcome Menu Display");
        this.appUser = appUser;
    }

    @Override
    public void display() {

    }

    @Override
    public Displayable proceedToNextDisplay() {
        return null;
    }
}
