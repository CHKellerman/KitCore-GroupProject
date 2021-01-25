package com.centrixkitpvp.stats;

import java.util.HashMap;

public class KillStreak {

    private static HashMap<String, Integer> killStreak = new HashMap<>();

    public static HashMap<String, Integer> getKillStreak() {
        return killStreak;
    }
}
