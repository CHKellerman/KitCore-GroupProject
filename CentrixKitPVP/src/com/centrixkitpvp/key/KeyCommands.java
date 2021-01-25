package com.centrixkitpvp.key;
import com.centrixkitpvp.mysql.keys.KeyMySQLMethods;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class KeyCommands extends BukkitCommand {

    public KeyCommands(String name) {
        super(name);
        this.usageMessage = MessageUtils.getPrefix() + StringUtils.format("&e/keypack info\n" +
                MessageUtils.getPrefix() + StringUtils.format("&e/keypack collect"));
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(getUsage());
            return true;
        }

        if (args[0].equalsIgnoreCase("info")) {
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fLevel Keys: &e" + KeyMySQLMethods.getInstance().getLevelKey(player.getUniqueId().toString())));
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fKill Keys: &e" + KeyMySQLMethods.getInstance().getKillKey(player.getUniqueId().toString())));
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fUse &e/keypack collect &fto collect all your keys!"));
            return true;
        }

        if (args[0].equalsIgnoreCase("collect")) {
            if(KeyMySQLMethods.getInstance().getKillKey(player.getUniqueId().toString()) == 0 && KeyMySQLMethods.getInstance().getLevelKey(player.getUniqueId().toString()) == 0){
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have no keys to collect!"));
                return true;
            }

            if(player.getInventory().firstEmpty() == -1){
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYour inventory is full!"));
                return true;
            }



            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crazycrates give physical level " + KeyMySQLMethods.getInstance().getLevelKey(player.getUniqueId().toString()) + " " +
                    player.getName());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crazycrates give physical kill " + KeyMySQLMethods.getInstance().getKillKey(player.getUniqueId().toString()) + " " +
                    player.getName());
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully collected all your keys!"));
            KeyMySQLMethods.getInstance().setLevelKey(player.getUniqueId(), 0);
            KeyMySQLMethods.getInstance().setKillKey(player.getUniqueId(), 0);
            return true;
        }

        return true;
    }
}
