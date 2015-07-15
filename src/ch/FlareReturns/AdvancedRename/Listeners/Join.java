package ch.FlareReturns.AdvancedRename.Listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ch.FlareReturns.AdvancedRename.Main;

public class Join implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(p.getName().equals("FlareReturns") || p.getName().equals("Beaconplays")) {
			p.sendMessage(Main.pr + "§7Hey! Dieser Server nutzt dein Plugin §eAdvancedRename§7.");
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 10, 10);
		}
	}

}
