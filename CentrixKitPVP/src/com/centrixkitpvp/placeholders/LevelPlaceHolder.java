package com.centrixkitpvp.placeholders;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import com.centrixkitpvp.main.CentrixKitPVP;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import org.bukkit.entity.Player;

public class LevelPlaceHolder {

    public LevelPlaceHolder() {

        PlaceholderAPI.registerPlaceholder(CentrixKitPVP.plugin, "kitlevels", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                Player player = placeholderReplaceEvent.getPlayer();

                String uuid = player.getUniqueId().toString();

                return String.valueOf(StatsMySQLMethods.getInstance().getLevels(uuid));
            }
        });
    }
}
