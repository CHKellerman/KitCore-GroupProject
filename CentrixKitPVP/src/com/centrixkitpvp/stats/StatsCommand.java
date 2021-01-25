package com.centrixkitpvp.stats;

import com.centrixkitpvp.inventories.stats.StatsInventory;
import com.centrixkitpvp.sounds.SoundUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class StatsCommand extends BukkitCommand {


    public StatsCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender s, String label, String[] args) {
        if (!(s instanceof Player)) {
            System.out.println("Only players can use this command!");
            return true;
        }

        Player player = (Player) s;

        new StatsInventory(player);
        player.playSound(player.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.CHEST_OPEN, SoundUtil.Sound_1_9.BLOCK_CHEST_OPEN), 10, 29);
        return true;
    }
}
