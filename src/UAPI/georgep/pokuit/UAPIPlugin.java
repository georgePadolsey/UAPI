package UAPI.georgep.pokuit;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import UAPI.georgep.pokuit.UAPI.UAPI;

public class UAPIPlugin extends JavaPlugin {
	
	public void onEnable() {
	}
	
	public void onDisable() {
		
	}
	
	public UAPI getAPI(Plugin plugin) {
		return new UAPI(plugin);
	}
	
}
