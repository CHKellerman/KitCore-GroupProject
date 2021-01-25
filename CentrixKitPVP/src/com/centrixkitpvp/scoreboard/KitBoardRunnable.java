package com.centrixkitpvp.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KitBoardRunnable implements Runnable {

    public KitBoardRunnable(){
        start();
    }

    private synchronized void start(){
        run();
    }

    @Override
    public void run() {
        for(Player all : Bukkit.getOnlinePlayers()){
            KitScoreBoard.update(all);
        }
    }
}
