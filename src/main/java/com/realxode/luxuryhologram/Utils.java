package com.realxode.luxuryhologram;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {

    public static String color(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String decolor(String string){
        return ChatColor.stripColor(string);
    }

    public static void msgPlayer(CommandSender player, String... strings){
        for (String string : strings){
            player.sendMessage(color(string));
        }
    }

    public static void msgPlayer(Player player, String... strings){
        for (String string : strings){
            player.sendMessage(color(string));
        }
    }

}
