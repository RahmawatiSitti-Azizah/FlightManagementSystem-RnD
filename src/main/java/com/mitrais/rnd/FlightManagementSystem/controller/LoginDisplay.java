package com.mitrais.rnd.FlightManagementSystem.controller;

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
    private String username;
    private String password;
    private final AuthenticationService authenticationService;
    private final AdminMenuDisplay adminMenu;
    private final PassengerMenuDisplay passengerMenu;

    @Override
    public void display() {
        System.out.println("---------------------------------------");
        System.out.println("Welcome to RnD Flight Management System");
        System.out.println("---------------------------------------");
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
        System.out.print("username : ");
        username = scanner.nextLine();
    }

    private void setPasswordByInputUser(Scanner scanner){
        System.out.print("password : ");
        password = scanner.nextLine();
    }
}
