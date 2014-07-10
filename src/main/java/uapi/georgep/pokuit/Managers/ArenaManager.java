package uapi.georgep.pokuit.Managers;

import java.util.ArrayList;

import org.bukkit.plugin.Plugin;

import uapi.georgep.pokuit.Data.UAPIData;
import uapi.georgep.pokuit.Objects.Arena;

public class ArenaManager {
	
	private Plugin plugin;
	
	public ArenaManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void registerArena(Arena a) {
		UAPIData.arenas.add(a);
	}
	
	public void registerArena(Arena a, Boolean b) {
		registerArena(a);
		if(b) plugin.getServer().getPluginManager().registerEvents(a, plugin);
	}
	
	public void unRegisterArena(Arena a) {
		UAPIData.arenas.remove(a);
	}
		
	public Arena[] getArenasByType(Class<? extends Arena> clazz) {
		ArrayList<Arena> ar = new ArrayList<Arena>();
		for(Arena a:UAPIData.arenas) {
			if(a.getClass().equals(clazz)) {
				ar.add(a);
			}
		}
		return (Arena[])ar.toArray();
	}
	
	@SuppressWarnings("static-access")
	public Arena[] getArenasByType(String clazz) {
		ArrayList<Arena> ar = new ArrayList<Arena>();
		for(Arena a: UAPIData.arenas) {
			if(a.getType().equals(clazz)) {
				ar.add(a);
			}
		}
		return (Arena[])ar.toArray();
	}
	
	public Arena getArenaById(String id) {
		for(Arena a:UAPIData.arenas) {
			if(a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
	public Arena getArenaByDisplayName(String displayName) {
		for(Arena a:UAPIData.arenas) {
			if(a.getDisplayName().equals(displayName)) {
				return a;
			}
		}
		return null;
	}
	
	public Arena[] getAllArenas() {
		return (Arena[])UAPIData.arenas.toArray();
	}
}
