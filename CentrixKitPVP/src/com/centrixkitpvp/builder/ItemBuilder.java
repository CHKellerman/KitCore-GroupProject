package com.centrixkitpvp.builder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    public static class Builder {

        private Material material;
        private int amount;
        private byte id;
        private String name;
        private List<String> lore;

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder itemType(Material material) {
            this.material = material;
            return this;
        }

        public Builder itemAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder itemID(byte id){
            this.id = id;
            return this;
        }

        public Builder itemName(String name) {
            this.name = name;
            return this;
        }

        public Builder itemLore(String... lores) {
            this.lore = Arrays.asList(lores);
            return this;
        }

        public ItemStack build() {
            ItemStack item = new ItemStack(material, amount);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(format(name));
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }


        public ItemStack buildWithID() {
            ItemStack item = new ItemStack(material, amount, id);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(format(name));
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }



    private ItemBuilder() {

    }

    public static boolean hasDisplayName(ItemStack currentitem) {
        if (currentitem == null) {
            return false;
        }
        if (!currentitem.hasItemMeta()) {
            return false;
        }
        if (!currentitem.getItemMeta().hasDisplayName()) {
            return false;
        }
        return true;
    }

    public static String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
