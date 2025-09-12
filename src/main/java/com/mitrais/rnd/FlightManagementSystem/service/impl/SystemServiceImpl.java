package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.constant.ConfigNameConstant;
import com.mitrais.rnd.FlightManagementSystem.entity.SystemConfig;
import com.mitrais.rnd.FlightManagementSystem.repository.SystemConfigRepository;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemServiceImpl implements SystemService {
    private final SystemConfigRepository repository;

    @Override
    public void advanceSystemDay() {
        repository.findByName(ConfigNameConstant.SYSTEM_DAY).ifPresentOrElse(
                systemConfig -> {
                    Integer day = Integer.parseInt(systemConfig.getConfigValue())+1;
                    systemConfig.setConfigValue(String.valueOf(day));
                    repository.save(systemConfig);
                    },
                () -> {
                    SystemConfig systemDayConfig = new SystemConfig(null, ConfigNameConstant.SYSTEM_DAY, "1");
                    Integer day = Integer.getInteger(systemDayConfig.getConfigValue())+1;
                    systemDayConfig.setConfigValue(String.valueOf(day));
                    repository.save(systemDayConfig);
                }
        );
    }

    @Override
    public SystemConfig getCurrentSystemDay() {
        SystemConfig result = repository.findByName(ConfigNameConstant.SYSTEM_DAY).orElse(null);
        if(result == null){
            result = new SystemConfig(null, ConfigNameConstant.SYSTEM_DAY, "1");
            result = repository.save(result);
        }
        return result;
    }

    @Override
    public void setBookingServiceStatus(Boolean status) {
        repository.findByName(ConfigNameConstant.BOOKING_SERVICE).ifPresentOrElse(
                systemConfig -> {
                    systemConfig.setConfigValue(String.valueOf(status));
                    repository.save(systemConfig);
                },
                () -> {
                    SystemConfig bookingServiceConfig = new SystemConfig(null, ConfigNameConstant.BOOKING_SERVICE, String.valueOf(status));
                    repository.save(bookingServiceConfig);
                }
        );
    }
}
