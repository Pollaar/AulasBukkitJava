package br.com.ymenubr;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.COMPASS && e.getAction() == Action.RIGHT_CLICK_AIR) {
			Inventory inv = Bukkit.createInventory(null, 9*6, "§8§l» §a§lMenu"); 
			ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
			item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§6§lClique");
			item.setItemMeta(meta);
			inv.setItem(13, item);
			p.openInventory(inv);
		}
	}
	
	@EventHandler
	public void onInteract(InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase("§8§l» §a§lMenu")) {
			e.setCancelled(true);
			if (e.getCurrentItem().hasItemMeta()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lClique")) {
					e.getWhoClicked().sendMessage("§aVocê clicou");
					e.getWhoClicked().closeInventory();
				}
			}
		}
	}
	

}
