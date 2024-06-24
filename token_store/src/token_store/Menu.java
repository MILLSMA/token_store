package token_store;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class Menu  implements Listener{
	
	public String name;
	public int size;
	public Map<Integer, MenuItem> content;
	public Inventory gui;

	public Menu(String name, int size, Map<Integer, MenuItem> content) {
		
		this.name = name;
		this.size = size;
		this.content = content;
		
	}
	
	public void buildMenu(Player p) {
		gui = Bukkit.createInventory(p, this.size, ChatColor.LIGHT_PURPLE + this.name);
		
		content.forEach((key, value) ->{
			
			gui.setItem(key, value.menu_icon);
		});
    }
	
	/**
	 * Do not pull items out of the shop inventory
	 * @param e: event called
	 */
	@EventHandler
	public void onClick(InventoryClickEvent e) { 
		System.out.println("Shop click detected!");
		if(!(e.getView().getTitle().contains(this.name)))return;
		System.out.println(e.getSlot());
		System.out.println(e.getRawSlot());
		e.setCancelled(true);//this means the gui wont be affected
		
	}
}
