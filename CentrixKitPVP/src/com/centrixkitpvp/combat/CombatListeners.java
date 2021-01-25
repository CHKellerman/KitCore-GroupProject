package com.centrixkitpvp.combat;

import com.centrixkitpvp.main.CentrixKitPVP;
import com.centrixkitpvp.sounds.SoundUtil;
import com.centrixkitpvp.string.MessageUtils;
import com.centrixkitpvp.string.StringUtils;
import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Arrays;
import java.util.List;

public class CombatListeners implements Listener {


    @EventHandler
    public void onDamageMeelee(EntityDamageByEntityEvent e) {
        if (!e.getEntity().hasMetadata("realplayer")) {
            return;
        }

        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            Player target = (Player) e.getEntity();
            ApplicableRegionSet ar = CentrixKitPVP.getWorldGuard().getRegionManager(damager.getWorld()).getApplicableRegions(damager.getLocation());
            LocalPlayer lp = CentrixKitPVP.getWorldGuard().wrapPlayer(damager);
            if (ar.queryState(lp, DefaultFlag.PVP) == StateFlag.State.DENY) {
                return;
            }else {
                //Detect Damager
                if (CombatUtil.getTagged().contains(damager.getName())) {
                    CombatUtil.getTagged().remove(damager.getName());
                    CombatUtil.getTagged().add(damager.getName());
                }

                if (!CombatUtil.getTagged().contains(damager.getName())) {
                    CombatUtil.getTagged().add(damager.getName());
                    damager.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have combat tagged &e" + target.getName() + "&f! You are combat tagged for &e30 seconds&f!" +
                            " &cDon't log out!"));
                }

                if (!CombatUtil.getTimer().containsKey(damager.getName())) {
                    CombatUtil.getTimer().put(damager.getName(), System.currentTimeMillis() + (30 * 1000));
                }

                if (CombatUtil.getTimer().containsKey(damager.getName())) {
                    CombatUtil.getTimer().remove(damager.getName());
                    CombatUtil.getTimer().put(damager.getName(), System.currentTimeMillis() + (30 * 1000));
                }

                //Detect Target
                if (CombatUtil.getTagged().contains(target.getName())) {
                    CombatUtil.getTagged().remove(target.getName());
                    CombatUtil.getTagged().add(target.getName());
                }

