package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EnableBookingDisplay implements Displayable {
    private final SystemService systemService;
    @Setter
    private Displayable backMenu;

    @Override
    public void display() {
        System.out.println(MenuText.ENABLE_BOOKING_SERVICE);
        systemService.setBookingServiceStatus(true);
        System.out.println(MenuText.SUCCESS_ENABLE_BOOKING_SERVICE);
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return backMenu;
    }
}
