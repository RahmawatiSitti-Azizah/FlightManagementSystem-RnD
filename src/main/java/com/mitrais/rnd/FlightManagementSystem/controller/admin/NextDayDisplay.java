package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NextDayDisplay implements Displayable {
    private final SystemService systemService;
    private final RouteService routeService;

    @Setter
    private Displayable backScreen;

    @Override
    public void display() {
        System.out.println(MenuText.NEXT_DAY_DISPLAY);
        systemService.advanceSystemDay();
        System.out.println(MenuText.getCurrentDayDisplay(systemService.getCurrentSystemDay()));
        try {
            for (Route route: routeService.getCurrentDayRoute()){
                System.out.println(MenuText.generateTodayFlightScheduleText(route));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return backScreen;
    }
}
