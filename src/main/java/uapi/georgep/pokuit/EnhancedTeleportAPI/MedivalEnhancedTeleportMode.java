package uapi.georgep.pokuit.EnhancedTeleportAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MedivalEnhancedTeleportMode extends EnhancedTeleportMode {

	public MedivalEnhancedTeleportMode(final Plugin plugin) {
		super(plugin);
		
		//First Stage
		stages.put(new EnhancedTeleportStage() {
			
			@Override
			public void runStage(final Player p, final Location l) {
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
					
					int i = 0;
					
					@Override
					public void run() {
						if(i == 0) {
							Location newL = p.getLocation();
							newL.setPitch(0F);
							newL.setYaw(0F);
							p.teleport(newL);
							
						} else {
							this.cancel();
						}
					}
					
					
					
				}, 0, 1);
			}
			
		}, 0);
	}

}
