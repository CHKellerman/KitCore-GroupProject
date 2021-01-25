package com.centrixkitpvp.scoreboard;

import com.centrixkitpvp.envoy.EnvoyUtil;
import com.centrixkitpvp.functions.Ping;
import com.centrixkitpvp.functions.TPS;
import com.centrixkitpvp.gangs.GangUtil;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import com.centrixkitpvp.vault.EconomyUtil;
import com.centrixkitpvp.vault.RankUtil;
import org.bukkit.entity.Player;

public class KitScoreBoard {

    public static void setScoreBoard(Player player) {
        ScoreHelper helper = ScoreHelper.createScore(player);
        int kills = StatsMySQLMethods.getInstance().getKills(player.getName());
        int deaths = StatsMySQLMethods.getInstance().getDeaths(player.getUniqueId().toString());
        int level = StatsMySQLMethods.getInstance().getLevels(player.getUniqueId().toString());
        helper.setTitle("&c&lKit-PvP");
        helper.setSlot(15, "&bProfile:");
        helper.setSlot(14, "&7Name&8: &f" + player.getName());
        helper.setSlot(13, "&7Rank: &r" + RankUtil.getPrefix(player));
        helper.setSlot(12, "&7Gang&8: &f" + GangUtil.getGangName(player));
        helper.setSlot(11, "      ");
        helper.setSlot(10, "&bStatistics");
        helper.setSlot(9, "&7K/D&8: &f" + kills + "&7/&f" + deaths);
        helper.setSlot(8, "&7Level&8: &f" + level);
        helper.setSlot(7, "&7Balance: &f" + EconomyUtil.getBal(player));
        helper.setSlot(6, "       ");
        helper.setSlot(5, "&bOther:");
        helper.setSlot(4, "&7Envoy&8: &f" + EnvoyUtil.getNextEnvoy());
        helper.setSlot(3, "&7Ping&8: &f" + Ping.getPing(player));
        helper.setSlot(2, "&7TPS&8: &f" + TPS.getTPS());
    }

    public static void update(Player player) {
        if (ScoreHelper.hasScore(player)) {
            ScoreHelper helper = ScoreHelper.getByPlayer(player);
            int kills = StatsMySQLMethods.getInstance().getKills(player.getName());
            int deaths = StatsMySQLMethods.getInstance().getDeaths(player.getUniqueId().toString());
            int level = StatsMySQLMethods.getInstance().getLevels(player.getUniqueId().toString());
            helper.setSlot(13, "&7Rank: &r" + RankUtil.getPrefix(player));
            helper.setSlot(12, "&7Gang&8: &f" + GangUtil.getGangName(player));
            helper.setSlot(9, "&7K/D&8: &f" + kills + "/" + deaths);
            helper.setSlot(8, "&7Level&8: &f" + level);
            helper.setSlot(7, "&7Balance: &f" + EconomyUtil.getBal(player));
            helper.setSlot(4, "&7Envoy&8: &f" + EnvoyUtil.getNextEnvoy());
            helper.setSlot(3, "&7Ping&8: &f" + Ping.getPing(player));
            helper.setSlot(2, "&7TPS&8: &f" + TPS.getTPS());
        }
    }
}
