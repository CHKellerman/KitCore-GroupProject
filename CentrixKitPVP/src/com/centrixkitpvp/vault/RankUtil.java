package com.centrixkitpvp.vault;

import com.centrixkitpvp.main.CentrixKitPVP;
import org.bukkit.entity.Player;

public class RankUtil {

    public static boolean hasRank(Player player, String group) {
        return CentrixKitPVP.permission.playerInGroup(player, group);
    }

    public static String getPrefix(Player player) {
        return CentrixKitPVP.chat.getGroupPrefix(player.getWorld(), CentrixKitPVP.chat.getPrimaryGroup(player));
    }
}
