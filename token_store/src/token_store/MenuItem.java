package token_store;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuItem {
	
	private String item_type;
	private String item_name;
	private List<String> lore = new ArrayList<>();
	private String command_type;
	private String command_info;
	public ItemStack menu_icon;

	public MenuItem(String item_type, String item_name, String lore, String command_type, String command_info) {
		this.item_type = item_type;
		this.item_name = item_name;
		this.command_type = command_type;
		this.command_info = command_info;
		
		this.lore.add(ChatColor.GRAY + lore);
		
		this.menu_icon = createMenuIcom();
		
	}
	
	public ItemStack createMenuIcom() {
		
		String converted_item_type = item_type.toUpperCase().replace(" ", "_");		
		ItemStack icon = new ItemStack(Material.getMaterial(converted_item_type), 1);
		
		ItemMeta meta = icon.getItemMeta();
		meta.setDisplayName(item_name);
		meta.setLore(lore);
		icon.setItemMeta(meta);
		icon.setItemMeta(meta);
		
		return icon;
	}
}
