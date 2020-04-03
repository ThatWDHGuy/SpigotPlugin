package com.wdh.mapper;

import org.bukkit.plugin.java.JavaPlugin;

public class WdhMap extends JavaPlugin {
	
	WdhCommand wdhC;
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	wdhC = new WdhCommand();
    	this.getCommand("wdhmap").setExecutor(wdhC);
    	wdhC.setWorlds(this.getServer().getWorlds());
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
