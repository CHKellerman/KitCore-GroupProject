package com.centrixkitpvp.teleport;

import com.centrixkitpvp.sounds.SoundUtil;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class TeleporterUtils {

    public static boolean inRegion(Player p, Location loc1, Location loc2) {
        double x1 = loc1.getX();
        double y1 = loc1.getY();
        double z1 = loc1.getZ();

        double x2 = loc2.getX();
        double y2 = loc2.getY();
        double z2 = loc2.getZ();

        /*p.sendMessage("X1:" + String.valueOf(p.getLocation().getX() > x1));
        p.sendMessage("X2:" + String.valueOf(p.getLocation().getX() < x2));
        p.sendMessage("Y1:" + String.valueOf(p.getLocation().getY()> y1));
        p.sendMessage("Y2:" + String.valueOf(p.getLocation().getY() < y2));
        p.sendMessage("Z1:" + String.valueOf(p.getLocation().getZ() > z1));
        p.sendMessage("Z2:" + String.valueOf(p.getLocation().getZ() < z2));
        p.sendMessage("----");
        */
        return (p.getLocation().getX() < x1 && p.getLocation().getY() < y1 && p.getLocation().getZ() > z1 && p.getLocation().getX() > x2 && p.getLocation().getY() >= y2 && p.getLocation().getZ() < z2);
    }

    public static void teleport(Player player, double x1, double y1, double z1, double x2, double y2, double z2,
                          double desx, double desy, double desz, float desYaw, String message) {
        World world = player.getWorld();
        String name = world.getName();
        if (name.equalsIgnoreCase("flat")) {
            if (TeleporterUtils.inRegion(player, new Location(world, x1, y1, z1), new Location(world, x2, y2, z2))) {
                player.teleport(new Location(world, desx, desy, desz, desYaw, 0));
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format(message));
                player.playSound(player.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.ENDERMAN_TELEPORT, SoundUtil.Sound_1_9.ENTITY_ENDERMEN_TELEPORT), 1, 1);
            } else {
                return;
            }
        }
    }
}