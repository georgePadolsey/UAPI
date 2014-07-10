package uapi.georgep.pokuit.Events.Arena;

import org.bukkit.event.Event;

import uapi.georgep.pokuit.Objects.Arena;


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
