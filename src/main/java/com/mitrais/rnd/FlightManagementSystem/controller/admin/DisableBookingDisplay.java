package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DisableBookingDisplay implements Displayable {
    private final SystemService systemService;
    @Setter
    private Displayable backMenu;

    @Override
    public void display() {
        System.out.println(MenuText.DISABLE_BOOKING_SERVICE);
        systemService.setBookingServiceStatus(false);
        System.out.println(MenuText.SUCCESS_DISABLE_BOOKING_SERVICE);
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return backMenu;
    }
}
