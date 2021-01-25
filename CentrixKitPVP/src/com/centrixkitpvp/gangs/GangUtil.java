package com.centrixkitpvp.gangs;

import net.brcdev.gangs.GangsPlusApi;
import org.bukkit.entity.Player;

public class GangUtil {

    public static String getGangName(Player player) {
        if (!GangsPlusApi.isInGang(player)) {
            return "NONE";
        } else {

            return GangsPlusApi.getPlayersGang(player).getName();
        }
    }
}
