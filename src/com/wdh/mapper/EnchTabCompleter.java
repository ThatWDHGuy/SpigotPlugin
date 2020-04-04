package com.wdh.mapper;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.event.server.TabCompleteEvent;

public class EnchTabCompleter extends TabCompleteEvent{
	
	
	
	public EnchTabCompleter(CommandSender sender, String buffer, List<String> completions) {
		super(sender, buffer, completions);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<String> getCompletions() {
		// TODO Auto-generated method stub
		return super.getCompletions();
	}	

}
