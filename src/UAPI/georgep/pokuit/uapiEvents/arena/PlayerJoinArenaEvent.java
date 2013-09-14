package UAPI.georgep.pokuit.uapiEvents.arena;

import org.bukkit.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import UAPI.georgep.pokuit.Objects.Arena;

/**
 * 
 * An Event that fires when a player joins an arena.
 * Can be cancelled.<br>
 * If cancelled it prevents entry to the arena<br>
 * This also handles where the player will be teleported to
 * on entry to an arena.
 * 
 * @see ArenaEvent
 * @since 1.0
 * @author George
 *
 */
public class PlayerJoinArenaEvent extends ArenaEvent implements Cancellable {
	
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;
	String p;
	
	
	/**
	 * Constructor of a WorldSniperWandSelectionEvent
	 * 
	 * Between pos1 and pos2 is the selection
	 * 
	 * @param p - Player that is selecting Something WIth the wand
	 * @param pos1 - The FIrst Position 
	 * @param pos2 - The Second Position
	 */
	public PlayerJoinArenaEvent(Player p, Arena arena) {
		super(arena);
		this.p = p.getName();
		this.cancelled = false;
		
	}
	
	/**
	 * Gets The Player that is included in this event's name
	 * @return Player Name
	 */
	public String getPlayerName() {
		return p;
	}
	
	/**
	 * Returns the Player that is included in this event
	 * @return 
	 * @throws NullPointerException if player is not online/doesn't exist
	 */
	public Player getPlayer() throws NullPointerException {
		return Bukkit.getServer().getPlayer(p);
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
