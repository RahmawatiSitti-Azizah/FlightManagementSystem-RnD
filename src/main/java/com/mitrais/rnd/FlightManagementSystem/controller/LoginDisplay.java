package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.admin.AdminMenuDisplay;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import com.mitrais.rnd.FlightManagementSystem.util.UserContextHolder;
import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;
import com.mitrais.rnd.FlightManagementSystem.service.AuthenticationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class LoginDisplay implements Displayable{
    private final AuthenticationService authenticationService;
    private final SystemService systemService;
    private final AdminMenuDisplay adminMenu;
    private final PassengerMenuDisplay passengerMenu;
    private String username;
    private String password;

    @Override
    public void display() {
        System.out.println(MenuText.WELCOME_PROGRAM_BANNER);
        System.out.println(MenuText.getCurrentDayDisplay());
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        Scanner scanner = new Scanner(System.in);
        setUsernameByInputUser(scanner);
        setPasswordByInputUser(scanner);
        try {
            AppUser user = authenticationService.login(username, password);
            UserContextHolder.setUserContext(user);
            switch(user.getRole()){
                case "ADMIN":{
                    return adminMenu;
                }
                default:{
                    return passengerMenu;
                }
            }
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
            return this;
        }
    }

    private void setUsernameByInputUser(Scanner scanner){
        System.out.print(MenuText.ENTER_USERNAME);
        username = scanner.nextLine();
    }

    private void setPasswordByInputUser(Scanner scanner){
        System.out.print(MenuText.ENTER_PASSWORD);
        password = scanner.nextLine();
    }
}
