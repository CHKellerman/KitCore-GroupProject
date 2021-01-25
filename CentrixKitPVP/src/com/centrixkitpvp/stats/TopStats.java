package com.centrixkitpvp.stats;

import com.centrixkitpvp.inventories.stats.TopStatsInventory;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.List;

public class TopStats extends BukkitCommand {

    public TopStats(String name){
        super(name);

    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        new TopStatsInventory(player);
        return true;
    }
}
