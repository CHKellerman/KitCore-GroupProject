package com.centrixkitpvp.envoy;

import me.badbones69.crazyenvoy.api.CrazyEnvoy;

public class EnvoyUtil {

    public static String getNextEnvoy() {
        if (!CrazyEnvoy.getInstance().isEnvoyActive()) {
            return CrazyEnvoy.getInstance().getNextEnvoyTime();
        } else {

            return "ON GOING!";
        }
    }
}
