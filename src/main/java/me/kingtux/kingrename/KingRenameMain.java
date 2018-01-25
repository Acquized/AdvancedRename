package me.kingtux.kingrename;

import me.kingtux.kingrename.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KingRenameMain extends JavaPlugin {

	private static KingRenameMain instance;
	
	@Override
	public void onEnable() {
		instance = this;
		registerCommands();
		saveDefaultConfig();
		BStats bStats = new BStats(this);
	}

	@Override
	public void onDisable() {
	}
	
	
	private void registerCommands() {
		Bukkit.getPluginCommand("itemmod").setExecutor(new ItemModCommand(this));
	}
	
	public static KingRenameMain getInstance() {
		return instance;
	}

}
