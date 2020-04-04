package com.wdh.mapper;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

public class MapCommand implements CommandExecutor {

	List<World> worlds;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		System.out.println("Sender: " + sender);
		System.out.println("Command: " + command);
		System.out.println("Label: " + label);
		System.out.print("Args: ");
		for (String a : args) {
			System.out.print(a + ", ");
		}
		System.out.println();

		if (args.length == 0) {
			sender.sendMessage("This plugin does mapping");
		} else {
			for (int i = 0; i < args.length; i++) {
				checkArgPair(sender, args[i], args[++i]);
			}
		}

		return true;
	}
	
	public void checkArgPair(CommandSender sender, String arg, String argVal) {
		if (arg.equalsIgnoreCase("-g")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				Location l = p.getLocation();
				String send = "Generating chunks around:" + (int) l.getBlockX() + ", " + (int) l.getBlockZ() + " in world: " +  l.getWorld().getName() + " (" + l.getWorld().getUID().toString() + ")";
				System.out.println(send);
				p.sendMessage(send);
				
				for (World w : worlds) {
					if (w.getName().equals(l.getWorld().getName())){
						//System.out.println(w.getName() + " " + w.getUID().toString());
						ChunkGenerator g = w.getGenerator();
						int rad = Integer.parseInt(argVal);
						for (int x = -rad; x < rad; x++) {
							for (int z = -rad; z < rad; z++) {
								
							}
						}
					}
				}
			} else {
				System.out.println("Must be player to execute -g");
			}
		}
	}

	public void setWorlds(List<World> worlds) {
		// TODO Auto-generated method stub
		this.worlds = worlds;
	}
	
}
