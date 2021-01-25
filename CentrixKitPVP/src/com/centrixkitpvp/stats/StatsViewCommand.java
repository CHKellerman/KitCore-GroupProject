package com.centrixkitpvp.stats;

import com.centrixkitpvp.inventories.stats.StatsViewInventory;
import com.centrixkitpvp.sounds.SoundUtil;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class StatsViewCommand extends BukkitCommand {

    public StatsViewCommand(String name) {
        super(name);
        this.usageMessage = MessageUtils.getPrefix() + StringUtils.format("&e/statsview <target>");
    }

    @Override
    public boolean execute(CommandSender s, String label, String[] args) {
        if (!(s instanceof Player)) {
            System.out.println("Only players can use this command!");
            return true;
        }

        Player player = (Player) s;

        if (args.length == 0) {
            player.sendMessage(getUsage());
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (player == target) {
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou can't &e/statsview &fyourself! Use &e/stats &fto view yourself!"));
            return true;
        }
        if (target == null) {
            player.sendMessage(MessageUtils.getPrefix() + MessageUtils.getNoPlayer());
            return true;
        }

        new StatsViewInventory(player, target);
        player.playSound(player.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.CHEST_OPEN, SoundUtil.Sound_1_9.BLOCK_CHEST_OPEN), 10, 29);
        return true;
    }
}
