package uapi.georgep.pokuit.Events.Arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import uapi.georgep.pokuit.Objects.Arena;


/**
 * 
 * An Event that fires when a player joins an arena.
 * Can be cancelled.<br>
 * If cancelled it prevents entry to the arena<br>
 * This also handles where the player will be teleported to
 * on entry to an arena.
 * 
 * @see uapi.georgep.pokuit.Events.Arena.ArenaEvent
 * @since 1.0
 * @author George
 *
 */
public class PlayerJoinArenaEvent extends ArenaEvent implements Cancellable {
	
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;
	private Location teleportTo = null;
	String p;
	
	
	/**
	 * Constructor of a PlayerJoinArenaEvent
	 * 
	 * @param p - The Player involved in the event
	 * @param arena - The Arena involved in the event
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
	
	/**
	 * Sets where to teleport the player to after joining the arena
	 * @param teleportTo - A Location
	 * @see org.bukkit.Location
	 */
	public void setTeleportTo(Location teleportTo) {
		this.teleportTo = teleportTo;
	}
	/**
	 * Gets where you want to teleport the player to after joining the arena
	 * @return Location
	 */
	public Location getTeleportTo() {
		return teleportTo;
	}
}
