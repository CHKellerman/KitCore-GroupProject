package com.centrixkitpvp.combat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CombatUtil {

    private static Set<String> tagged = new HashSet<>();
    private static HashMap<String, Long> timer = new HashMap<>();

    public static Set<String> getTagged() {
        return tagged;
    }

    public static HashMap<String, Long> getTimer() {
        return timer;
    }
}