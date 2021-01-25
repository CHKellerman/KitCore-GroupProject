package com.centrixkitpvp.economy;

import com.centrixkitpvp.vault.EconomyUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class MoneyForKillsListeners implements Listener {

    @EventHandler
    public void onKillForMoney(PlayerDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        Player target = e.getEntity();
        if (killer == null) {
            return;
        }

        if(!EconomyUtil.hasAccount(killer)){
            return;
        }

        if(killer == target){
            return;
        }

        MoneyForKills.giveMoneyBasedOffRank(killer);
    }
}