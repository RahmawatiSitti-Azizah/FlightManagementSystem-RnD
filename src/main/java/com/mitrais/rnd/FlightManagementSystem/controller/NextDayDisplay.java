package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class NextDayDisplay implements Displayable{
    private final SystemService systemService;

    @Override
    public void display() {
        System.out.println(MenuText.NEXT_DAY_DISPLAY);
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        systemService.advanceSystemDay();
        return null;
    }
}
