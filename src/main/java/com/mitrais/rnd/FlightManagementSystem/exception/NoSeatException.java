package com.mitrais.rnd.FlightManagementSystem.exception;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;

public class NoSeatException extends Exception{
    public NoSeatException() {
        super(ErrorMesssageConstant.NO_SEAT_AVAILABLE);
    }
	

}
