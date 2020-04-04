package com.wdh.mapper;

import org.bukkit.plugin.java.JavaPlugin;

public class WdhMap extends JavaPlugin {
	
	MapCommand wdhC;
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	wdhC = new MapCommand();
    	this.getCommand("map").setExecutor(wdhC);
    	wdhC.setWorlds(this.getServer().getWorlds());
    	this.getCommand("ench").setExecutor(new EnchCommand());
    	this.getCommand("dupe").setExecutor(new DupeCommand());
    	this.getCommand("repair").setExecutor(new RepairCommand());
    	this.getCommand("unbreakable").setExecutor(new UnbreakableCommand());
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
