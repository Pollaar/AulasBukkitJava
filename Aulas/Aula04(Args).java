package br.com.ycmdargs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {
	
	@Override
	public void onEnable() {
		getCommand("yt").setExecutor(this);
	}
	
	@Override
	public void onDisable() {

	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player) ) {
			sender.sendMessage("§aSomente Jogadores !");
		} else {
			if (command.getName().equalsIgnoreCase("yt")) {  //   /yt ver tag
				Player p = (Player) sender;
				if (args.length == 0) {
					p.sendMessage("§7» §aUse: /yt ver tag");
				} else if (args.length > 0) {
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("ver")) {
							p.sendMessage("§7» §aVocê precisa colocar: 'ver tag'");
						}
					} else if (args.length == 2) {
						if (args[0].equalsIgnoreCase("ver") && args[1].equalsIgnoreCase("tag")) {
							p.sendMessage("§7» §aVeja a Tag: §f§l[YT]");
						}
					}
				}
			}
		}
		return false;
	}

}
