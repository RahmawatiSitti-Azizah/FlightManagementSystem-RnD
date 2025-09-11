package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class NextDayDisplay implements Displayable {
    private final SystemService systemService;

    @Setter
    private Displayable backScreen;

    @Override
    public void display() {
        System.out.println(MenuText.NEXT_DAY_DISPLAY);
        systemService.advanceSystemDay();
        System.out.println(MenuText.getCurrentDayDisplay(systemService.getCurrentSystemDay()));
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return backScreen;
    }
}