                if (!CombatUtil.getTagged().contains(target.getName())) {
                    CombatUtil.getTagged().add(target.getName());
                    target.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have been combat tagged by &e" + damager.getName() +
                            "&f! You are combat tagged for &e30 seconds&f! &cDon't log out!"));
                    target.playSound(damager.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.VILLAGER_HIT, SoundUtil.Sound_1_9.ENTITY_VILLAGER_HURT), 1, 1);
                    target.getWorld().spigot().playEffect(target.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 0, 0, 0.5f, 0.5f, 0.5f, 0f, 5, 100);
                }

                if (!CombatUtil.getTimer().containsKey(target.getName())) {
                    CombatUtil.getTimer().put(target.getName(), System.currentTimeMillis() + (30 * 1000));
                }

                if (CombatUtil.getTimer().containsKey(target.getName())) {
                    CombatUtil.getTimer().remove(target.getName());
                    CombatUtil.getTimer().put(target.getName(), System.currentTimeMillis() + (30 * 1000));
                }
            }
        }
    }

    @EventHandler
    public void onDamageProject(EntityDamageByEntityEvent e) {

        if (!e.getEntity().hasMetadata("realplayer")) {
            return;
        }

        if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
            Arrow damager = (Arrow) e.getDamager();
            Player target = (Player) e.getEntity();
            Player shooter = (Player) damager.getShooter();
            ApplicableRegionSet ar = CentrixKitPVP.getWorldGuard().getRegionManager(shooter.getWorld()).getApplicableRegions(shooter.getLocation());
            LocalPlayer lp = CentrixKitPVP.getWorldGuard().wrapPlayer(shooter);
            if (ar.queryState(lp, DefaultFlag.PVP) == StateFlag.State.DENY) {
                return;
            } else {
                //Detect Damager
                if (CombatUtil.getTagged().contains(shooter.getName())) {
                    CombatUtil.getTagged().remove(shooter.getName());
                    CombatUtil.getTagged().add(shooter.getName());
                }

                if (!CombatUtil.getTagged().contains(shooter.getName())) {
                    CombatUtil.getTagged().add(shooter.getName());
                    shooter.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have combat tagged &e" + target.getName() + "&f! You are combat tagged for &e30 seconds&f!" +
                            " &cDon't log out!"));
                }

                if (!CombatUtil.getTimer().containsKey(shooter.getName())) {
                    CombatUtil.getTimer().put(shooter.getName(), System.currentTimeMillis() + (30 * 1000));
                }

                if (CombatUtil.getTimer().containsKey(shooter.getName())) {
                    CombatUtil.getTimer().remove(shooter.getName());
                    CombatUtil.getTimer().put(shooter.getName(), System.currentTimeMillis() + (30 * 1000));
                }

                //Detect Target
                if (CombatUtil.getTagged().contains(target.getName())) {
                    CombatUtil.getTagged().remove(target.getName());
                    CombatUtil.getTagged().add(target.getName());
                }

                if (!CombatUtil.getTagged().contains(target.getName())) {
                    CombatUtil.getTagged().add(target.getName());
                    target.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou have been combat tagged by &e" + shooter.getName() +
                            "&f! You are combat tagged for &e30 seconds&f! &cDon't log out!"));
                    target.playSound(damager.getLocation(), SoundUtil.getSound(SoundUtil.Sound_1_7.VILLAGER_HIT, SoundUtil.Sound_1_9.ENTITY_VILLAGER_HURT), 1, 1);
                    target.getWorld().spigot().playEffect(target.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 0, 0, 0.5f, 0.5f, 0.5f, 0f, 5, 100);
                }

                if (!CombatUtil.getTimer().containsKey(target.getName())) {
                    CombatUtil.getTimer().put(target.getName(), System.currentTimeMillis() + (30 * 1000));
                }

                if (CombatUtil.getTimer().containsKey(target.getName())) {
                    CombatUtil.getTimer().remove(target.getName());
                    CombatUtil.getTimer().put(target.getName(), System.currentTimeMillis() + (30 * 1000));
                }
            }
        }
    }


    @EventHandler
    public void onCommands(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        if (player.isOp()) {
            return;
        }
        if (!CombatUtil.getTimer().containsKey(player.getName()) || !CombatUtil.getTagged().contains(player.getName())) {
            return;
        }
        List<String> blackListCmds = Arrays.asList("/duel", "/spawn", "/ah", "/ec", "/ah sell", "/kit", "/kits");
        String[] message = e.getMessage().split(" ");
        String command = message[0];
        if (CombatUtil.getTagged().contains(player.getName()) || CombatUtil.getTimer().containsKey(player.getName())) {
            for (String all : blackListCmds) {
                if (command.startsWith(all)) {
                    e.setCancelled(true);
                }
            }

            player.sendMessage(MessageUtils.getPrefix() + StringUtils.format("&fYou cannot do this command while in combat!"));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if (CombatUtil.getTagged().contains(player.getName()) && CombatUtil.getTimer().containsKey(player.getName())) {
            Bukkit.broadcastMessage(MessageUtils.getPrefix() + StringUtils.format("&e" + player.getName() + " &fhas logged out in combat!"));
            player.getLocation().getWorld().strikeLightningEffect(player.getLocation());
            player.setHealth(0);
            CombatUtil.getTimer().remove(player.getName());
            CombatUtil.getTagged().remove(player.getName());

        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        if (CombatUtil.getTagged().contains(player.getName()) || CombatUtil.getTimer().containsKey(player.getName())) {
            CombatUtil.getTimer().remove(player.getName());
            CombatUtil.getTagged().remove(player.getName());
            ActionBarAPI.sendActionBar(player, StringUtils.format("&aYou're No Longer In Combat"), 1);
        }
    }

    @EventHandler
    public void finalCheck(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        if (CombatUtil.getTagged().contains(player.getName()) || CombatUtil.getTimer().containsKey(player.getName())) {
            CombatUtil.getTimer().remove(player.getName());
            CombatUtil.getTagged().remove(player.getName());
            ActionBarAPI.sendActionBar(player, StringUtils.format("&aYou're No Longer In Combat"), 1);
        }
    }
}
