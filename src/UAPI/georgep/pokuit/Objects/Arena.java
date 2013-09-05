package UAPI.georgep.pokuit.Objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import UAPI.georgep.pokuit.Functions.GenericFunctions;

public abstract class Arena {
	
	private String displayName = "";
	private String id = "";
	private int timeToWaitTillStart = 0;
	private Plugin pl = null;
	private BukkitTask taskId = null;
	
	private HashMap<String,String> data;
	private ArrayList<String> players;
	
	
	/**
	 * Constructor of Arena
	 * @param data
	 * 	- A hashmap containing data important to the arena
	 */
	public Arena(Plugin pl, HashMap<String,String> data) {
		this.data = data;
		this.pl = pl;
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
	
	
	public abstract void setup();
	
	public abstract void countDownMessages(int i);
	
	public abstract void start();
	
	public abstract boolean onPrePlayerJoinArenaEvent();

	public abstract void onPrePlayerLeaveArenaEvent();
	
	
	////// None abstract methods ///////
	public void onTimeUpdateEvent() {}
	
}
