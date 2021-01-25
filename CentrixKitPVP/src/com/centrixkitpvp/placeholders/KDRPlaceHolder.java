package com.centrixkitpvp.placeholders;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import com.centrixkitpvp.main.CentrixKitPVP;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import org.bukkit.entity.Player;

public class KDRPlaceHolder {

    public KDRPlaceHolder(){
        PlaceholderAPI.registerPlaceholder(CentrixKitPVP.plugin, "kitkdr",  new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                Player player = placeholderReplaceEvent.getPlayer();

                String name = player.getName();

                String uuid = player.getUniqueId().toString();
                return String.valueOf( (double) StatsMySQLMethods.getInstance().getKills(name) / (double) StatsMySQLMethods.getInstance().getDeaths(uuid));
            }
        });
    }
}
