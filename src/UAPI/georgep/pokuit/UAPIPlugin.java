package UAPI.georgep.pokuit;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import UAPI.georgep.pokuit.UAPI.UAPI;

public class UAPIPlugin extends JavaPlugin {
	
	
	public void onEnable() {
	}
	
	public void onDisable() {
	}
	
	/**
	 * Returns the api
	 * @param plugin - The Instance of your current plugin
	 * @return UAPI - A new UAPI Instance
	 * @since 1.0
	 * @see UAPI
	 */
	public UAPI getAPI(Plugin plugin) {
		return new UAPI(plugin);
	}
}
