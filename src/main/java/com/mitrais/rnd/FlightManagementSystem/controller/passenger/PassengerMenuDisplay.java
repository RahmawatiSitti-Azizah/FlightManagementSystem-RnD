package com.mitrais.rnd.FlightManagementSystem.controller.passenger;

import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.enums.PassengerOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class PassengerMenuDisplay implements Displayable {
	
	private final BookingFlightDisplay bookingFlightDisplay;

    @Override
    public void display() {
        System.out.println(MenuText.getPassengerMenuDisplayText(UserContextHolder.getUserContext().getName()));
    }

    private Displayable manageMenu() {
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.nextLine();
        PassengerOptions menuOption = PassengerOptions.fromCode(menu);
        switch (menuOption) {
            case BOOK_FLIGHT:
				bookingFlightDisplay.setBackMenuDisplay(this);
				return bookingFlightDisplay;
            case MY_BOOKING:
                System.out.println("my booking");
                break;
            default:
                System.out.println("default");
                break;
        }
        return null;
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return manageMenu();
    }
}
