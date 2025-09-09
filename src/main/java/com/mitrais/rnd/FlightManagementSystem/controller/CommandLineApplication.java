package com.mitrais.rnd.FlightManagementSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandLineApplication implements CommandLineRunner {
    private final LoginScreen loginScreen;

    @Override
    public void run(String... args) throws Exception {
        //Start the cli from here
        Displayable screen = loginScreen;
        while(screen != null){
            screen = screen.proceedToNextDisplay();
        }
    }
}
