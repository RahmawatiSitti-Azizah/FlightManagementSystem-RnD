package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.entity.User;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeMenuDisplay implements Displayable{
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void display() {

    }

    @Override
    public Displayable proceedToNextDisplay() {
        return null;
    }
}
