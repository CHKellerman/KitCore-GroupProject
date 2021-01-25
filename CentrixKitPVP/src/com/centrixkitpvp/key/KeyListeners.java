package com.centrixkitpvp.key;

import com.centrixkitpvp.config.ConfigManager;
import com.centrixkitpvp.mysql.keys.KeyMySQLMethods;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import com.centrixkitpvp.sounds.SoundUtil;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;
import java.util.UUID;

public class KeyListeners implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        KeyMySQLMethods.getInstance().setLevelKey(uuid, 0);
        KeyMySQLMethods.getInstance().setKillKey(uuid, 0);
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        if (e.getEntity().getKiller() == null) {
            return;
        }

        Player killer = e.getEntity().getKiller();
        Player target = e.getEntity();
        if(killer == target){
            return;
        }

        Random random = new Random();
        int choose = random.nextInt(100);
        if(choose <= ConfigManager.getConfigManager().getInt("KillKeyDropChance")){
            killer.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have found a kill key! Use &e/keypack info &fto see how many keys you have!"));
            killer.playSound(killer.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.LEVEL_UP, SoundUtil.Sound_1_9.ENTITY_PLAYER_LEVELUP), 1, 1);
            KeyMySQLMethods.getInstance().giveKillKey(killer.getUniqueId(), 1);
        }

        int kills = StatsMySQLMethods.getInstance().getKills(killer.getName());
        if(kills % ConfigManager.getConfigManager().getInt("LevelKeyKillAmount") == 0){
            killer.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have found a level key! Use &e/keypack info &fto see how many keys you have!"));
            KeyMySQLMethods.getInstance().giveLevelKey(killer.getUniqueId(), 1);
        }
    }
}
