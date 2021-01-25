package com.centrixkitpvp.inventories.stats;

import com.centrixkitpvp.builder.InventoryBuilder;
import com.centrixkitpvp.builder.ItemBuilder;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class StatsInventory {

    private Player player;
    private String kills, deaths, level;

    public StatsInventory(Player invPlayer) {
        this.player = invPlayer;
        InventoryBuilder inventoryBuilder = new InventoryBuilder(27, "&e" + player.getName() + "'s &fStats");
        kills = StringUtils.format("&eKills: &f" + StatsMySQLMethods.getInstance().getKills(player.getName()));
        deaths = StringUtils.format("&eDeaths: &f" + StatsMySQLMethods.getInstance().getDeaths(player.getUniqueId().toString()));
        level = StringUtils.format("&eLevel: &f" + StatsMySQLMethods.getInstance().getLevels(player.getUniqueId().toString()));
        inventoryBuilder.addItem(13, ItemBuilder.Builder.getInstance().itemType(Material.MAP).itemAmount(1).itemName(StringUtils.format("&e" + player.getName() + "'s &fStats")
        ).itemLore(kills, deaths, level).build());
        inventoryBuilder.open(player);
    }
}
