package com.centrixkitpvp.jumppad;

import com.centrixkitpvp.sounds.SoundUtil;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumpPad implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void detect(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if(e.getTo().distanceSquared(e.getFrom()) == 0){
            return;
        }

        if(player.getLocation().getBlock().getType() != Material.STONE_PLATE && player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.EMERALD_BLOCK){
            return;
        }

        if (player.getLocation().getBlock().getType() == Material.STONE_PLATE) {
            if (player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.EMERALD_BLOCK) {
                player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1.5));
                player.playSound(player.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.WITHER_SHOOT, SoundUtil.Sound_1_9.ENTITY_WITHER_SHOOT), 1, 1);
                player.getWorld().spigot().playEffect(player.getLocation(), Effect.FLAME, 0, 0, 0.5F, 0.5F, 0.5F, 0F, 5, 100);
            }
        }
    }
}
