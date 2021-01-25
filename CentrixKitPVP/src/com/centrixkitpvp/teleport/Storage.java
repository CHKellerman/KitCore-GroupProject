package com.centrixkitpvp.teleport;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Storage implements Runnable {

    public Storage() {
        start();
    }

    private synchronized void start() {
        run();
    }

    @Override
    public void run() {
        for (Player all : Bukkit.getOnlinePlayers()) {
            TeleporterUtils.teleport(all, -51.300, 15.2, -253.700, -51.999, 11.0, -249.300, 5370.227, 5, -1285.494, 180,
                    "&fYou teleported to the &eStorage&f!");
        }
    }
}
