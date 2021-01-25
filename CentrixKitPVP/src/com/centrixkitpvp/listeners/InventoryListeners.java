package com.centrixkitpvp.listeners;

import com.centrixkitpvp.string.StringUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryListeners implements Listener {

    @EventHandler
    public void cancelClickForStats(InventoryClickEvent e) {
        checkNameAndClick(e.getInventory(), "&fStats", e);
        checkNameAndClick(e.getInventory(), "&eTop Stats", e);
    }

    @EventHandler
    public void cancelClickForInfo(InventoryClickEvent e) {
        checkNameAndClick(e.getInventory(), "&eKitPvP Info Menu", e);
    }


    private void checkNameAndClick(Inventory inventory, String name, InventoryClickEvent e) {
        if (inventory.getName().contains(StringUtils.format(name))) {
            if (e.getClick() == ClickType.RIGHT || e.getClick() == ClickType.LEFT || e.getClick() == ClickType.DOUBLE_CLICK || e.getClick() == ClickType.SHIFT_LEFT
                    || e.getClick() == ClickType.SHIFT_LEFT) {
                e.setCancelled(true);
                e.getWhoClicked().closeInventory();
            }
        }
    }
}
