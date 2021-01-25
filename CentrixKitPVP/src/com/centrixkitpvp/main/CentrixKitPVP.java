package com.centrixkitpvp.main;

import com.centrixkitpvp.admin.AdminHelpPage;
import com.centrixkitpvp.combat.CombatListeners;
import com.centrixkitpvp.combat.CombatUtil;
import com.centrixkitpvp.economy.MoneyForKillsListeners;
import com.centrixkitpvp.functions.TPS;
import com.centrixkitpvp.info.InfoCommand;
import com.centrixkitpvp.jumppad.JumpPad;
import com.centrixkitpvp.key.KeyCommands;
import com.centrixkitpvp.key.KeyListeners;
import com.centrixkitpvp.listeners.JoinListener;
import com.centrixkitpvp.placeholders.LevelPlaceHolder;
import com.centrixkitpvp.scoreboard.KitBoardRunnable;
import com.centrixkitpvp.scoreboard.ScoreBoardListeners;
import com.centrixkitpvp.stats.*;
import com.centrixkitpvp.listeners.InventoryListeners;
import com.centrixkitpvp.mysql.MySQLMain;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import com.centrixkitpvp.teleport.PVPMap;
import com.centrixkitpvp.teleport.Pit;
import com.centrixkitpvp.teleport.Storage;
import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;

public class CentrixKitPVP extends JavaPlugin {

    public static Plugin plugin;
    public static Permission permission;
    public static Economy economy;
    public static Chat chat;
    public WorldGuardPlugin worldGuardPlugin;

    public void onEnable() {
        plugin = this;
        worldGuardPlugin = getWorldGuard();
        registerCommands();
        registerListeners();
        registerConfig();
        MySQLMain.getInstance().connect();
        setupEconomy();
        setUpPermissions();
        setUpChat();
        removeCombatTimer();
        TPS.callTPS();
        callRunnables();

        new LevelPlaceHolder();
    }


    public void onDisable() {
        plugin = null;
    }

    private void registerCommands() {
        //Admin Commands
        addCommands("statsadmin", new StatsAdmin("statsadmin"));
        addCommands("kchelp", new AdminHelpPage("kchelp"));

        //Player Commands:
        addCommands("kitinfo", new InfoCommand("kitinfo"));
        addCommands("statsview", new StatsViewCommand("statsview"));
        addCommands("stats", new StatsCommand("stats"));
        addCommands("topstats", new TopStats("topstats"));
        addCommands("keypack", new KeyCommands("keypack"));
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new CombatListeners(), this);
        pluginManager.registerEvents(new StatsListeners(), this);
        pluginManager.registerEvents(new InventoryListeners(), this);
        pluginManager.registerEvents(new MoneyForKillsListeners(), this);
        pluginManager.registerEvents(new KillStreakListeners(), this);
        pluginManager.registerEvents(new KeyListeners(), this);
        pluginManager.registerEvents(new JumpPad(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new ScoreBoardListeners(), this);
    }

    private void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


    private void addCommands(String cmd, BukkitCommand bc) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            commandMap.register(cmd, bc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean setUpPermissions() {
        RegisteredServiceProvider<Permission> permProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permProvider != null) {
            permission = permProvider.getProvider();
        }

        return (economy != null);
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    private boolean setUpChat() {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (economy != null);

    }

    public void removeCombatTimer() {
        new BukkitRunnable() {
            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (CombatUtil.getTimer().containsKey(player.getName()) && CombatUtil.getTimer().get(player.getName()) > System.currentTimeMillis()) {
                        long timeRemaining = CombatUtil.getTimer().get(player.getName()) - System.currentTimeMillis();
                        ActionBarAPI.sendActionBar(player, StringUtils.format("&7CT&8: &a" + timeRemaining / 1000));
                    }
                    if (CombatUtil.getTimer().containsKey(player.getName()) && CombatUtil.getTimer().get(player.getName()) < System.currentTimeMillis()) {
                        CombatUtil.getTimer().remove(player.getName());
                        CombatUtil.getTagged().remove(player.getName());
                        player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou are no longer in combat!"));
                    }
                }
            }
        }.runTaskTimer(this, 20, 20);
    }

    public static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {

            return null;

        }
        return (WorldGuardPlugin) plugin;
    }

    private void callRunnables() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new KitBoardRunnable(), 20, 20);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Storage(), 10, 10);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Pit(), 10, 10);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new PVPMap(), 10, 10);
    }
}
