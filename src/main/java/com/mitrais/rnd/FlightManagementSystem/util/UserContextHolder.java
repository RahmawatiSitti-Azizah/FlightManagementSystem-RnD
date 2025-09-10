package com.mitrais.rnd.FlightManagementSystem.util;

import com.mitrais.rnd.FlightManagementSystem.entity.AppUser;

public class UserContextHolder {
    private static AppUser user;

    public static void setUserContext(AppUser user){
        UserContextHolder.user = user;
    }

    public static AppUser getUserContext(){
        return UserContextHolder.user;
    }
;}
