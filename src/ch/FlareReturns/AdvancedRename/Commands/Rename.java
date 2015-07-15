package ch.FlareReturns.AdvancedRename.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.FlareReturns.AdvancedRename.Main;

public class Rename implements CommandExecutor {
	
	public Rename() {
		Bukkit.getPluginCommand("rename").setUsage(Main.pr + "§7/rename <Itemname ...>");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if((p.hasPermission("advancedrename.rename")) || (p.hasPermission("advancedrename.*"))) {
				if(args.length >= 1) {
					if((p.getItemInHand() != null) && (p.getItemInHand().getType() != Material.AIR)) {
						String name = args[0];
						for(int i = 1; i < args.length; i++) {
							name = name + " " + args[i];
						}
						name = ChatColor.translateAlternateColorCodes('&', name);
						ItemStack i = p.getItemInHand();
						ItemMeta im = i.getItemMeta();
						im.setDisplayName(name);
						i.setItemMeta(im);
						p.updateInventory();
						p.sendMessage(Main.pr + "§7Itemname for " + i.getType().name() + " set to §r" + name + "§7.");
						return true;
					} else {
						p.sendMessage(Main.pr + "§cPlease hold a item in your hand.");
						return true;
					}
				}
			} else {
				p.sendMessage(Main.pr + "§cYou dont have permission to use this command.");
				return true;
			}
		} else {
			sender.sendMessage("[AdvancedRename] You must be a player to rename a item!");
			return true;
		}
		return false;
	}

}
