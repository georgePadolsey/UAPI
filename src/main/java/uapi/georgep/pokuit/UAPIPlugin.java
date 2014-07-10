package uapi.georgep.pokuit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import uapi.georgep.pokuit.UAPI.UAPI;
import uapi.georgep.pokuit.AnimalRideAPI.AnimalRideManager;
import uapi.georgep.pokuit.Data.UAPIData;
import uapi.georgep.pokuit.Managers.AnnouncementManager;
import uapi.georgep.pokuit.Managers.ArenaManager;


public class UAPIPlugin extends JavaPlugin implements Listener {
	
	public void onEnable() {
		UAPIData.arenaManager = new ArenaManager(this);
		UAPIData.announcementManager = new AnnouncementManager(this);
		UAPIData.animalRideManager = new AnimalRideManager(this);
		
		//TESTING CODE
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
	}
	
	/**
	 * Returns the api
	 * @param plugin - The Instance of your current plugin
	 * @return UAPI - A new UAPI Instance
	 * @since 1.0
	 * @see uapi.georgep.pokuit.UAPI.UAPI
	 */
	public UAPI getAPI(Plugin plugin) {
		return new UAPI(plugin);
	}
	
	//TESTING CODE
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e) {
		
	}
}
