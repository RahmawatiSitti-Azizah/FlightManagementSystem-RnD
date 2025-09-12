package com.mitrais.rnd.FlightManagementSystem.handler;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.entity.Destination;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.exception.BookingNotConfirmedException;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import com.mitrais.rnd.FlightManagementSystem.service.DestinationService;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SearchFlightHandler {
    private final BookingService bookingService;
    private final DestinationService destinationService;
    private final RouteService routeService;
    private Destination departure;
    private Destination destination;

    public void showCreateBooking() {
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

    private Destination scanDeparture(Scanner scanner) {
        System.out.print(MenuText.ENTER_DEPARTURE);
        String inputAircraft = scanner.nextLine();
        try {
            return destinationService.getDestinationCityByName(inputAircraft);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return scanDeparture(scanner);
        }
    }

    private Destination scanDestination(Scanner scanner) {
        System.out.print(MenuText.ENTER_DESTINATION_NAME);
        String inputAircraft = scanner.nextLine();
        try {
            return destinationService.getDestinationCityByName(inputAircraft);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return scanDestination(scanner);
        }
    }

    private int getFlightDay(Scanner scanner) {
        System.out.print(MenuText.ENTER_DAY);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(ErrorMesssageConstant.ERROR_INPUT_NON_NUMBER);
            return getFlightDay(scanner);
        }
    }

    private List<Route> findFlights(Destination departure, Destination destination){
           return routeService.findRouteByDepartureDestination(departure, destination);
    }

    public List<Route> searchForFlight(){
        Scanner scanner = new Scanner(System.in);
        departure = scanDeparture(scanner);
        destination = scanDestination(scanner);

        System.out.println(MenuText.SEARCH_FLIGHT);
        return findFlights(departure, destination);
    }

    public List<Route[]> searchForTransitFlights() throws BookingNotConfirmedException{
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equalsIgnoreCase("y")) {
            return routeService.findRouteTransitByDepartureDestination(departure, destination);
        }else{
            throw new BookingNotConfirmedException();
        }
    }
}
