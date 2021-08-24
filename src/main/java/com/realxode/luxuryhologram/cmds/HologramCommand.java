package com.realxode.luxuryhologram.cmds;

import com.realxode.luxuryhologram.HologramManager;
import com.realxode.luxuryhologram.HologramType;
import com.realxode.luxuryhologram.LuxuryHologram;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.realxode.luxuryhologram.Utils.msgPlayer;

public class HologramCommand implements CommandExecutor {

    private LuxuryHologram main;
    private final HologramManager hologramManager;

    public HologramCommand(LuxuryHologram main){
        this.main = main;
        hologramManager = new HologramManager(main);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            msgPlayer(sender, "&c[!] &fOnly for players.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("luxuryhologram.admin")){
            msgPlayer(player, "&f¡El comando es sólo para &cadministradores&f!");
            return true;
        }
        if (args.length == 0){
            msgPlayer(player, "&dLuxuryHolograms &8| &fHelp:", ""
            , " &f- create &7| Create a hologram."
                    , " &f- reload &7| Reload plugin", ""
            , "&8Plugin creado por &fXode");
            return true;
        }
        // /lh create [name] [type]
        // 0   1      2      3
        if (args[0].equalsIgnoreCase("create")){
            if (args.length < 2) {
                msgPlayer(player, "&cDebes especificar un nombre.");
                return true;
            }
            if (args.length < 3){
                msgPlayer(player, "&cDebes especificar un tipo (TP - MSG).");
                return true;
            }
            String name = args[1];
            String type = args[2];
            if (main.getConfig().contains("TP_HOLOGRAM." + name) ||
                    main.getConfig().contains("MSG_HOLOGRAM." + name)){
                msgPlayer(player, "&cYa existe ese holograma!");
                return true;
            }
            switch (type.toUpperCase()) {
                case "TP" -> {
                    hologramManager.createHologram(name, player.getLocation(), HologramType.TP_HOLOGRAM);
                    msgPlayer(player, "&aHolograma &f" + name + "&a ha sido creado!");
                }
                case "MSG" -> {
                    hologramManager.createHologram(name, player.getLocation(), HologramType.MSG_HOLOGRAM);
                    msgPlayer(player, "&aHolograma &f" + name + "&a ha sido creado!");
                }
                default -> msgPlayer(player, "&cDebes especificar un tipo correcto (TP - MSG).");
            }
        }
        return false;
    }
}
