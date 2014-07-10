package uapi.georgep.pokuit.Objects;

import java.util.HashMap;

public final class HashMapConfig {
	
	public static HashMap<String, Object> handle(HashMap<String, Object> hm, String[] oa) throws IllegalArgumentException {
		
		for(String o : oa) {
			if(!hm.containsKey(o)) {
				throw new IllegalArgumentException("Not enough Arguments in the hashmap");
			}
		}
		
		return hm;
	}
	
}
