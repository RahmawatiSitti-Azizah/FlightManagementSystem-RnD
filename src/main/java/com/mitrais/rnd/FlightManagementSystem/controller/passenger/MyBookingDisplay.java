package com.mitrais.rnd.FlightManagementSystem.controller.passenger;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.entity.Booking;
import com.mitrais.rnd.FlightManagementSystem.enums.BookingStatus;
import com.mitrais.rnd.FlightManagementSystem.enums.MyBookingOptions;
import com.mitrais.rnd.FlightManagementSystem.service.BookingService;
import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class MyBookingDisplay implements Displayable {
    private final BookingService bookingService;
    @Setter
    private Displayable backMenu;
    private List<Booking> bookings;

    @Override
    public void display() {
        System.out.println(MenuText.YOUR_BOOKING);
        bookings = bookingService.getBookingBy(UserContextHolder.getUserContext(), BookingStatus.CREATED);
        int index = 1;
        for(Booking booking: bookings){
            System.out.println(MenuText.getMyFlightDisplay(index++, booking));
        }
        Arrays.stream(MyBookingOptions.values()).forEach(menu -> System.out.println(menu));
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        Scanner scanner = new Scanner(System.in);
        System.out.print(MenuText.SELECT_MENU_TEXT);
        MyBookingOptions option = MyBookingOptions.fromCode(scanner.nextLine());
        if(MyBookingOptions.DELETE == option){
            deleteBookingProcess(scanner);
        }
        return backMenu;
    }

    private void deleteBookingProcess(Scanner scanner) {
        System.out.print(MenuText.ENTER_BOOKING_ID_TO_CANCEL);
        String bookingId = scanner.nextLine();
        Booking selectedBooking = bookings.stream().filter(booking -> booking.getBooking_id().equalsIgnoreCase(bookingId)).findFirst().orElse(null);

        if(selectedBooking == null){
            System.out.println(MenuText.BOOKING_ID_NOT_FOUND);
            deleteBookingProcess(scanner);
        }else {
            List<Booking> deletedBookings= new ArrayList<>();
            deletedBookings.add(selectedBooking);
            if(selectedBooking.getTransit_booking_id() != null){
                Booking bookingPair = bookings.stream().filter(booking -> booking.getBooking_id().equalsIgnoreCase(selectedBooking.getTransit_booking_id())).findFirst().orElse(null);
                if(bookingPair!=null){
                    deletedBookings.add(bookingPair);
                }
            }
            bookingService.updateBookingStatus(deletedBookings, BookingStatus.CANCELED);
        }
    }
}
