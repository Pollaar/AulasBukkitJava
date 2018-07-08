package br.com.comandoaula;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {
	
	@Override
	public void onEnable() {
		getCommand("teste").setExecutor(this); //Resgata o Comando e seta classe executora. "this" significa essa !
	}
	
	@Override
	public void onDisable() {

	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("teste")) {  //Verifica se o nome do comando é igual a "teste" ignorando se tem letras Maiusculas
			Player p = (Player) sender; //Atribui a p o valor sender
			p.sendMessage("");
			p.sendMessage("§aVocê usou o comando: §c" + command.getName()); //Envia para o jogador executor do comando uma mensagem
			p.sendMessage("");
		}
		return false;
	}

}
