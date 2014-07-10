package uapi.georgep.pokuit.CinematicAPI;

import org.bukkit.entity.Player;

public class exampleCinematic extends Cinematic {
	
	private CinematicConfig cc = new CinematicConfig();
	
	public exampleCinematic() {
		CinematicManager.registerCinematic(this);
	}

//	@Override
//	public void runCinematic(Player p) {
//		
//	}
	
	public CinematicConfig getConfig() {
		return cc;
	}

	@Override
	public void runCinematic(Player p) {
		// TODO Auto-generated method stub
		
	}
	
}
