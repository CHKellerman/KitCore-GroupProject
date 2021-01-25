package com.centrixkitpvp.functions;

import org.bukkit.entity.Player;

public class Ping {

    private static int ping;

    public static int getPing(Player player) {
        try {
            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            ping = (int) entityPlayer.getClass().getField("ping").get(entityPlayer);
        } catch (Exception e) {
            e.printStackTrace();


        }

        return ping;
    }
}
