package token_store;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RedeemMenu implements CommandExecutor, Listener{
	Main plugin;
	FileConfiguration config;

	public Inventory shop_main;
	
	public RedeemMenu(Main m, FileConfiguration data) {
		this.plugin = m;
		this.config = data;
		
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command c, String label, String[] args) {
		
		Player  p = (Player) sender;
		buildMainMenu(p);
		p.openInventory(shop_main);
		
		return true;

	}
	
	public void buildMainMenu(Player p) {
		shop_main = Bukkit.createInventory(p, 45, ChatColor.LIGHT_PURPLE + "Token Shop");
		shop_main.setItem(1, new MenuItem("diamond sword", "item_1", "test_lore", null, null).menu_icon);
    }
	/**
	 * Do not pull items out of the shop inventory
	 * @param e: event called
	 */
	@EventHandler
	public void onClick(InventoryClickEvent e) { 
		System.out.println("Shop click detected!");
		if(!(e.getView().getTitle().contains("Token Shop")))return;
		System.out.println(e.getSlotType());
		System.out.println(e.getSlot());
		System.out.println(e.getRawSlot());
		e.setCancelled(true);//this means the gui wont be affected
		

	}
	

	
	
}