package com.centrixkitpvp.stats;

import com.centrixkitpvp.sounds.SoundUtil;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillStreakListeners implements Listener {

    @EventHandler
    public void addKillToKillStreak(PlayerDeathEvent e) {
        if (e.getEntity().getKiller() == null) {
            return;
        }
        Player player = e.getEntity().getKiller();

        if (KillStreak.getKillStreak().containsKey(player.getName())) {
            KillStreak.getKillStreak().put(player.getName(), KillStreak.getKillStreak().get(player.getName()) + 1);
        }else {
            KillStreak.getKillStreak().put(player.getName(), 1);
        }

        if (KillStreak.getKillStreak().get(player.getName()) % 10 == 0) {
            Bukkit.broadcastMessage(MessageUtils.getPrefix() + StringUtils.format("&e" + player.getName() + " &fhas a &6" + KillStreak.getKillStreak().get(player.getName()) +
                    "&f kill streak!"));
            player.playSound(player.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.ENDERDRAGON_GROWL, SoundUtil.Sound_1_9.ENTITY_ENDERDRAGON_GROWL), 1, 1);
        }
    }

    @EventHandler
    public void remove(PlayerDeathEvent e){

        Player target = e.getEntity();
        Player killer = e.getEntity().getKiller();

        if(!KillStreak.getKillStreak().containsKey(target.getName())){
            return;
        }
        if(e.getEntity().getKiller() == null && KillStreak.getKillStreak().containsKey(target.getName())){
            KillStreak.getKillStreak().remove(target.getName());
            return;
        }
        if(KillStreak.getKillStreak().get(target.getName()) >= 10){
            Bukkit.broadcastMessage(MessageUtils.getPrefix() + StringUtils.format("&e" + target.getName() + "'s &fkill streak of &6" +
                    KillStreak.getKillStreak().get(target.getName()) + " &fhas been sabotaged by &e" + killer.getName() + "&f!"));
        }

        if(KillStreak.getKillStreak().containsKey(target.getName())){
            KillStreak.getKillStreak().remove(target.getName());
        }else{
            return;
        }
    }
}