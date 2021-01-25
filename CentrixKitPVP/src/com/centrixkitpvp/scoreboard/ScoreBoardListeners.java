package com.centrixkitpvp.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ScoreBoardListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        KitScoreBoard.setScoreBoard(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        if(ScoreHelper.hasScore(player)){
            ScoreHelper.removeScore(player);
        }
    }
}
