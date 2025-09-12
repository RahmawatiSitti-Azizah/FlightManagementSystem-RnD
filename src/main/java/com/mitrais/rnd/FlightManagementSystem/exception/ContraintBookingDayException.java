package com.mitrais.rnd.FlightManagementSystem.exception;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;

public class ContraintBookingDayException extends Exception{
    public ContraintBookingDayException() {
        super(ErrorMesssageConstant.CONSTRAINT_BOOKING_DAY_ERROR);
    }
	

}
