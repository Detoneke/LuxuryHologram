package com.realxode.luxuryhologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import static com.realxode.luxuryhologram.Utils.color;
import static com.realxode.luxuryhologram.Utils.decolor;

public class HologramManager {

    private LuxuryHologram main;
    private String name;

    public HologramManager(LuxuryHologram main){
        this.main = main;
    }

    public void createHologram(String name, Location location, HologramType hologramType){
        ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

        as.setVisible(false);
        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setCustomName(color(name));
        as.setCustomNameVisible(true);

        if (hologramType.equals(HologramType.TP_HOLOGRAM)){

            ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity
                    (location.add(0, 0.3, 0), EntityType.ARMOR_STAND);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setCanPickupItems(false);
            armorStand.setCustomName(hologramType.getString());
            armorStand.setCustomNameVisible(true);
            main.getConfig().set("TP_HOLOGRAM." + decolor(name) + ".location", armorStand.getLocation());
            main.getConfig().set("TP_HOLOGRAM." + decolor(name) + ".command", "say Cambia esto en " +
                    "la configuración!");
            main.saveConfig();
        } else if (hologramType.equals(HologramType.MSG_HOLOGRAM)){
            ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity
                    (location.add(0, 0.3, 0), EntityType.ARMOR_STAND);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setCanPickupItems(false);
            armorStand.setCustomName(hologramType.getString());
            armorStand.setCustomNameVisible(true);

            main.getConfig().set("MSG_HOLOGRAM." + decolor(name) + ".location", armorStand.getLocation());
            main.getConfig().set("MSG_HOLOGRAM." + decolor(name) + ".command", "say Cambia esto en " +
                            "la configuración!");
            main.saveConfig();
        }

    }


}
