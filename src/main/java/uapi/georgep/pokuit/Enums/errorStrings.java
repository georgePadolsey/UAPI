package uapi.georgep.pokuit.Enums;

import org.bukkit.ChatColor;

public enum errorStrings {
	
	NUMBER_FORMAT_EXCEPTION(ChatColor.RED+"Number Format Exception Occured. Please pass to the plugin developer of ", NumberFormatException.class);
	
	String str;
	Class<? extends Throwable> e;
	
	errorStrings(String str, Class<? extends Throwable> e) {
		this.str = str;
		this.e = e;
	}
	
	@Override
	public String toString() {
		return str;
	}
	
	public Class<? extends Throwable> getThrowableClass() {
		return e;
	}
	public static String getErrorStringFromError(Throwable exc) {
		for(errorStrings err : errorStrings.values()) {
			  if(exc.getClass() == err.getThrowableClass()) {
				  return err.toString();
			  }
		}
		return null;
	}
}
