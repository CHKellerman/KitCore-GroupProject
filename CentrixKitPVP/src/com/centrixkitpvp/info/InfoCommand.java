package com.centrixkitpvp.info;

import com.centrixkitpvp.inventories.info.InfoMenu;
import com.centrixkitpvp.sounds.SoundUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class InfoCommand extends BukkitCommand {

    public InfoCommand(String name){
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        new InfoMenu(player);
        player.playSound(player.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.CHEST_OPEN, SoundUtil.Sound_1_9.BLOCK_CHEST_OPEN), 10, 29);
        return true;
    }
}
