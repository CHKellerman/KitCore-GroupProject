package com.centrixkitpvp.functions;

import net.brcdev.gangs.util.NmsUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;

public class TPS {

    private static final DecimalFormat format = new DecimalFormat("##.##");
    private static Object serverInstance;
    private static Field tpsField;


    public static void callTPS(){
        try {
            serverInstance = NmsUtils.getNmsClass("MinecraftServer").getMethod("getServer").invoke(null);
            tpsField = serverInstance.getClass().getField("recentTps");
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static String getTPS() {
        try {
            double[] tps = ((double[]) tpsField.get(serverInstance));
            return format.format(tps[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
