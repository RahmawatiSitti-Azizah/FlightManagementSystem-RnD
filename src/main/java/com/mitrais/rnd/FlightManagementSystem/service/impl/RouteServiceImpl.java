package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.constant.ErrorMesssageConstant;
import com.mitrais.rnd.FlightManagementSystem.entity.Route;
import com.mitrais.rnd.FlightManagementSystem.repository.RouteRepository;
import com.mitrais.rnd.FlightManagementSystem.service.RouteService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
    private final RouteRepository repository;

    @Override
    public void addRoute(Route route) throws Exception {
        if (route.getFromDestination().equals(route.getToDestination())){
            throw new Exception(ErrorMesssageConstant.SAME_DEPARTURE_DESTINATION_ERROR);
        }
        repository.save(route);
    }
}
