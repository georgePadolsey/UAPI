package uapi.georgep.pokuit.AnimalRideAPI;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import uapi.georgep.pokuit.Enums.RideableEntity;

public class AnimalRideManager {
	
	Plugin plugin;
	
	public AnimalRideManager(Plugin pl) {
		this.plugin = pl;
	}
	
	public void rideMob(Player p, RideableEntity re) {
	
	}
	
	public void rideMob(Player p, RideableEntity re, HashMap<String, Object> config) {
		
	}
	
}
