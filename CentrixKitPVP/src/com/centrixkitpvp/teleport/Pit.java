package com.centrixkitpvp.teleport;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Pit implements Runnable {

    public Pit(){
        start();
    }

    private synchronized void start(){
        run();
    }

    @Override
    public void run() {
        for(Player all : Bukkit.getOnlinePlayers()){
            TeleporterUtils.teleport(all, -51.300, 13.2, -209.528, -51.999, 8.0, -204.300, 182.537, 30.0, -5476.626, 270,
                            "&fYou teleported to the &ePit&f!");
        }
    }
}
