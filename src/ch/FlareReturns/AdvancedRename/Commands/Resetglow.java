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

public class Resetglow implements CommandExecutor {
	
	public Resetglow() {
		Bukkit.getPluginCommand("resetglow").setUsage(Main.pr + "§7/resetglow");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if((p.hasPermission("advancedrename.resetglow") || (p.hasPermission("advancedrename.*")))) {
				if(args.length == 0) {
					if((p.getItemInHand() != null) && (p.getItemInHand().getType() != Material.AIR)) {
						try {
						ItemStack i = p.getItemInHand();
						ItemMeta im = i.getItemMeta();
						im.removeEnchant(Enchantment.LUCK);
						im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
						i.setItemMeta(im);
						p.updateInventory();
						p.sendMessage(Main.pr + "§7Successfully removed the glow effect!");
						return true;
						} catch (Exception ex) {
							p.sendMessage(Main.pr + "§cThis item has no glow effect!");
							return true;
						}
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
			sender.sendMessage("[AdvancedRename] You must be a player to reset the glow effect.");
			return true;
		}
		return false;
	}

}
