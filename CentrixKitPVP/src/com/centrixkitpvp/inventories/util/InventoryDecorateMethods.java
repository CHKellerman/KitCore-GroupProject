package com.centrixkitpvp.inventories.util;

import com.centrixkitpvp.builder.ItemBuilder;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class InventoryDecorateMethods {

    public static void decorateInfoMenu(Inventory inventory) {
        for (int i1 = 0; i1 < 9; i1++) {
            inventory.setItem(i1, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        }

        inventory.setItem(9, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        inventory.setItem(17, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());

        for (int i2 = 18; i2 <= 26; i2++) {
            inventory.setItem(i2, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        }
    }

    public static void decorateTopStatsMenu(Inventory inventory) {
        for (int i1 = 0; i1 < 9; i1++) {
            inventory.setItem(i1, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        }

        inventory.setItem(9, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        inventory.setItem(10, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        inventory.setItem(16, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        inventory.setItem(17, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());

        for (int i2 = 18; i2 <= 26; i2++) {
            inventory.setItem(i2, ItemBuilder.Builder.getInstance().itemType(Material.STAINED_GLASS_PANE).itemAmount(1).itemID((byte) 8).itemName(StringUtils.format("&7*")).buildWithID());
        }
    }


}
