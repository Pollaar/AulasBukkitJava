package br.com.ycmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comandos implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) { //Verifica se o sender n�o � um Player
			sender.sendMessage("�cVoce nao e um Player"); 
		} else {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("comando")) {
				if (!p.hasPermission("ydev.cmd")) { //Caso o jogador n�o tenha a permiss�o
					p.sendMessage("�cVoc� n�o possui permiss�o!");
				} else {
					p.sendMessage("�aVoc� executou o comando �c" + cmd.getName());
				}
			}
		}

		return false;
	}

}
