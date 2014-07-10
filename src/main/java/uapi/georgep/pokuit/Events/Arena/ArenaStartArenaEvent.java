package uapi.georgep.pokuit.Events.Arena;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import uapi.georgep.pokuit.Objects.Arena;

public class ArenaStartArenaEvent extends ArenaEvent implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;
	String p;
	
	
	/**
	 * Constructor of a ArenaStartArenaEvent
	 * 
	 * @param p - The Player involved in the event
	 * @param arena - The Arena involved in the event
	 */
	public ArenaStartArenaEvent(Arena arena) {
		super(arena);
		this.cancelled = false;
		
	}
	
	/**
	 * Gets Handlers
	 */
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	/**
	 * Gets Handler List
	 */
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	/**
	 * Returns if the event is cancelled or not
	 * @return boolean - True if event has been cancelled false if not
	 */
	@Override
	public boolean isCancelled() {
		return cancelled;
	}
	
	/**
	 * Sets whether the event is cancelled
	 * @param cancel
	 */
	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}

}
