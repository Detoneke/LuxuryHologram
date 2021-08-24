package com.realxode.luxuryhologram;

import com.realxode.luxuryhologram.cmds.HologramCommand;
import com.realxode.luxuryhologram.listeners.HologramListener;
import org.bukkit.plugin.java.JavaPlugin;

public class LuxuryHologram extends JavaPlugin {

    @Override
    public void onEnable(){
        this.saveDefaultConfig();
        this.getCommand("lh").setExecutor(new HologramCommand(this));
        this.getServer().getPluginManager().registerEvents(new HologramListener(this), this);
    }

    @Override
    public void onDisable(){

    }

}
