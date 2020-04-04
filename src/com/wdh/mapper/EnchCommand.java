package com.wdh.mapper;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.server.TabCompleteEvent;

public class EnchCommand implements CommandExecutor {

	
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

		doArgPair(sender, args[0], args[1]);

		return true;
	}
	
	public void doArgPair(CommandSender sender, String arg, String argVal) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Enchantment e = Enchantment.getByKey(NamespacedKey.minecraft(arg));
			p.getInventory().getItemInMainHand().addUnsafeEnchantment(e, Integer.parseInt(argVal));
		}
	}
	
}
