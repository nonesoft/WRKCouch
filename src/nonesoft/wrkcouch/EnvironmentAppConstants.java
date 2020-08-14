package nonesoft.wrkcouch;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentAppConstants {
	
	private Map<EnvironmentKeys, String> environmentDef;	
	private Map<String, String> environmentVars;
	static volatile String allAppConstants;
	
	public Map<EnvironmentKeys, String> getEnvironmentDef() {
		if (this.environmentDef == null) {
			this.environmentDef = new HashMap<EnvironmentKeys, String>();
		}
		return environmentDef;
	}

	public void setEnvironmentDef(Map<EnvironmentKeys, String> environmentDef) {
		this.environmentDef = environmentDef;
	}
		
	public EnvironmentAppConstants() {
				
		if (this.environmentVars == null) {
			this.environmentVars = System.getenv();	
		}
		
		//windows environment
		if (System.getProperty("os.name").startsWith("Windows")) {
			//HOME
			String var = environmentVars.get(EnvironmentKeysWin.HOME.toString());
			getEnvironmentDef().put(EnvironmentKeys.HOME, var);
			//HOMEDRIVE
			var = environmentVars.get(EnvironmentKeysWin.HOMEDRIVE.toString());
			getEnvironmentDef().put(EnvironmentKeys.HOMEDRIVE, var);
			//HOMEPATH
			var = environmentVars.get(EnvironmentKeysWin.HOMEDRIVE.toString()) + environmentVars.get(EnvironmentKeysWin.HOMEPATH.toString());
			getEnvironmentDef().put(EnvironmentKeys.HOMEPATH, var);
			//TEMP
			var = environmentVars.get(EnvironmentKeysWin.TEMP.toString());
			getEnvironmentDef().put(EnvironmentKeys.TEMP, var);
			//PATH
			var = environmentVars.get(EnvironmentKeysWin.PATH.toString());
			getEnvironmentDef().put(EnvironmentKeys.PATH, var);
			//USERNAME
			var = environmentVars.get(EnvironmentKeysWin.USERNAME.toString());
			getEnvironmentDef().put(EnvironmentKeys.USERNAME, var);
			//USERPROFILE
			var = environmentVars.get(EnvironmentKeysWin.USERPROFILE.toString());
			getEnvironmentDef().put(EnvironmentKeys.USERPROFILE, var);			
		}
		//Linux environment
		else {
			//HOME
			String var = environmentVars.get(EnvironmentKeysLx.HOME.toString());
			getEnvironmentDef().put(EnvironmentKeys.HOME, var);
			//HOMEDRIVE
			var = environmentVars.get(EnvironmentKeysLx.HOMEDRIVE.toString());
			getEnvironmentDef().put(EnvironmentKeys.HOMEDRIVE, var);
			//HOMEPATH
			var = environmentVars.get(EnvironmentKeysLx.HOMEPATH.toString());
			getEnvironmentDef().put(EnvironmentKeys.HOMEPATH, var);
			//TEMP
			var = environmentVars.get(EnvironmentKeysLx.TEMP.toString());
			getEnvironmentDef().put(EnvironmentKeys.TEMP, var);
			//PATH
			var = environmentVars.get(EnvironmentKeysLx.PATH.toString());
			getEnvironmentDef().put(EnvironmentKeys.PATH, var);
			//USERNAME
			var = environmentVars.get(EnvironmentKeysLx.USERNAME.toString());
			getEnvironmentDef().put(EnvironmentKeys.USERNAME, var);
			//USERPROFILE
			var = environmentVars.get(EnvironmentKeysLx.USERPROFILE.toString());
			getEnvironmentDef().put(EnvironmentKeys.USERPROFILE, var);	
		}		
	}
	
	public String getAppEnvValue(EnvironmentKeys inKey) {
		if (this.environmentDef.containsKey(inKey)) {
			return this.environmentDef.get(inKey);
		}
		
		return "";
	}
	
	public void setAppEnvValue(EnvironmentKeys inKey, String value) {
		this.environmentDef.put(inKey, value);
	}

	public String getAllAppConstants() {
		allAppConstants = "";
		this.environmentDef.forEach( (k, v) -> { allAppConstants += String.format("%s = %s", k, v) + System.lineSeparator(); } );
		return allAppConstants;
	}
}




