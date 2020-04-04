package com.wdh.mapper;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DupeCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		
			
			Player p = (Player) sender;
			ItemStack item = p.getInventory().getItemInMainHand();
			int spaces = 54;
			Inventory dupe = Bukkit.getServer().createInventory(p, spaces, item.getItemMeta().getDisplayName());
			for (int i = 0; i < spaces; i++) {
				dupe.setItem(i, item);
			}
			p.openInventory(dupe);
		}
		
		return true;
	}

}
