package com.centrixkitpvp.teleport;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PVPMap implements Runnable {

    public PVPMap(){
        start();
    }

    private synchronized void start(){
        run();
    }

    @Override
    public void run() {
        for(Player all : Bukkit.getOnlinePlayers()){
            TeleporterUtils.teleport(all, -45.300, 17.2, -235.562, -45.999, 10.0, -223.3, 164.675, 131.0, -5406.415, 180,
                    "&fYou've been teleported to the &eKitPvP Arena&f!");
        }
    }
}
