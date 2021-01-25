package com.centrixkitpvp.packets.string;

import com.centrixkitpvp.packets.PacketUtil;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

import static be.maximvdw.placeholderapi.internal.utils.ReflectionUtil.getNMSClass;

public class Titles {

    public static void sendTitle(Player player, String titleText, String subtitleText){
        try {

            Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
            Object titleChat = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + titleText + "\"}");

            Object enumSubtitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
            Object subtitleChat = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + subtitleText + "\"}");

            Constructor<?> titleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
            Object titlePacket = titleConstructor.newInstance(enumTitle, titleChat, 30, 50, 30);
            Object subtitlePacket = titleConstructor.newInstance(enumSubtitle, subtitleChat, 30, 40, 30);

            PacketUtil.getInstance().sendPacket(player, titlePacket);
            PacketUtil.getInstance().sendPacket(player, subtitlePacket);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
