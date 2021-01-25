package com.centrixkitpvp.vault;

import com.centrixkitpvp.main.CentrixKitPVP;
import org.bukkit.entity.Player;

public class EconomyUtil {


    public static void giveMoney(Player player, double amount){
        CentrixKitPVP.economy.depositPlayer(player, amount);
    }

    public static boolean hasAccount(Player player){
        return CentrixKitPVP.economy.hasAccount(player);
    }

    public static String getBal(Player player){
        return CentrixKitPVP.economy.format(CentrixKitPVP.economy.getBalance(player));
    }
}
