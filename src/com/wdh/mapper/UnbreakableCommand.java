package com.wdh.mapper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class UnbreakableCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					ItemStack i = p.getInventory().getItemInMainHand();
					if (checkItem(i)) {
						i.setItemMeta(set(true, i));
					}
				} else if (args[0].equalsIgnoreCase("off")) {
					ItemStack i = p.getInventory().getItemInMainHand();
					if (checkItem(i)) {
						i.setItemMeta(set(false, i));
					}
				} else if ((args[0].equalsIgnoreCase("toggle") || args[0].equalsIgnoreCase("t"))) {
					ItemStack i = p.getInventory().getItemInMainHand();
					if (checkItem(i)) {
						i.setItemMeta(toggle(i));
					}
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("on") && args[1].equalsIgnoreCase("all")) {
					for (ItemStack i : p.getInventory().getContents()) {
						if (checkItem(i)) {
							i.setItemMeta(set(true, i));
						}
					}
				} else if (args[0].equalsIgnoreCase("off") && args[1].equalsIgnoreCase("all")) {
					for (ItemStack i : p.getInventory().getContents()) {
						if (checkItem(i)) {
							i.setItemMeta(set(false, i));
						}
					}
				} else if ((args[0].equalsIgnoreCase("toggle") || args[0].equalsIgnoreCase("t")) && args[1].equalsIgnoreCase("all")) {
					for (ItemStack i : p.getInventory().getContents()) {
						if (checkItem(i)) {
							i.setItemMeta(toggle(i));
						}
					}
				}
			}
		}
		return false;

	}

	public boolean checkItem(ItemStack i) {
		return i.getType().getMaxDurability() > 0 && i.getItemMeta() instanceof Damageable && i != null;
	}

	public ItemMeta set(boolean set, ItemStack i) {
		ItemMeta im = i.getItemMeta();
		im.setUnbreakable(set);
		return im;
	}

	public ItemMeta toggle(ItemStack i) {
		ItemMeta im = i.getItemMeta();
		im.setUnbreakable(im.isUnbreakable() ? false : true);
		return im;
	}

}
