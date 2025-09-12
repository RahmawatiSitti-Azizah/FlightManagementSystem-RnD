package com.mitrais.rnd.FlightManagementSystem.util;

import com.mitrais.rnd.FlightManagementSystem.entity.Destination;

import java.util.Random;

public class BookingIdGenerator {

    private static String prefixCity(Destination city) {
        return city.getName().substring(0,2); // get 3 alphabets
    }

    private static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        final int length = 6;
        Random random = new Random();

        for (int iteration = 0; iteration < length; iteration++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }

    public static String generateBookingId(Destination departure, Destination destination) {
        String prefixDeparture = prefixCity(departure);
        String prefixDestination = prefixCity(destination);
        String randomString = generateRandomString();

        return prefixDeparture+"-"+prefixDestination+"-"+randomString;
    }
}
