package uapi.georgep.pokuit.Objects;

import org.bukkit.Location;
import org.bukkit.block.Block;

import uapi.georgep.pokuit.Functions.GenericFunctions;

public class BlockIterator {
	
	private BlockIteratorEventHandler handler;
	private Location min;
	private Location max;
	
	public BlockIterator(Location min, Location max, BlockIteratorEventHandler e) {
		iterateThroughBlocks();
		this.min = min;
		this.max = max;
	}
	
	private void iterateThroughBlocks() {
		for(int x = min.getBlockX(); x <= max.getBlockX(); x++) { // Loop 1 for the X
	        for(int y = min.getBlockY(); y <= max.getBlockY(); y++) {// Loop 2 for the Y
	            for(int z = min.getBlockZ(); z <= max.getBlockZ();z++) {// Loop 3 for the Z
	            	Block b = min.getWorld().getBlockAt(x,y,z);
	            	if (GenericFunctions.blockIsWithinMinMax(b.getLocation(), min, max)) {
	            		//Just double checking its within min max 
	            		//can never be to careful!
	            		
	            		handler.onBlockIteratorEvent(new BlockIteratorEvent(b));
	            	}
	            }
	        }
		}
		
	}
	
	public interface BlockIteratorEventHandler {
		public void onBlockIteratorEvent(BlockIteratorEvent event);      
	}
	
	public class BlockIteratorEvent {
		
		private Block b;
		
		public BlockIteratorEvent(Block b) {
			this.b = b;
		}
		
		public Block getBlock() {
			return b;
		}
	}
}
