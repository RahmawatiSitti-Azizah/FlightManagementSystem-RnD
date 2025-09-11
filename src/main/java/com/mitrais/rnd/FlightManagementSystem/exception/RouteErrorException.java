package com.mitrais.rnd.FlightManagementSystem.exception;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import lombok.NoArgsConstructor;

public class RouteErrorException extends Exception{
    public RouteErrorException() {
        super(ErrorMesssageConstant.SAME_DEPARTURE_DESTINATION_ERROR);
    }
}
