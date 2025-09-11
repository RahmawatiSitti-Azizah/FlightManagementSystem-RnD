package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.entity.Aircraft;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.service.AircraftService;
import com.mitrais.rnd.FlightManagementSystem.service.DestinationService;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CreateRouteHandler {
    private final AircraftService aircraftService;
    private final DestinationService destinationService;
    private final RouteService routeService;

    public void showCreateRoute() {
        showAircraftList();
        showDestinationList();
        showDepartureList();
    }

    private void showDepartureList() {
        System.out.println(MenuText.DEPARTURE_LIST);
        showAvailableDestination();

    }

    private void showDestinationList() {
        System.out.println(MenuText.DESTINATION_LIST);
        showAvailableDestination();
    }

    private void showAvailableDestination() {

        List<Destination> destinationList = destinationService.getAvailableDestination();

        String departureDisplay = destinationList.stream().map(Destination::getName).collect(Collectors.joining(","));
        System.out.println(departureDisplay);
    }

    private void showAircraftList() {
        System.out.println(MenuText.AIRCRAFT_LIST);

        List<Aircraft> aircraftList = aircraftService.getAvailableAircraft();

        String aircraftDisplay = aircraftList.stream().map(Aircraft::getName).collect(Collectors.joining(","));
        System.out.println(aircraftDisplay);
    }

    private Destination getDeparture(Scanner scanner) {
        System.out.print(MenuText.ENTER_DEPARTURE);
        String inputDeparture = scanner.nextLine();
        try {
            return destinationService.getDestinationCityByName(inputDeparture);
        } catch (Exception e) {
            System.out.println(MenuText.showErrorInput("Departure"));
            return getDeparture(scanner);
        }
    }

    private Destination getDestination(Scanner scanner) {
        System.out.print(MenuText.ENTER_DESTINATION_NAME);
        String inputDestination = scanner.nextLine();
        try {
            return destinationService.getDestinationCityByName(inputDestination);
        } catch (Exception e) {
            System.out.println(MenuText.showErrorInput("Destination"));
            return getDestination(scanner);
        }
    }

    private Aircraft getAircraft(Scanner scanner) {
        System.out.print(MenuText.ENTER_AIRCRAFT_NAME);
        String inputAircraft = scanner.nextLine();
        try {
            return aircraftService.getAircraftByName(inputAircraft);
        } catch (Exception e) {
            System.out.println(MenuText.showErrorInput("Aircraft"));
            return getAircraft(scanner);
        }
    }

    private String getFlightDay(Scanner scanner) {
        System.out.print(MenuText.ENTER_DAY);
        return scanner.nextLine();
    }

    public Route getRouteInput() {
        Scanner scanner = new Scanner(System.in);
        Destination departure = getDeparture(scanner);
        Destination destination = getDestination(scanner);
        Aircraft aircraft = getAircraft(scanner);
        String flightDay = getFlightDay(scanner);

        return new Route(null, aircraft, departure, destination, flightDay);
    }


    public void addNewRoute(Route route) throws Exception {

        try {
            routeService.addRoute(route);
            System.out.println(MenuText.getSuccessAddRoute(route));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
