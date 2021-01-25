package com.centrixkitpvp.admin;

import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class AdminHelpPage extends BukkitCommand {

    public AdminHelpPage(String name){
        super(name);
        this.usageMessage = MessageUtils.getPrefix() + StringUtils.format("&e/akchelp");
        this.setPermissionMessage("centrixkitpvp.adminhelp");
    }

    @Override
    public boolean execute(CommandSender s, String label, String[] args) {
        if(!(s instanceof Player)){
            System.out.println("Only players can use this command!");
            return true;
        }

        Player player = (Player) s;
        if(!player.hasPermission(getPermission())){
            player.sendMessage(MessageUtils.getPrefix() + MessageUtils.getNoPerms());
            return true;
        }

        player.sendMessage(MessageUtils.getPrefix() + "&e/kchelp &fallows you to see all the kit core commands!");
        player.sendMessage(MessageUtils.getPrefix() + "&e/statsadmin reset <player> &fallows you to reset a player's data!");
        player.sendMessage(MessageUtils.getPrefix() + "&e/statsadmin set <player> <kills/deaths/level> <number> &fallows you to set a player's certain data type amount!");
        return true;
    }
}
