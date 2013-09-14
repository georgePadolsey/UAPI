package UAPI.georgep.pokuit.UAPI;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import UAPI.georgep.pokuit.Data.UAPIData;
import UAPI.georgep.pokuit.Functions.ArenaFunctions;
import UAPI.georgep.pokuit.Functions.GenericFunctions;
import UAPI.georgep.pokuit.Objects.Arena;

public class UAPI {
	
	Plugin plugin;
	
	/**
	 * Constructor For The UAPI
	 * @param plugin
	 * 	Pass in the current instance of your Plugin
	 * @see
	 * 	Plugin
	 */
	public UAPI(Plugin plugin) {
		this.plugin = plugin;
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
	 */
	public String seralizeLocation(Location loc) {
		return GenericFunctions.seralizeLocation(loc);
	}
	
	/**
	 * TODO
	 * @param a
	 */
	public void registerArena(Arena a) {
		UAPIData.arenas.add(a);
	}
	
}
