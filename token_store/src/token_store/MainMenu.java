package token_store;

import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainMenu extends Menu implements CommandExecutor{

	public MainMenu(String name, int size, Map<Integer, MenuItem> content) {
		super(name, size, content);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command c, String label, String[] args) {
		Player  p = (Player) sender;
		buildMenu(p);
		p.openInventory(gui);
		
		return true;
	}

}
