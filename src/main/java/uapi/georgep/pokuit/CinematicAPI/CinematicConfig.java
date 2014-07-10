package uapi.georgep.pokuit.CinematicAPI;

public class CinematicConfig {
	
	private Boolean useResourcePack = false;
	private Boolean forceResourcePack = false;
	private String resourcePack = "";
	
	public CinematicConfig() {};
	
	public boolean isUsingResourcePack() {
		return useResourcePack;
	}
	
	public boolean isForcingResourcePack() {
		return forceResourcePack;
	}
	
	public String getResourcePackURL() {
		return resourcePack;
	}
	
	public void setResourcePack(String resourcePackURL, Boolean Force) {
		this.useResourcePack = true;
		this.forceResourcePack = Force;
		this.resourcePack = resourcePackURL;
	}
	
	
}
