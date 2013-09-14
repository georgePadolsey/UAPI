package UAPI.georgep.pokuit.uapiEvents.arena;

import org.bukkit.event.Event;

import UAPI.georgep.pokuit.Objects.Arena;

public abstract class ArenaEvent extends Event {
	
	protected Arena arena;
	
	public ArenaEvent(final Arena arena) {
		this.arena = arena;
	}
	
	/**
	 * Returns the arena who is involved in this event
	 * 
	 * @return Arena involved in this event
	 */
	public final Arena getArena() {
		return arena;
	}
	
}
