package com.centrixkitpvp.listeners;

import com.centrixkitpvp.main.CentrixKitPVP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        e.setJoinMessage(null);
        player.teleport(new Location(Bukkit.getWorld("flat"), -101.402, 9.0, -227.596, 270, 0));
        if(!player.hasMetadata("realplayer")){
            player.setMetadata("realplayer", new FixedMetadataValue(CentrixKitPVP.plugin, true));
        }else{
            return;
        }
    }
}
