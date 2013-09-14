package UAPI.georgep.pokuit.Objects;

import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import UAPI.georgep.pokuit.uapiEvents.arena.PlayerJoinArenaEvent;

public class HungerGamesArena extends Arena implements Listener{
	
	public HungerGamesArena(Plugin pl, HashMap<String, Object> data) {
		super(pl, data);
		pl.getServer().getPluginManager().registerEvents(this, pl);
	}

	@Override
	public void setup() {
		
		// TODO Auto-generated method stub
	}

	@Override
	public void countDownMessages(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected HashMap<String, Object> getData() {
		return data;
	}

	@Override
	protected Plugin getPlugin() {
		return pl;
	}
	
	@EventHandler
	public void onPlayerJoinArenaEvent(PlayerJoinArenaEvent e) {
		pl.getLogger().info("EVENT WORKS :)");
	}


}
