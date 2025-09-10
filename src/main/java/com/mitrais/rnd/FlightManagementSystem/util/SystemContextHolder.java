package com.mitrais.rnd.FlightManagementSystem.util;

import com.mitrais.rnd.FlightManagementSystem.entity.SystemConfig;

public class SystemContextHolder {
    private static SystemConfig systemDayConfig;

    public static void setSystemDayConfig(SystemConfig systemDayConfig){
        SystemContextHolder.systemDayConfig = systemDayConfig;
    }

    public static SystemConfig getSystemDayConfig(){
        if(systemDayConfig == null){
            systemDayConfig = new SystemConfig();
            systemDayConfig.setName("system_day");
            systemDayConfig.setValue("1");
        }
        return systemDayConfig;
    }
}
