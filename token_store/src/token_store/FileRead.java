package token_store;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class FileRead {

	
	private Main plugin;
	private FileConfiguration dataConfig = null;
	private File configFile = null;
	
	
	public FileRead(Main m) {
		this.plugin = m;
	}
	
	public void reloadConfig() {
		if(this.configFile == null) {
			//create file
			this.configFile = new File(this.plugin.getDataFolder(), "shop_items.yml");
			
		}
		
		this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
		
		InputStream defaultStream = this.plugin.getResource("shop_items.yml");
		if(defaultStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
			this.dataConfig.setDefaults(defaultConfig);
		}
		
	}
	
	public FileConfiguration getConfig() {
		if(this.dataConfig == null) reloadConfig(); //creating one as it does not exist yet
		return this.dataConfig;
	}
}