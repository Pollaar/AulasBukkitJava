package br.com.ycmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comandos implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) { //Verifica se o sender não é um Player
			sender.sendMessage("§cVoce nao e um Player"); 
		} else {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("comando")) {
				if (!p.hasPermission("ydev.cmd")) { //Caso o jogador não tenha a permissão
					p.sendMessage("§cVocê não possui permissão!");
				} else {
					p.sendMessage("§aVocê executou o comando §c" + cmd.getName());
				}
			}
		}

		return false;
	}

}
