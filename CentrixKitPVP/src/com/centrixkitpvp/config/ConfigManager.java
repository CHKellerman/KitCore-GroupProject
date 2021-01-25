package com.centrixkitpvp.config;

import com.centrixkitpvp.main.CentrixKitPVP;

public class ConfigManager {

    private static ConfigManager configManager = new ConfigManager();

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public void setPath(String path, Object val){
        CentrixKitPVP.plugin.getConfig().set(path, val);
        CentrixKitPVP.plugin.saveConfig();
    }

    public String getPath(String path){
        return CentrixKitPVP.plugin.getConfig().getString(path);
    }

    public int getInt(String path){
        return CentrixKitPVP.plugin.getConfig().getInt(path);
    }
}
