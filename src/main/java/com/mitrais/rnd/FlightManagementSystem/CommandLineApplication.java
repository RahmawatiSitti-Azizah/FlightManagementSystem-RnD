package com.mitrais.rnd.FlightManagementSystem;

import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.controller.LoginDisplay;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandLineApplication implements CommandLineRunner {
    private final LoginDisplay loginDisplay;

    @Override
    public void run(String... args) throws Exception {
        //Start the cli from here
        Displayable screen = loginDisplay;
        while(screen != null){
            screen = screen.proceedToNextDisplay();
        }
    }
}
