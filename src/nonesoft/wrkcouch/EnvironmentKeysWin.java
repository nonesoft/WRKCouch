package nonesoft.develop_manager;

public enum EnvironmentKeysWin {
	HOME("HOME"),
	HOMEDRIVE("HOMEDRIVE"),
	HOMEPATH("HOMEPATH"),
	TEMP("TEMP"),
	PATH("Path"),
	USERNAME("USERNAME"),
	USERPROFILE("USERPROFILE"),
	UNKNOWN("UNKNOWN");

	private final String envValue;
	
	EnvironmentKeysWin(String key) {
		// necessary constructor
		this.envValue = key;
	}
	
	public String toString() {
		return this.envValue;
	}
};
