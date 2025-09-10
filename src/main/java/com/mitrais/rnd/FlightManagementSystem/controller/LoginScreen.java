package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class LoginScreen implements Displayable{
    private String username;
    private String password;
    private final AuthenticationService authenticationService;
    private final WelcomeMenuDisplay nextScreen;

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
        nextScreen.setUser(authenticationService.login(username, password));
        return nextScreen;
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
