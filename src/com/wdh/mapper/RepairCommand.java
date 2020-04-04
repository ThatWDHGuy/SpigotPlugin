package com.wdh.mapper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class RepairCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			if (args.length == 0) {
				Player p = (Player) sender;
				ItemStack i = p.getInventory().getItemInMainHand();
				if (i.getType().getMaxDurability() > 0 && i.getItemMeta() instanceof Damageable) {
					Damageable item = (Damageable) i.getItemMeta();
					item.setDamage(0);
					i.setItemMeta((ItemMeta) item);
				}
			} else if (args.length == 1 && args[0].equalsIgnoreCase("all")) {
				//System.out.println("Repair All");
				Player p = (Player) sender;
				for (ItemStack i : p.getInventory().getContents()) {
					if (i != null) {
						if (i.getType().getMaxDurability() > 0 && i.getItemMeta() instanceof Damageable) {
							Damageable item = (Damageable) i.getItemMeta();
							item.setDamage(0);
							i.setItemMeta((ItemMeta) item);
						}
					}
				}
			} else {
				return false;
			}
		}
		
		return true;
	}

}
