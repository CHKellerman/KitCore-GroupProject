package com.centrixkitpvp.builder;

import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public  class InventoryBuilder {

    private int slots;
    private String name;
    private Inventory inventory;

    public InventoryBuilder(int slotAmount, String inventoryName){
        this.slots = slotAmount;
        this.name = inventoryName;
        inventory = Bukkit.createInventory(null, slots, StringUtils.format(name));
    }

    public void addItem(int slot, ItemStack item){
        inventory.setItem(slot, item);
    }

    public void open(Player player){
        player.openInventory(inventory);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
