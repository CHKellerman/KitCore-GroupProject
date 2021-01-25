package com.centrixkitpvp.sounds;

import org.bukkit.Sound;

public class SoundUtil {


    public enum Sound_1_7 {
        LEVEL_UP,
        ENDERDRAGON_GROWL,
        VILLAGER_HIT,
        CHEST_CLOSE,
        CHEST_OPEN,
        WITHER_SHOOT,
        ENDERMAN_TELEPORT;

    }

    public enum Sound_1_9 {
        ENTITY_PLAYER_LEVELUP,
        ENTITY_ENDERDRAGON_GROWL,
        ENTITY_VILLAGER_HURT,
        BLOCK_CHEST_LOCKED,
        BLOCK_CHEST_OPEN,
        ENTITY_WITHER_SHOOT,
        ENTITY_ENDERMEN_TELEPORT;
    }

    public static Sound getSound(Sound_1_7 sound1) {
        Sound sound = null;
        if (sound1 != null) {
            for (Sound sounds : Sound.values()) {
                if (sounds.name() == sound1.name()) {
                    sound = sounds;
                }
            }
        }
        return sound;
    }

    public static Sound getSound(Sound_1_9 sound1) {
        Sound sound = null;
        if (sound1 != null) {
            for (Sound sounds : Sound.values()) {
                if (sounds.name() == sound1.name()) {
                    sound = sounds;
                }
            }
        }
        return sound;
    }

    public static Sound getSound(Sound_1_7 sound1, Sound_1_9 sound2) {
        Sound sound = null;
        if (sound1 != null && sound2 != null) {
            for (Sound sounds : Sound.values()) {
                if (sounds.name() == sound1.name()) {
                    sound = sounds;
                } else if (sounds.name() == sound2.name()) {
                    sound = sounds;
                }
            }
        }
        return sound;
    }

}
