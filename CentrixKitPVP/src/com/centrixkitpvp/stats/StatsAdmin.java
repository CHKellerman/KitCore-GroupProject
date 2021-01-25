package com.centrixkitpvp.stats;

import com.centrixkitpvp.mysql.player.PlayerMySQLMethods;
import com.centrixkitpvp.mysql.stats.StatsMySQLMethods;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import io.netty.util.internal.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class StatsAdmin extends BukkitCommand {

    public StatsAdmin(String name) {
        super(name);
        this.setPermission("centrixkitpvp.statsadmin");
        this.usageMessage = MessageUtils.getPrefix() + StringUtils.format("&e/statsadmin <reset> <player>. \n" +
                MessageUtils.getPrefix() + "&e/statsadmin <set> <player> <level/kills/deaths> <amount>");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission(getPermission())) {
            player.sendMessage(MessageUtils.getPrefix() + MessageUtils.getNoPerms());
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(this.getUsage());
            return true;
        }

        if (args[0].equalsIgnoreCase("reset")) {
            OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
            if (!target.hasPlayedBefore()) {
                player.sendMessage(MessageUtils.getPrefix() + MessageUtils.getNoPlayer());
                return true;
            }

            if (!PlayerMySQLMethods.getInstance().playerExists(target.getUniqueId(), "PLAYERDATA")) {
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fThat player isn't on the database!"));
                return true;
            }

            if (!target.isOnline()) {
                StatsMySQLMethods.getInstance().setKills(target.getName(), 0);
                StatsMySQLMethods.getInstance().setDeaths(target.getUniqueId(), 0);
                StatsMySQLMethods.getInstance().setLevels(target.getUniqueId(), 1);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully reset &e" + target.getName() + "'s &fdata!"));
                return true;
            }

            StatsMySQLMethods.getInstance().setKills(target.getName(), 0);
            StatsMySQLMethods.getInstance().setDeaths(target.getUniqueId(), 0);
            StatsMySQLMethods.getInstance().setLevels(target.getUniqueId(), 1);
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully reset &e" + target.getName() + "'s &fdata!"));
            return true;
        }


        if (args[0].equalsIgnoreCase("set")) {
            OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
            if (!target.hasPlayedBefore()) {
                player.sendMessage(MessageUtils.getPrefix() + MessageUtils.getNoPlayer());
                return true;
            }

            if (!PlayerMySQLMethods.getInstance().playerExists(target.getUniqueId(), "PLAYERDATA")) {
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fThat player isn't on the database!"));
                return true;
            }

            //Levels
            if (!target.isOnline()) {
                if (args[2].equalsIgnoreCase("level")) {
                    int amount;

                    try {
                        amount = Integer.parseInt(args[3]);
                    } catch (Exception e) {
                        player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("Error Syntax!"));
                        return true;
                    }


                    StatsMySQLMethods.getInstance().setLevels(target.getUniqueId(), amount);
                    player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully set &e" + target.getName() + "'s &flevel to level &6" + amount + "&f!"));
                    return true;
                }
            }

            if (args[2].equalsIgnoreCase("level")) {
                int amount;

                try {
                    amount = Integer.parseInt(args[3]);
                } catch (Exception e) {
                    player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("Error Syntax!"));
                    return true;
                }


                StatsMySQLMethods.getInstance().setLevels(target.getUniqueId(), amount);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully set &e" + target.getName() + "'s &flevel to level &6" + amount + "&f!"));
                return true;
            }


        //Kills
        if (!target.isOnline()) {
            if (args[2].equalsIgnoreCase("kills")) {
                int amount;

                try {
                    amount = Integer.parseInt(args[3]);
                } catch (Exception e) {
                    player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("Error Syntax!"));
                    return true;
                }


                StatsMySQLMethods.getInstance().setKills(target.getName(), amount);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully set &e" + target.getName() + "'s &fkills to &6" + amount + "&f!"));
                return true;
            }
        }

        if (args[2].equalsIgnoreCase("kills")) {
            int amount;

            try {
                amount = Integer.parseInt(args[3]);
            } catch (Exception e) {
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("Error Syntax!"));
                return true;
            }


            StatsMySQLMethods.getInstance().setKills(target.getName(), amount);
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully set &e" + target.getName() + "'s &fkills to &6" + amount + "&f!"));
            return true;
        }


    //Deaths
        if (!target.isOnline()) {
            if (args[2].equalsIgnoreCase("deaths")) {
                int amount;

                try {
                    amount = Integer.parseInt(args[3]);
                } catch (Exception e) {
                    player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("Error Syntax!"));
                    return true;
                }


                StatsMySQLMethods.getInstance().setDeaths(target.getUniqueId(), amount);
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully set &e" + target.getName() + "'s &fdeaths to &6" + amount + "&f!"));
                return true;
            }
        }

        if (args[2].equalsIgnoreCase("deaths")) {
            int amount;

            try {
                amount = Integer.parseInt(args[3]);
            } catch (Exception e) {
                player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("Error Syntax!"));
                return true;
            }


            StatsMySQLMethods.getInstance().setDeaths(target.getUniqueId(), amount);
            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have successfully set &e" + target.getName() + "'s &fdeaths to &6" + amount + "&f!"));
            return true;
        }

    }

        return true;
    }
}