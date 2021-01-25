package com.centrixkitpvp.stats;

import com.centrixkitpvp.mysql.player.PlayerMySQLMethods;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import com.centrixkitpvp.packets.string.Titles;
import com.centrixkitpvp.sounds.SoundUtil;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatsListeners implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerMySQLMethods.getInstance().setPlayer(player.getUniqueId(), player);
    }

    @EventHandler
    public void increaseStatPoint(PlayerDeathEvent e) {
        e.setDeathMessage(null);
        if (!(e.getEntity() instanceof Player || !(e.getEntity().getKiller() instanceof Player))) {
            return;
        }
        if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
            Player killer = e.getEntity().getKiller();
            Player killed = e.getEntity();
            if (!PlayerMySQLMethods.getInstance().playerExists(killer.getUniqueId(), "PLAYERDATA") || !PlayerMySQLMethods.getInstance().playerExists(killed.getUniqueId(), "PLAYERDATA")) {
                return;
            }

            if (killer == killed) {
                return;
            }

            StatsMySQLMethods.getInstance().addKills(killer.getName());
            StatsMySQLMethods.getInstance().addDeaths(killed.getUniqueId());
            e.setDeathMessage(null);
            killed.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou were killed by &e" + killer.getName() + " &7(&6" +
                    StatsMySQLMethods.getInstance().getLevels(killer.getUniqueId().toString()) + "&7)&f!"));
            killer.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou killed &e" + killed.getName() + " &7(&6" +
                    StatsMySQLMethods.getInstance().getLevels(killed.getUniqueId().toString()) + "&7)&f!"));
            if (StatsMySQLMethods.getInstance().getKills(killer.getName()) % 10 == 0) {
                StatsMySQLMethods.getInstance().addLevels(killer.getUniqueId());
                killer.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have reached level &6" + StatsMySQLMethods.getInstance().getLevels(killer.getUniqueId().toString()
                ) + "&f!"));
                killer.playSound(killer.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.ENDERDRAGON_GROWL, SoundUtil.Sound_1_9.ENTITY_ENDERDRAGON_GROWL), 1, 1);
            }

            if (StatsMySQLMethods.getInstance().getKills(killer.getName()) % 90 == 0) {
                int level = StatsMySQLMethods.getInstance().getLevels(killer.getUniqueId().toString());
                Bukkit.broadcastMessage(MessageUtils.getPrefix() + StringUtils.format("&e" + killer.getName() + " &fhas reached level &6" +
                        level + "&f!"));
                killer.playSound(killer.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.ENDERDRAGON_GROWL, SoundUtil.Sound_1_9.ENTITY_ENDERDRAGON_GROWL), 1, 1);
                Titles.sendTitle(killer, StringUtils.format("&6Congrats!"),
                        StringUtils.format("&fYou've Reached Level &6" + level + "&f!"));
            }
        }
    }
}