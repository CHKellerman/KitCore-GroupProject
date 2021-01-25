package com.centrixkitpvp.string;

public class MessageUtils {

    private static String prefix = StringUtils.format("&c&lCentrix &8&l» ");

    private static String noPerms = StringUtils.format("&cYou don't have enough perms to use this command!");

    private static String noPlayer = StringUtils.format("&cThat player doesn't exist!");

    public static String getPrefix() {
        return prefix;
    }

    public static String getNoPerms() {
        return noPerms;
    }

    public static String getNoPlayer() {
        return noPlayer;
    }
}
