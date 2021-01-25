package com.centrixkitpvp.placeholders;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import com.centrixkitpvp.main.CentrixKitPVP;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import org.bukkit.entity.Player;

public class KillsPlaceHolder {

    public KillsPlaceHolder(){
        PlaceholderAPI.registerPlaceholder(CentrixKitPVP.plugin, "kitkills",  new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                Player player = placeholderReplaceEvent.getPlayer();

                String name = player.getName();

                return String.valueOf(StatsMySQLMethods.getInstance().getKills(name));
            }
        });
    }
}
