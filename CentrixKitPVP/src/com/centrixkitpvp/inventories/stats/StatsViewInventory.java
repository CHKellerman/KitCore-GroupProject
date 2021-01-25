package com.centrixkitpvp.inventories.stats;

import com.centrixkitpvp.builder.InventoryBuilder;
import com.centrixkitpvp.builder.ItemBuilder;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class StatsViewInventory {

    private Player main;
    private Player target;
    private String kills, deaths, level;

    public StatsViewInventory(Player mainP, Player invTarget){
        this.main = mainP;
        this.target = invTarget;
        InventoryBuilder inventoryBuilder = new InventoryBuilder(27, "&e" + target.getName() + "'s &fStats");
        kills = StringUtils.format("&eKills: &f" + StatsMySQLMethods.getInstance().getKills(target.getName()));
        deaths = StringUtils.format("&eDeaths: &f" + StatsMySQLMethods.getInstance().getDeaths(target.getUniqueId().toString()));
        level = StringUtils.format("&eLevel: &f" + StatsMySQLMethods.getInstance().getLevels(target.getUniqueId().toString()));
        inventoryBuilder.addItem(13, ItemBuilder.Builder.getInstance().itemType(Material.MAP).itemAmount(1).itemName(StringUtils.format("&e" + target.getName() + "'s &fStats")
        ).itemLore(kills, deaths, level).build());
        inventoryBuilder.open(main);
    }
}
