package uapi.georgep.pokuit.Objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import uapi.georgep.pokuit.Events.Arena.ArenaStartArenaEvent;
import uapi.georgep.pokuit.Events.Arena.PlayerJoinArenaEvent;


/**
 * A Abstract Class To Build apon
 * @see <a href="https://github.com/georgePadolsey/UAPI/wiki/Setting-up-an-arena">https://github.com/georgePadolsey/UAPI/wiki/Setting-up-an-arena</a>
 * @author George
 */
public abstract class Arena {
	
	protected String id;
	protected String displayName;
	protected static String type;
	
	protected int timeToWaitTillStart = 0;
	
	protected Plugin pl = null;
	protected BukkitTask taskId = null;
	
	protected HashMap<String,Object> data = new HashMap<String,Object>();
	private ArrayList<String> players = new ArrayList<String>();
	
	public Arena(Plugin pl, HashMap<String, Object> data) {
		this.pl = pl;
		this.data = data;
		setup();
	}
	
	/**
	 * Gets Display Name Of Arena
	 * @return String - Display Name Of Arena
	 */
	public final String getDisplayName() {
		return displayName;
	}
	
	/**
	 * Gets Id Of Arena
	 * @return String - Id of Arena
	 */
	public final String getId() {
		return id;
	}
	
	/**
	 * Gets Type Of Arena
	 * @return String - Type of Arena
	 */
	public final String getType() {
		return type;
	}
	
	/**
	 * 
	 */
	public final void countDownToStart() {
		this.taskId = Bukkit.getScheduler().runTaskTimer(pl, new Runnable() {
			
			int i = timeToWaitTillStart;
			
			@Override
			public void run() {
				
				if(i <= 0) {
					cancelCountDownEvent();
					start();
				}
				
				sendMessageToPlayers(countDownMessages(i));
				
				i--;
				
			}
		}, 0, 20);
	}
	
	public final void cancelCountDownEvent() {
		taskId.cancel();
		taskId = null;
	}
	
	/**
	 * Adds player to arena
	 * @param __p Player
	 */
	public final void addPlayer(Player __p) {
		
		String p = __p.getName();
		
		PlayerJoinArenaEvent e = new PlayerJoinArenaEvent(__p, this);
		
		pl.getServer().getPluginManager().callEvent(e);
		
		if(!e.isCancelled()) {
			players.add(p);
			if(e.getTeleportTo() != null) {
				__p.teleport(e.getTeleportTo());
			}
		} 
	}
	
	public final void start() {
		ArenaStartArenaEvent e = new ArenaStartArenaEvent(this);
		
		pl.getServer().getPluginManager().callEvent(e);
		
		if(e.isCancelled()) {
			countDownToStart();
		}  else {
			__start();
		}
	}
	
	public void sendMessageToPlayers(String s) {
		for(String p :players) {
			try {
				pl.getServer().getPlayer(p).sendMessage(s);
			} catch(NullPointerException e) {}
		}
	}
	
	
	/**
	 * Automatically runs on constructor creation
	 */
	public abstract void setup();
	
	/**
	 * Every second Of the countdown it fires with the seconds left. You can choose to ignore it by returning ""<br>
	 * Or saying something to all the players in the arena
	 * @param i
	 */
	public abstract String countDownMessages(int i);
	
	/**
	 * Runs when the arena has finished its countdown
	 */
	protected abstract void __start();

	//TODO
	public abstract void setDisplayName(String dName);
	
	//TODO
	public abstract void setId(String id);
	
}
