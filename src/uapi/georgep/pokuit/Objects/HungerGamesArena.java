package uapi.georgep.pokuit.Objects;

import java.util.HashMap;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class HungerGamesArena extends Arena implements Listener{
	
	public HungerGamesArena(Plugin pl, HashMap<String, Object> data) {
		super(pl, data);
		pl.getServer().getPluginManager().registerEvents(this, pl);
	}

	@Override
	public void setup() {
		
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String countDownMessages(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
