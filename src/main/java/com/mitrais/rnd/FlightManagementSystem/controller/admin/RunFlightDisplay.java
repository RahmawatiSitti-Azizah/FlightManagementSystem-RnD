package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.enums.FlightStatus;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RunFlightDisplay implements Displayable {
    private final SystemService systemService;
    private final RouteService routeService;
    private final BookingService bookingService;
    @Setter
    private Displayable backMenu;

    @Override
    public void display() {
        String day = systemService.getCurrentSystemDay().getConfigValue();
        System.out.println(MenuText.getRunningFlightForDay(day));
        List<Route> routes = routeService.getCurrentDayRoute();
        if(routes.isEmpty()){
            System.out.println(MenuText.NO_FLIGHT_AVAILABLE_TODAY);
        }else {
            for (Route route : routes) {
                runFlightSimulation(route);
                routeService.updateRouteStatus(route, FlightStatus.ARRIVED);
            }
            System.out.println(MenuText.getSuccessRunningFlightForDay(day));
        }
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return backMenu;
    }

    private void runFlightSimulation(Route route){
        System.out.println(MenuText.getProcessingFlight(route.getFromDestination().getName(), route.getToDestination().getName()));
        System.out.println(MenuText.getAircraftName(route.getAircraft().getName()));
        System.out.println(MenuText.getPassengerBoarding(0));
        List<Booking> passengerList = bookingService.getListBookingByRoute(route);
        System.out.println(MenuText.getPassengerBoarding(passengerList.size()));
        for(Booking passenger : passengerList){
            System.out.println(MenuText.getPassengerListText(passenger.getUser().getName(),String.valueOf(passenger.getSeat().getSeatNumber())));
        }
        System.out.println(MenuText.getProcessFlight());
    }
}
