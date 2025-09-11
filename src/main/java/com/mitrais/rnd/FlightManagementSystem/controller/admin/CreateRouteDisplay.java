package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.service.AircraftService;
import com.mitrais.rnd.FlightManagementSystem.service.DestinationService;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CreateRouteDisplay implements Displayable {

    private final CreateRouteHandler createRouteHandler;

    @Setter
    private Displayable backMenuDisplay;

    @Override
    public void display() {
        System.out.println(MenuText.ADD_NEW_ROUTE_HEADER);
        createRouteHandler.showCreateRoute();
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();

        Route route = createRouteHandler.getRouteInput();
        try {
            createRouteHandler.addNewRoute(route);
        } catch (Exception e) {
            return this;
        }

        return backMenuDisplay;
    }
}