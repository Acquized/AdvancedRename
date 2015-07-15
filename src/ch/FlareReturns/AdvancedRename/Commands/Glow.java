package ch.FlareReturns.AdvancedRename.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.FlareReturns.AdvancedRename.Main;

public class Glow implements CommandExecutor {
	
	public Glow() {
		Bukkit.getPluginCommand("glow").setUsage(Main.pr + "§7/glow");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if((p.hasPermission("advancedrename.glow") || (p.hasPermission("advancedrename.*")))) {
				if(args.length == 0) {
					if((p.getItemInHand() != null) && (p.getItemInHand().getType() != Material.AIR)) {
						ItemStack i = p.getItemInHand();
						ItemMeta im = i.getItemMeta();
						im.addEnchant(Enchantment.LUCK, 10, true);
						im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
						i.setItemMeta(im);
						p.updateInventory();
						p.sendMessage(Main.pr + "§7Successfully added a enchantment glow to your item!");
						return true;
					} else {
						p.sendMessage(Main.pr + "§cYou must hold a item in your hand.");
						return true;
					}
				}
			} else {
				p.sendMessage(Main.pr + "§cYou dont have permission to use this command!");
				return true;
			}
		} else {
			sender.sendMessage("[AdvancedRename] You must be a player to add a enchantment glow to a item.");
			return true;
		}
		return false;
	}

}
