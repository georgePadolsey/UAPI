package UAPI.georgep.pokuit.Functions;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GenericFunctions {
	
	public static String seralizeLocation(Location loc) {
		LoggingFunctions.debug("turned "+loc+" into String");
		if(loc == null) {
			return null;
		} 
		return (loc.getWorld().getName() + "|" + loc.getX() + "|" + loc.getY() + "|" + loc.getZ());
	}
	
	public static Location turnStringIntoLocation(String str, Plugin pl) {
		LoggingFunctions.debug("Turned "+str+" Into Location");
		if(str == null) {
			return null;
		}
		String[] loc = str.split("\\|");
		 
	    World world = Bukkit.getWorld(loc[0].replaceAll("\\s",""));
	    Double x = (double) 0;
		Double y = (double) 0;
		Double z = (double) 0;
	    try {
			x = Double.parseDouble(loc[1].replaceAll("\\s",""));
			y = Double.parseDouble(loc[2].replaceAll("\\s",""));
			z = Double.parseDouble(loc[3].replaceAll("\\s",""));
			
	    } catch(NumberFormatException e) {
	    	LoggingFunctions.logError(e,pl);
	    }
	    return new Location(world, x, y, z);
	}

	
	
	/**
	 * Updates Arena Pages with new arenas!
	 */
	/*public void updateArenaPages() {
		debug("Updated Arena Pages");
		ArrayList<String> arenaInfo = new ArrayList<String>();
		for(arena arena: Main.arenas) {
			arenaInfo.add(ChatColor.GOLD+arena.getName()+ChatColor.BLUE+" - "+ChatColor.RED+"X: "+arena.getStartSpawn().getBlockX()+" Y: "+arena.getStartSpawn().getBlockY()+" Z: "+arena.getStartSpawn().getBlockZ()+"\n");
		}
		if(Main.arenaPages == null) {
			Main.arenaPages =new Pages(arenaInfo,5);
		} else {
			Main.arenaPages.changeData(arenaInfo);
			
		}
	}*/
	/**
	 * Reloads All Configs
	 */
	/*public void reloadAllConfigs() {
		debug("Reloaded all configs");
		plugin.reloadConfig();
		Main.configManager.reloadAllConfigs();
	}*/
	/**
	 * Gets player from string 
	 * @param
	 * 	p - Player Name
	 * @return
	 * 	The Player or if not online null
	 * @see
	 * 	Player
	 * @since 1.0
	 */
	public static Player getPlayerFromString(String p) {
		LoggingFunctions.debug("Got Player "+p+" from string");
		for(Player player :Bukkit.getServer().getOnlinePlayers()) {
			if(player.getName().equalsIgnoreCase(p)) {
				return player;
			}
		}
		return null;
	}
	/*public void addPlayerToArena(arena a, String p) {
		debug("Added player "+p+" To arena: "+a.getName());
		Player s = getPlayerFromString(p);
		if(s == null) {
			return;
		}
		for(arena temp:Main.arenas) {
			if(temp.containsPlayer(p)) {
				temp.removePlayer(p);
			}
		}
		a.addPlayer(p);
	}
	*/
	/**
	 * Hide's a Player to An Array Of Players
	 * @param player - Player's name
	 * @param op - Array Of Players Name's To hide the Player to
	 * @see Player
	 * @see #showPlayerToArrayOfPlayers(String, String[])
	 * @since 1.0
	 */
	public static void hidePlayerToArrayOfPlayers(String player, String[] op) {
		LoggingFunctions.debug("Just hiding "+player+" From "+op.toString());
		Player p = getPlayerFromString(player);
		for(String top : op) {
			getPlayerFromString(top).hidePlayer(p);
		}
	}
	
/*	public boolean playerIsInArena(String p) {
		for(arena a : Main.arenas) {
			if(a.containsPlayer(p)) {
				return true;
			}
		}
		return false;
	}
	public boolean playerIsInArena(String p, boolean b) {
		for(arena a : Main.arenas) {
			if(a.containsPlayer(p)) { 
				if(b && a.getArenaState() == arenaState.RUNNING) {
					return true;
				}
				if(!b && a.getArenaState() != arenaState.RUNNING) {
					return true;
				}
			}
		}
		return false;
	}
	*/
	/**
	 * Show's's a Player to An Array Of Players
	 * @param player - Player's name
	 * @param op - Array Of Players Name's To show the Player to
	 * @see Player
	 * @see #showPlayerToArrayOfPlayers(String, String[])
	 * @since 1.0
	 */
	public static void showPlayerToArrayOfPlayers(String player, String[] op) {
		LoggingFunctions.debug("Just showing "+player+" From "+op.toString());
		Player p = getPlayerFromString(player);
		for(String top : op) {
			getPlayerFromString(top).showPlayer(p);
		}
	}
	/*
	public HorseInfo randomHorseInfo() {
		debug("Got some random Horse info");
		return new HorseInfo(Horse.Style.values()[new Random().nextInt(Horse.Style.values().length)], Horse.Color.values()[new Random().nextInt(Horse.Color.values().length)]);
		
	}*/
	/**
	 * Get Entity From A UUID code, If you know the world that the entity is in I recomend {@link #getEntityFromUUID(UUID, String)}
	 * @param uuid
	 * 	- The UUID of an entity
	 * @return Entity
	 * 	- The Entity With That UUID
	 * @see #getEntityFromUUID(UUID, String)
	 * @since 1.0
	 */
	public static Entity getEntityFromUUID(UUID uuid) {
		LoggingFunctions.debug("Got entity from UUID");
		for(World w : Bukkit.getServer().getWorlds()) {
			for(Entity e: w.getEntities()){
			    if(e.getUniqueId() == uuid){
			            return e;
			    }
			}
		}
		return null;
	}
	/**
	 * Get Entity From A UUID code
	 * @param uuid
	 * 	- The UUID of an entity
	 * @return Entity
	 * 	- The Entity With That UUID
	 * @see #getEntityFromUUID(UUID, String)
	 * @since 1.0
	 */
	public static Entity getEntityFromUUID(UUID uuid, String world) {
		LoggingFunctions.debug("Got entity from UUID in world "+world);
		for(Entity e:Bukkit.getServer().getWorld(world).getEntities()){
		    if(e.getUniqueId() == uuid){
		            return e;
		    }
		}
		return null;
	}
	

	
	public static boolean blockInColumnIs(Location loc, Material mat, byte b) {
		
		Location startingLocation = loc;
		startingLocation.setY(255);
		
		for(int i = 0, l = 255; i < l; i++) {
			Location temp = startingLocation.subtract(0,i,0);
			if(temp.getBlock().getType() == mat &&
					temp.getBlock().getData() == b) {
				return true;
			}
		}
		
		return false;
	}
	public static boolean blockInColumnIs(Location loc, Material mat) {
		
		Location startingLocation = loc;
		startingLocation.setY(255);
		
		for(int i = 0, l = 255; i < l; i++) {
			Location temp = startingLocation.subtract(0,i,0);
			if(temp.getBlock().getType() == mat) {
				return true;
			}
		}
		
		return false;
	}
	public static boolean signInColumnIs(Location loc, String line1, String line2, String line3, String line4) {
		
		Location startingLocation = loc;
		startingLocation.setY(255);
		
		for(int i = 0, l = 255; i < l; i++) {
			Location temp = startingLocation.subtract(0,i,0);
			
			if(temp.getBlock().getType() == Material.SIGN ||
					temp.getBlock().getType() == Material.SIGN_POST ||
					temp.getBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign)temp.getBlock().getState();
				String[] lines = sign.getLines();
				if(lines[0].equalsIgnoreCase(line1) &&
						lines[1].equalsIgnoreCase(line2) &&
						lines[2].equalsIgnoreCase(line3) &&
						lines[3].equalsIgnoreCase(line4)) {
						return true;
				}
			}
		}
		
		return false;
	}
	public static boolean signInColumnIs(Location loc, String line1, String line2, String line3) {
			
		Location startingLocation = loc;
		startingLocation.setY(255);
		
		for(int i = 0, l = 255; i < l; i++) {
			Location temp = startingLocation.subtract(0,i,0);
			
			if(temp.getBlock().getType() == Material.SIGN ||
					temp.getBlock().getType() == Material.SIGN_POST ||
					temp.getBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign)temp.getBlock().getState();
				String[] lines = sign.getLines();
				if(lines[0].equalsIgnoreCase(line1) &&
						lines[1].equalsIgnoreCase(line2) &&
						lines[2].equalsIgnoreCase(line3)) {
						return true;
				}
			}
		}
		
		return false;
	}
	public static boolean signInColumnIs(Location loc, String line1, String line2) {
		
		Location startingLocation = loc;
		startingLocation.setY(255);
		
		for(int i = 0, l = 255; i < l; i++) {
			Location temp = startingLocation.subtract(0,i,0);
			
			if(temp.getBlock().getType() == Material.SIGN ||
					temp.getBlock().getType() == Material.SIGN_POST ||
					temp.getBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign)temp.getBlock().getState();
				String[] lines = sign.getLines();
				if(lines[0].equalsIgnoreCase(line1) &&
						lines[1].equalsIgnoreCase(line2)) {
						return true;
				}
			}
		}
		return false;
	}
	public static boolean signInColumnIs(Location loc, String line1) {
		
		Location startingLocation = loc;
		startingLocation.setY(255);
		
		for(int i = 0, l = 255; i < l; i++) {
			Location temp = startingLocation.subtract(0,i,0);
			
			if(temp.getBlock().getType() == Material.SIGN ||
					temp.getBlock().getType() == Material.SIGN_POST ||
					temp.getBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign)temp.getBlock().getState();
				String[] lines = sign.getLines();
				if(lines[0].equalsIgnoreCase(line1)) {
						return true;
				}
			}
		}
		
		return false;
	}
}
