package UAPI.georgep.pokuit.uapiEvents.arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import UAPI.georgep.pokuit.Objects.Arena;

/**
 * 
 * An Event that fires when a player leaves an arena.<br>
 * This also handles where the player will be teleported to
 * on leaving an arena.
 * 
 * @see ArenaEvent
 * @since 1.0
 * @author George
 *
 */
public class PlayerLeaveArenaEvent extends ArenaEvent {
	
	private static final HandlerList handlers = new HandlerList();
	private Location teleportTo = null;
	String p;
	
	/**
	 * Constructor of a PlayerJoinArenaEvent
	 * 
	 * @param p - The Player involved in the event
	 * @param arena - The Arena involved in the event
	 */
	public PlayerLeaveArenaEvent(Player p, Arena arena) {
		super(arena);
		this.p = p.getName();
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
	 * Sets where to teleport the player to after leaving the arena
	 * @param teleportTo - A Location
	 * @see Location
	 */
	public void setTeleportTo(Location teleportTo) {
		this.teleportTo = teleportTo;
	}
	/**
	 * Gets where you want to teleport the player to after leaving the arena
	 * @return Location
	 */
	public Location getTeleportTo() {
		return teleportTo;
	}
}
