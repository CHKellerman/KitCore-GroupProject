package com.centrixkitpvp.economy;

import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import com.centrixkitpvp.vault.EconomyUtil;
import com.centrixkitpvp.vault.RankUtil;
import org.bukkit.entity.Player;

import java.util.Random;

public class MoneyForKills {

    public static void giveMoneyBasedOffRank(Player player) {
        Random r = new Random();
        int value = r.nextInt(100);
        //Default
        if (RankUtil.hasRank(player, "default")) {
            if (value >= 0 && value <= 8) {
                EconomyUtil.giveMoney(player, 3);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.00&f!"));
            }

            if (value >= 9 && value <= 27) {
                EconomyUtil.giveMoney(player, 2.70);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$2.70&f!"));
                return;
            }

            if (value >= 28 && value <= 58) {
                EconomyUtil.giveMoney(player, 2.25);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$2.25&f!")) ;
                return;
            }

            if (value >= 59 && value <= 100) {
                EconomyUtil.giveMoney(player, 2.00);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$2.00&f!"));
                return;
            }
        }

        //Phantom
        if(RankUtil.hasRank(player,"phantom")){

            if(value >= 0 && value <= 33){
                EconomyUtil.giveMoney(player, 3);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3&f!"));
            }


            if(value >= 34 && value <= 66){
                EconomyUtil.giveMoney(player, 3.06);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.06&f!"));
            }


            if(value >= 67 && value <= 100){
                EconomyUtil.giveMoney(player, 3.13);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.13&f!"));
            }
        }

        //Vanguard
        if(RankUtil.hasRank(player,"vanguard")){

            if(value >= 0 && value <= 45){
                EconomyUtil.giveMoney(player, 3.13);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.13&f!"));
            }


            if(value >= 46 && value <= 70){
                EconomyUtil.giveMoney(player, 3.21);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.21&f!"));
            }


            if(value >= 67 && value <= 100){
                EconomyUtil.giveMoney(player, 3.30);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.30&f"));
            }
        }

        //Titan

        if(RankUtil.hasRank(player, "titan")){
            if(value >= 0 && value <= 50){
                EconomyUtil.giveMoney(player, 3.30);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.30&f!"));
            }


            if(value >= 51 && value <= 75){
                EconomyUtil.giveMoney(player, 3.39);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.39&f!"));
            }


            if(value >= 76 && value <= 100){
                EconomyUtil.giveMoney(player, 3.49);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.49&f"));
            }
        }

        //Gladiator

        if(RankUtil.hasRank(player, "gladiator")){
            if(value >= 0 && value <= 60){
                EconomyUtil.giveMoney(player, 3.49);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.49&f!"));
            }


            if(value >= 61 && value <= 85){
                EconomyUtil.giveMoney(player, 3.58);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.58&f!"));
            }


            if(value >= 86 && value <= 100){
                EconomyUtil.giveMoney(player, 3.70);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.70&f"));
            }
        }

        //Hero

        if(RankUtil.hasRank(player, "hero")){
            if(value >= 0 && value <= 65){
                EconomyUtil.giveMoney(player, 3.70);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.70&f!"));
            }


            if(value >= 66 && value <= 89){
                EconomyUtil.giveMoney(player, 3.85);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format( "&fYou have earned &6$3.85&f!"));
            }


            if(value >= 90 && value <= 100){
                EconomyUtil.giveMoney(player, 3.95);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format( "&fYou have earned &6$3.95&f"));
            }
        }

        //Demonic
        if(RankUtil.hasRank(player, "demonic")){
            if(value >= 0 && value <= 70){
                EconomyUtil.giveMoney(player, 3.90);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.70&f!"));
            }


            if(value >= 71 && value <= 89){
                EconomyUtil.giveMoney(player, 4.15);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format( "&fYou have earned &6$4.15&f!"));
            }


            if(value >= 90 && value <= 100){
                EconomyUtil.giveMoney(player, 4.30);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format( "&fYou have earned &6$4.30&f"));
            }
        }

        //Legendary
        if(RankUtil.hasRank(player, "legendary")){
            if(value >= 0 && value <= 75){
                EconomyUtil.giveMoney(player, 4.30);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have earned &6$3.70&f!"));
            }


            if(value >= 76 && value <= 90){
                EconomyUtil.giveMoney(player, 4.15);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format( "&fYou have earned &6$4.65&f!"));
            }


            if(value >= 91 && value <= 100){
                EconomyUtil.giveMoney(player, 5.00);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format( "&fYou have earned &6$5.00&f"));
            }
        }

    }
}