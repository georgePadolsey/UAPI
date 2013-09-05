package UAPI.georgep.pokuit.Functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import UAPI.georgep.pokuit.enums.errorStrings;

public class LoggingFunctions {
	public static void debug(String str) {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+str);
	}
	public static void log(String s) {
		Bukkit.getServer().getConsoleSender().sendMessage(s);
	}
	public static void log(Object o[]) {
		//TODO
	}
	public static void logError(Exception e, Plugin plugin) {
		log(errorStrings.getErrorStringFromError(e)+plugin.getDescription().getFullName());
		log(ChatColor .RED+"This Was Not Caused By UAPI it was caused by "+ plugin.getDescription().getFullName());
		log(e.getStackTrace().toString());
	}
}
