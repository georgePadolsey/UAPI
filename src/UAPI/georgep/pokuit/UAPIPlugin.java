package UAPI.georgep.pokuit;

import java.util.HashMap;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import UAPI.georgep.pokuit.Objects.HungerGamesArena;
import UAPI.georgep.pokuit.UAPI.UAPI;

public class UAPIPlugin extends JavaPlugin {
	
	HungerGamesArena a;
	
	public void onEnable() {
		a = new HungerGamesArena(this, new HashMap<String, Object>());
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
