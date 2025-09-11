package com.mitrais.rnd.FlightManagementSystem.service;

import com.mitrais.rnd.FlightManagementSystem.entity.SystemConfig;

public interface SystemService {
    public void advanceSystemDay();
    public SystemConfig getCurrentSystemDay();
}
