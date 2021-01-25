package com.centrixkitpvp.inventories.stats;

import com.centrixkitpvp.builder.InventoryBuilder;
import com.centrixkitpvp.builder.SkullBuilder;
import com.centrixkitpvp.inventories.util.InventoryDecorateMethods;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.entity.Player;

import java.util.List;

public class TopStatsInventory {

    private Player invPlayer;

    public TopStatsInventory(Player player) {
        this.invPlayer = player;
        List<String> results = StatsMySQLMethods.getInstance().getTopKills();
        InventoryBuilder builder = new InventoryBuilder(45, "&eTop Stats");
        //1st
        builder.addItem(11, SkullBuilder.Builder.getInstance().skullName(StringUtils.format("&e" + results.get(0))).skullOwner(results.get(0)).skullLore(
                StringUtils.format("&7Kills: &e" + StatsMySQLMethods.getInstance().getKills(results.get(0)))).build());

        //2nd
        builder.addItem(12, SkullBuilder.Builder.getInstance().skullName(StringUtils.format("&e" + results.get(1))).skullOwner(results.get(1)).skullLore(
                StringUtils.format("&7Kills: &e" + StatsMySQLMethods.getInstance().getKills(results.get(1)))).build());

        //3rd
        builder.addItem(13, SkullBuilder.Builder.getInstance().skullName(StringUtils.format("&e" + results.get(2))).skullOwner(results.get(2)).skullLore(
                StringUtils.format("&7Kills: &e" + StatsMySQLMethods.getInstance().getKills(results.get(2)))).build());

        //4th
        builder.addItem(14, SkullBuilder.Builder.getInstance().skullName(StringUtils.format("&e" + results.get(3))).skullOwner(results.get(3)).skullLore(
                StringUtils.format("&7Kills: &e" + StatsMySQLMethods.getInstance().getKills(results.get(3)))).build());

        //5th
        builder.addItem(15, SkullBuilder.Builder.getInstance().skullName(StringUtils.format("&e" + results.get(4))).skullOwner(results.get(4)).skullLore(
                StringUtils.format("&7Kills: &e" + StatsMySQLMethods.getInstance().getKills(results.get(4)))).build());

        InventoryDecorateMethods.decorateTopStatsMenu(builder.getInventory());
        builder.open(invPlayer);
    }
}
