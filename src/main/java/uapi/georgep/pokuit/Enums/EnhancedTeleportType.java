package uapi.georgep.pokuit.Enums;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import uapi.georgep.pokuit.EnhancedTeleportAPI.EnhancedTeleportMode;
import uapi.georgep.pokuit.EnhancedTeleportAPI.MedivalEnhancedTeleportMode;

public enum EnhancedTeleportType {
	
	Medival(MedivalEnhancedTeleportMode.class);
	
	Class <?> clazz;
	
	EnhancedTeleportType(Class<? extends EnhancedTeleportMode> clazz) {
		try {
			clazz.getConstructor(Plugin.class).newInstance(Bukkit.getServer().getPluginManager().getPlugin("UAPI"));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
