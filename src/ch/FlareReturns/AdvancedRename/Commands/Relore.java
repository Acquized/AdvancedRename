package ch.FlareReturns.AdvancedRename.Commands;

import java.util.ArrayList;
import java.util.List;

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

public class Relore implements CommandExecutor {
	
	public Relore() {
		Bukkit.getPluginCommand("relore").setUsage(Main.pr + "§7/relore <Itemlore ...>");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if((p.hasPermission("advancedrename.relore")) || (p.hasPermission("advancedrename.*"))) {
				if(args.length >= 1) {
					if((p.getItemInHand() != null) && (p.getItemInHand().getType() != Material.AIR)) {
						String name = args[0];
						for(int i = 0; i < args.length; i++) {
							name = name + " " + args[i];
						}
						name = ChatColor.translateAlternateColorCodes('&', name);
						if((name.contains(";"))) {
							ItemStack i = p.getItemInHand();
							ItemMeta im = i.getItemMeta();
							String[] lore = name.split(";");
							List<String> il = new ArrayList<String>();
							for(int l = 1; l < lore.length; l++) {
								il.add(lore[l]);
							}
							im.setLore(il);
							i.setItemMeta(im);
							p.updateInventory();
							p.sendMessage(Main.pr + "§7Successfully lore set for the item.");
							return true;
						} else {
							ItemStack i = p.getItemInHand();
							ItemMeta im = i.getItemMeta();
							List<String> il = new ArrayList<String>();
							il.add(name);
							im.setLore(il);
							i.setItemMeta(im);
							p.updateInventory();
							p.sendMessage(Main.pr + "§7Successfully lore set for the item.");
							return true;
						}
					} else {
						p.sendMessage(Main.pr + "§cPlease hold a Item in your hand.");
						return true;
					}
				}
			} else {
				p.sendMessage(Main.pr + "§cYou dont have permission to use this command!");
				return true;
			}
		} else {
			sender.sendMessage("[AdvancedRename] You must be a player to relore a item.");
			return true;
		}
		return false;
	}

}
