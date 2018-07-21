package br.com.yeventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {

	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent evento) {
		evento.setDeathMessage(null);
		if (evento.getEntity() instanceof Player && evento.getEntity().getKiller() instanceof Player) { 
			Player assassino = evento.getEntity().getKiller();
			Player vitima = evento.getEntity();
			Bukkit.broadcastMessage("§7[§c§lMortes§7] §fO Jogador §7" + assassino.getName() + " §fMatou §7" + vitima.getName());
		}
	}

}
