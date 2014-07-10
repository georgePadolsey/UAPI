package uapi.georgep.pokuit.UAPI;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import uapi.georgep.pokuit.Data.UAPIData;
import uapi.georgep.pokuit.Enums.AnnouncementType;
import uapi.georgep.pokuit.Functions.ArenaFunctions;
import uapi.georgep.pokuit.Functions.GenericFunctions;
import uapi.georgep.pokuit.Functions.LoggingFunctions;
import uapi.georgep.pokuit.Managers.ArenaManager;
import uapi.georgep.pokuit.Objects.Arena;


public class UAPI {
	
	Plugin plugin;
	
	/**
	 * Constructor For The UAPI
	 * @param plugin
	 * 	Pass in the current instance of your Plugin
	 * @see
	 * 	org.bukkit.plugin.Plugin
	 */
	public UAPI(Plugin plugin) {
		this.plugin = plugin;
		plugin.getServer().getWorld("test").spawnEntity(new Location(plugin.getServer().getWorld("test"), 1,1,1), EntityType.BAT);
	}
	
	/**
	 * Get's An Arena Object thats stored from a id of an arena
	 * @param str
	 * 	A String that is a known arena's id
	 * @return
	 * 	The Arena Instance Or Null if no arena by that id
	 * @see
	 * 	Arena
	 * @since
	 * 	1.0
	 * @deprecated
	 */
	public Arena getArenaFromId(String str) {
		return ArenaFunctions.getArenaFromId(str);
	}
	
	/**
	 * Seralize's A Location
	 * @param loc
	 * 	Location to be Seralized
	 * @return
	 * 	The Seralized Location
	 * @since
	 * 	1.0
	 * @deprecated
	 */
	public String seralizeLocation(Location loc) {
		return GenericFunctions.seralizeLocation(loc);
	}
	
	/**
	 * Registers The Arena Manager
	 * @see ArenaManager
	 * @since
	 *    1.0
	 */
	public ArenaManager getArenaManager() {
		return UAPIData.arenaManager;
	}
	
	/**
	 * @deprecated
	 * @param message
	 * @param at
	 * @param players
	 */
	public void announceMessage(String message, AnnouncementType at, Player[] players) {
		try {
			UAPIData.announcementManager.announce(message, at, players);
		} catch(IllegalArgumentException e) {
			LoggingFunctions.logError(e, plugin);
		}
	}
}
