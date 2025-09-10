package com.mitrais.rnd.FlightManagementSystem.service.impl;

import com.mitrais.rnd.FlightManagementSystem.constant.ConfigNameConstant;
import com.mitrais.rnd.FlightManagementSystem.entity.SystemConfig;
import com.mitrais.rnd.FlightManagementSystem.repository.SystemConfigRepository;
import com.mitrais.rnd.FlightManagementSystem.service.SystemService;
import com.mitrais.rnd.FlightManagementSystem.util.SystemContextHolder;
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
                    Integer day = Integer.getInteger(systemConfig.getValue());
                    systemConfig.setValue(""+(day+1));
                    repository.save(systemConfig);
                    SystemContextHolder.setSystemDayConfig(systemConfig);
                    },
                () -> repository.save(new SystemConfig(null, ConfigNameConstant.SYSTEM_DAY, "1"))
        );
    }

    @Override
    public SystemConfig getCurrentSystemDay() {

        return null;
    }
}
