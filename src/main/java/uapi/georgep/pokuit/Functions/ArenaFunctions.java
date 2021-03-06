package uapi.georgep.pokuit.Functions;

import uapi.georgep.pokuit.Data.UAPIData;
import uapi.georgep.pokuit.Objects.Arena;

public class ArenaFunctions {
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Arena getArenaFromId(String str) {
		LoggingFunctions.debug("turned "+str+" Into arena");
		Arena arena = null;
		for(Arena __arena:UAPIData.arenas) {
			if(__arena.getId().equalsIgnoreCase(str)) {
				arena = __arena;
			}
		}
		return arena;
	}
}
