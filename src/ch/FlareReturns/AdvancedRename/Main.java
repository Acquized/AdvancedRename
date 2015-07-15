package ch.FlareReturns.AdvancedRename;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ch.FlareReturns.AdvancedRename.Commands.Glow;
import ch.FlareReturns.AdvancedRename.Commands.Relore;
import ch.FlareReturns.AdvancedRename.Commands.Rename;
import ch.FlareReturns.AdvancedRename.Commands.Resetglow;
import ch.FlareReturns.AdvancedRename.Listeners.Join;

public class Main extends JavaPlugin {
	
	public static String pr = "§1 §3AR §8» §7";
	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		registerListeners();
		registerCommands();
		Bukkit.getConsoleSender().sendMessage("[AdvancedRename] AdvancedRename v" + getDescription().getVersion() + " enabled.");
		try {
			MetricsLite metrics = new MetricsLite(this);
			metrics.start();
			Bukkit.getConsoleSender().sendMessage("[AdvancedRename] Metrics successfully started.");
		} catch (IOException ex) {
			System.err.println("[AdvancedRename] Metrics cant send stats to mcstats.org.");
		}
	}

	@Override
	public void onDisable() {
		instance = null;
		Bukkit.getConsoleSender().sendMessage("[AdvancedRename] AdvancedRename v" + getDescription().getVersion() + " disabled.");
	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Join(), this);
	}
	
	private void registerCommands() {
		Bukkit.getPluginCommand("rename").setExecutor(new Rename());
		Bukkit.getPluginCommand("relore").setExecutor(new Relore());
		Bukkit.getPluginCommand("glow").setExecutor(new Glow());
		Bukkit.getPluginCommand("resetglow").setExecutor(new Resetglow());
	}
	
	public static Main getInstance() {
		return instance;
	}

}
