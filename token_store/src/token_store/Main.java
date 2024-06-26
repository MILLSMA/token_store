package token_store;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	//public FileRead shop_data;
	
	public FileRead shop_data;
	FileConfiguration contents;

	@Override
	public void onEnable() {
		this.shop_data = new FileRead(this);
		contents = shop_data.getConfig();
		
		RedeemMenu menu = new RedeemMenu(this, contents);
		
		

		Map<Integer, MenuItem> main_dict = new HashMap<>(); 
		main_dict.put(11, new MenuItem("diamond", "Survival Store", "Buy survival items with diamonds", null, null));
		main_dict.put(15, new MenuItem("gold block", "Token Store", "Buy speciality items with tokens", null, null));

		MainMenu main_menu_gui = new MainMenu("Main", 27, main_dict);
		
		
		this.getCommand("redeem").setExecutor(menu);
		this.getCommand("test").setExecutor(main_menu_gui);
		this.getServer().getPluginManager().registerEvents(menu, this);
		
		
	}
	
	@Override
	public void onDisable() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equals("hello")) {
			if(sender instanceof Player) {
				//player
				Player p = (Player)sender;
				if(p.hasPermission("hello.use")) {
					p.sendMessage(ChatColor.MAGIC + "Hello!");
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6This is a &7test"));
				}else {
					p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "NO PERMISSION!");
				}
				return true;
			}else {
				//console
				sender.sendMessage("Hello Console");
				return true;
			}
		}
		
		return false;
	}
	
}
