package com.realxode.luxuryhologram.listeners;

import com.realxode.luxuryhologram.HologramType;
import com.realxode.luxuryhologram.LuxuryHologram;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class HologramListener implements Listener {

    private LuxuryHologram main;
    public HologramListener(LuxuryHologram main){
        this.main = main;
    }

    @EventHandler
    public void onInteract(PlayerArmorStandManipulateEvent event){

        Player player = event.getPlayer();

        if (!event.getRightClicked().isVisible()) {
            event.setCancelled(true);

            /* TODO: CHANGE EVENT TO PlayerInteractEvent */

            if (event.getRightClicked().getCustomName().contains(HologramType.TP_HOLOGRAM.getString())){
                for (String keys : main.getConfig().getConfigurationSection
                        ("TP_HOLOGRAM").getKeys(false)){
                    ConfigurationSection tpSection = main.getConfig().getConfigurationSection
                            ("TP_HOLOGRAM." + keys);
                    assert tpSection != null;
                    if (tpSection.getLocation("location").equals(event.getRightClicked().getLocation())){
                        player.performCommand(tpSection.getString("command"));

                    }
                }
            }
        }

    }
}
