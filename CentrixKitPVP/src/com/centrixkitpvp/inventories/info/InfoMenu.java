package com.centrixkitpvp.inventories.info;

import com.centrixkitpvp.builder.InventoryBuilder;
import com.centrixkitpvp.builder.ItemBuilder;
import com.centrixkitpvp.inventories.util.InventoryDecorateMethods;
import com.centrixkitpvp.string.StringUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class InfoMenu {

    private Player player;

    public InfoMenu(Player invPlayer) {
        this.player = invPlayer;
        InventoryBuilder builder = new InventoryBuilder(27, "&eKitPvP Info Menu");

        builder.addItem(10, ItemBuilder.Builder.getInstance().itemType(Material.MAP).itemName(StringUtils.format("&eStats")).itemAmount(1)
                .itemLore(StringUtils.format("&f&lWhat Is It?"),
                        StringUtils.format("&7Stats allows you to"),
                        StringUtils.format("&7view your kills, deaths,"),
                        StringUtils.format("&7and levels!"),
                        "      ",
                        StringUtils.format("&f&lHow To Level Up?"),
                        StringUtils.format("&7Gain levels through killing!"),
                        StringUtils.format("&7Every 10 Kills is 1 Level!"),
                        "      ",
                        StringUtils.format("&f&lCommands"),
                        StringUtils.format("&7&l● &e/stats"),
                        StringUtils.format("&7&l● &e/statsview <player>"),
                        StringUtils.format("&7&l● &e/topstats")).build());

        builder.addItem(11, ItemBuilder.Builder.getInstance().itemType(Material.PAPER).itemName(StringUtils.format("&eEconomy")).itemAmount(1)
                .itemLore(StringUtils.format("&f&lHow To Get Money?"),
                        StringUtils.format("&7Get money from"),
                        StringUtils.format("&7crates, killing players,"),
                        StringUtils.format("&7voting, envoys,"),
                        StringUtils.format("&7and competing!"),
                        "      ",
                        StringUtils.format("&f&lMoney For Kills Info!"),
                        StringUtils.format("&7Each rank gets"),
                        StringUtils.format("&7a higher amount"),
                        StringUtils.format("&7of money!"),
                        "     ",
                        StringUtils.format("&f&lMoney Based Off Ranks!"),
                        StringUtils.format("&7&l● &7Member&7: &a$2.00-$3.00"),
                        StringUtils.format("&7&l● &b&lPhantom&7: &a$3.00-$3.13"),
                        StringUtils.format("&7&l● &6&lVanguard&7: &a$3.13-$3.30"),
                        StringUtils.format("&7&l● &a&lTitan&7: &a$3.30-$3.49"),
                        StringUtils.format("&7&l● &9&lGladiator&7: &a$3.49-$3.70"),
                        StringUtils.format("&7&l● &d&lHero&7: &a$3.70-$3.95"),
                        StringUtils.format("&7&l● &4&lDemonic&7: &a$3.95-$4.30"),
                        StringUtils.format("&7&l● &c&lLe&6&lge&a&ln&b&lda&d&lry&7: &a$4.30-$5.00")).build());

        builder.addItem(12, ItemBuilder.Builder.getInstance().itemType(Material.CHEST).itemName(StringUtils.format("&eCrates")).itemAmount(1)
                .itemLore(StringUtils.format("&f&lWhat Are Crates?"),
                        StringUtils.format("&7Crates allow you to"),
                        StringUtils.format("&7gain money, armor, tags,"),
                        StringUtils.format("&7and other items!"),
                        "     ",
                        StringUtils.format("&f&lHow To Obtain Crate Items?"),
                        StringUtils.format("&7Voting, killing, leveling up"),
                        StringUtils.format("&7and envoys allow you"),
                        StringUtils.format("&7to gain crate keys!"),
                        StringUtils.format("&7Envoy cooldowns are"),
                        StringUtils.format("&730 minutes long, and"),
                        StringUtils.format("&7if you get an envoy"),
                        StringUtils.format("&7flare, an envoy will start!"),
                        StringUtils.format("&7You can vote 5-7 times"),
                        StringUtils.format("&7a day, and get vote"),
                        StringUtils.format("&7keys for voting!"),
                        StringUtils.format("&7Kill Keys drop at 5%!"),
                        StringUtils.format("&7Level Keys drop per 10 levels!"),
                        "     ",
                        StringUtils.format("&f&lCommands"),
                        StringUtils.format("&7&l● &e/keypack info"),
                        StringUtils.format("&7&l● &e/keypack collect")).build());

        builder.addItem(13, ItemBuilder.Builder.getInstance().itemType(Material.DIAMOND_SWORD).itemName(StringUtils.format("&eDuels")).itemAmount(1)
                .itemLore(StringUtils.format("&f&lHow Does Duel Work?"),
                        StringUtils.format("&7Duels allow you to test"),
                        StringUtils.format("&7your skills in the arena!"),
                        StringUtils.format("&7Betting money makes it"),
                        StringUtils.format("&7a lot more interesting!"),
                        "      ",
                        StringUtils.format("&f&lCommands"),
                        StringUtils.format("&7&l● &e/duel <player>"),
                        StringUtils.format("&7&l● &e/duel <player> <amount>"),
                        StringUtils.format("&7&l● &e/duel <accept/deny> <player>"),
                        StringUtils.format("&7&l● &e/duelspec <player>"),
                        StringUtils.format("&7&l● &e/duel toggle"),
                        StringUtils.format("&7&l● &e/duel queue"),
                        StringUtils.format("&7&l● &e/duel stats")).build());

        builder.addItem(14, ItemBuilder.Builder.getInstance().itemType(Material.NETHER_STAR).itemName(StringUtils.format("&eGangs")).itemAmount(1)
                .itemLore(StringUtils.format("&f&lHow Does Gangs Work?"),
                        StringUtils.format("&7Gangs allow you to"),
                        StringUtils.format("&7make teams with your"),
                        StringUtils.format("&7friends more fun!"),
                        "      ",
                        StringUtils.format("&f&lMaking Your Gang OP!"),
                        StringUtils.format("&7Upgrading your gang allows"),
                        StringUtils.format("&7you to add more players"),
                        StringUtils.format("&7to your gang, and more op!"),
                        StringUtils.format("&7Max Gang Level: &e5"),
                        StringUtils.format("&7Max Player Amount: &e10"),
                        "      ",
                        StringUtils.format("&f&lCommands"),
                        StringUtils.format("&7&l● &e/g create <name>"),
                        StringUtils.format("&7&l● &e/g join <name>"),
                        StringUtils.format("&7&l● &e/g invite <player>"),
                        StringUtils.format("&7&l● &e/g disband"),
                        StringUtils.format("&7&l● &e/g leave"),
                        StringUtils.format("&7&l● &e/gchat"),
                        StringUtils.format("&7&l● &e/g withdraw <amount>"),
                        StringUtils.format("&7&l● &e/g deposit <amount>"),
                        StringUtils.format("&7&l● &e/g levelup")).build());

        builder.addItem(15, ItemBuilder.Builder.getInstance().itemType(Material.BOOK).itemName(StringUtils.format("&eKitPvP Pass")).itemAmount(1)
                .itemLore(StringUtils.format("&f&lWhat Is A KitPvP Pass?"),
                        StringUtils.format("&7A KitPvP Pass allows you to"),
                        StringUtils.format("&7gain rewards for doing"),
                        StringUtils.format("&7daily, and weekly challenges!"),
                        StringUtils.format("&7Upgrade your tiers to gain rewards!"),
                        "      ",
                        StringUtils.format("&f&lCommands"),
                        StringUtils.format("&7&l● &e/kp"),
                        StringUtils.format("&7&l● &e/kitp")).build());

        builder.addItem(16, ItemBuilder.Builder.getInstance().itemType(Material.DIAMOND_CHESTPLATE).itemName(StringUtils.format("&eKits")).itemAmount(1)
                .itemLore(StringUtils.format("&f&lWhat Do Kits Give You?"),
                        StringUtils.format("&7There are all sorts of kits!"),
                        StringUtils.format("&7Kits have certain cooldowns on them!"),
                        StringUtils.format("&7Being a donor allows you to"),
                        StringUtils.format("&7have access to donor kits!"),
                        "      ",
                        StringUtils.format("&f&lCommands"),
                        StringUtils.format("&7&l● &e/kit"),
                        StringUtils.format("&7&l● &e/kits"),
                        StringUtils.format("&7&l● &e/kit <name>")).build());

        InventoryDecorateMethods.decorateInfoMenu(builder.getInventory());
        player.openInventory(builder.getInventory());
    }
}
