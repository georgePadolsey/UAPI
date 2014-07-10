package uapi.georgep.pokuit.Managers;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import uapi.georgep.pokuit.Enums.AnnouncementType;

public class AnnouncementManager {
	
	Plugin plugin;
	
	public AnnouncementManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void announce(String message, AnnouncementType at, Player[] players) throws IllegalArgumentException {
		if(at == AnnouncementType.BOSS_HEALTH) {
			for(Player p : players) {
				final Wither w = (Wither) p.getWorld().spawnEntity(p.getLocation(), EntityType.WITHER);
				final Location l = w.getLocation();
				w.setCustomName(message);
				plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable() {
					public void run() {
						w.remove();
					}
				}, 500);
				plugin.getServer().getScheduler().runTaskTimer(plugin, new BukkitRunnable() {
					public void run() {
						w.teleport(l);
					}
				}, 0, 1);
			}
		}
	}
	
}
