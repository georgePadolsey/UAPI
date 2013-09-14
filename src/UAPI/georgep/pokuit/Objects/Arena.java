package UAPI.georgep.pokuit.Objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import UAPI.georgep.pokuit.uapiEvents.arena.PlayerJoinArenaEvent;

public abstract class Arena {
	
	protected String displayName = "";
	protected String id = "";
	protected int timeToWaitTillStart = 0;
	protected Plugin pl = null;
	protected BukkitTask taskId = null;
	
	protected HashMap<String,Object> data = new HashMap<String,Object>();
	private ArrayList<String> players = new ArrayList<String>();
	
	public Arena(Plugin pl, HashMap<String, Object> data) {
		this.pl = pl;
		this.data = data;
		
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
				
				countDownMessages(i);
				
				i--;
				
				
			}
			
		}, 0, 20);
	}
	
	public final void cancelCountDownEvent() {
		taskId.cancel();
		taskId = null;
	}
	
	
	public final void addPlayer(Player __p) {
		
		String p = __p.getName();
		
		PlayerJoinArenaEvent e = new PlayerJoinArenaEvent(__p, this);
		
		pl.getServer().getPluginManager().callEvent(e);
		
		if(!e.isCancelled()) {
			players.add(p);
		} 
	}
	
	public abstract void setup();
	
	public abstract void countDownMessages(int i);
	
	public abstract void start();
	
	
	
	//public abstract boolean onPrePlayerJoinArenaEvent();

	//public abstract void onPrePlayerLeaveArenaEvent();
	
	protected abstract HashMap<String,Object> getData();
	
	protected abstract Plugin getPlugin();
	
	
	////// None abstract methods ///////
	public void onTimeUpdateEvent() {}

	
}
