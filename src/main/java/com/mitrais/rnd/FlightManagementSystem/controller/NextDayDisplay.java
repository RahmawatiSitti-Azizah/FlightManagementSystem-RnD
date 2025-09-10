package com.mitrais.rnd.FlightManagementSystem.controller;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;

public class NextDayDisplay implements Displayable{

    @Override
    public void display() {
        System.out.println(MenuText.NEXT_DAY_DISPLAY);
    }

    @Override
    public Displayable proceedToNextDisplay() {
        return null;
    }
}
