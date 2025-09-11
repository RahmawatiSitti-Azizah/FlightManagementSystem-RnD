package com.mitrais.rnd.FlightManagementSystem.controller.admin;

import com.mitrais.rnd.FlightManagementSystem.constant.MenuText;
import com.mitrais.rnd.FlightManagementSystem.controller.Displayable;
import com.mitrais.rnd.FlightManagementSystem.enums.SystemOperationsOptions;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor
public class SystemOperationDisplay implements Displayable {
    private final NextDayDisplay nextDayDisplay;
    private final EnableBookingDisplay enableBookingDisplay;
    private final DisableBookingDisplay disableBookingDisplay;
    @Setter
    private Displayable backMenu;

    @Override
    public void display() {
        System.out.println(MenuText.SYSTEM_OPERATION_HEADER);
        for (SystemOperationsOptions menu: SystemOperationsOptions.values()){
            System.out.println(menu);
        }
        System.out.println(MenuText.SELECT_MENU_TEXT);
    }

    private Displayable processMenuFromInput(){
        Scanner scanner = new Scanner(System.in);
        SystemOperationsOptions option = SystemOperationsOptions.fromCode(scanner.nextLine());
        switch (option){
            case ADVANCE_DAY : {
                nextDayDisplay.setBackMenu(this);
                return nextDayDisplay;
            }
            case RUN_FLIGHT:{
                System.out.println("RUN FLIGHT HERE");
            }
            case ENABLE_BOOKING:{
                enableBookingDisplay.setBackMenu(this);
                return enableBookingDisplay;
            }
            case DISABLE_BOOKING:{
                disableBookingDisplay.setBackMenu(this);
                return disableBookingDisplay;
            }
        }
        return null;
    }

    @Override
    public Displayable proceedToNextDisplay() {
        display();
        return processMenuFromInput();
    }
}
