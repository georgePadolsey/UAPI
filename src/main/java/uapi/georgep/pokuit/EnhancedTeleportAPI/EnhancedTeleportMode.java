package uapi.georgep.pokuit.EnhancedTeleportAPI;

import java.util.TreeMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class EnhancedTeleportMode {
	
	protected TreeMap<EnhancedTeleportStage, Integer> stages = new TreeMap<EnhancedTeleportStage, Integer>();
	protected Plugin plugin;
	
	public EnhancedTeleportMode(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public final TreeMap<EnhancedTeleportStage, Integer> getStages() {
		return stages;
	}
	
	public final void teleport(final Player p, final Location l) {
		int num = 0;
		for(final EnhancedTeleportStage r : stages.keySet()) {
			
			num += stages.get(r);
			Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

				@Override
				public void run() {
					r.runStage(p, l);
				}  }, num);
			
		}	
	}
}
