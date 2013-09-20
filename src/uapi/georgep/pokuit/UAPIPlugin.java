package uapi.georgep.pokuit;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import uapi.georgep.pokuit.UAPI.UAPI;
import uapi.georgep.pokuit.Data.UAPIData;
import uapi.georgep.pokuit.Managers.ArenaManager;


public class UAPIPlugin extends JavaPlugin {
	
	public void onEnable() {
		UAPIData.arenaManager = new ArenaManager(this);
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
