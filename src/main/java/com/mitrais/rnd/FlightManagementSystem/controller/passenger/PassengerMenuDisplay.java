package com.mitrais.rnd.FlightManagementSystem.controller.passenger;

import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.enums.SystemOperationsOptions;
import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.enums.PassengerOptions;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class PassengerMenuDisplay implements Displayable {
	private final BookingFlightDisplay bookingFlightDisplay;
    private final MyBookingDisplay myBookingDisplay;
    @Setter
    private Displayable backMenu;

    @Override
    public void display() {
        System.out.println(MenuText.getPassengerMenuDisplayText(UserContextHolder.getUserContext().getName()));
        for (PassengerOptions menu: PassengerOptions.values()){
            System.out.println(menu);
        }
        System.out.print(MenuText.SELECT_MENU_TEXT);
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
                myBookingDisplay.setBackMenu(this);
                return myBookingDisplay;
            default:
                UserContextHolder.setUserContext(null);
                return backMenu;
        }
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return manageMenu();
    }
}
