package com.enderqura.ohub.events;
 
import java.util.ArrayList;
 
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
public class HidePlayers implements Listener {
       
        private ArrayList<String> playersHiden;
       
               
        }
       
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent e) {
 
                this.playersHiden = new ArrayList<String>();
 
 
                if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
                        return;
                }
               
                if (e.getItem().getType() != Material.TORCH) {
                        return;
                }
               
                if (
                                !e.getItem().hasItemMeta() ||
                                !e.getItem().getItemMeta().hasDisplayName() ||
                                !e.getItem().getItemMeta().getDisplayName().equals("Hide players")
                ) {
                        return;
                }
               
                if (playersHiden.contains(e.getPlayer().getName())) {
                        playersHiden.remove(e.getPlayer().getName());
                       
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                                if (p != e.getPlayer()) {
                                        e.getPlayer().showPlayer(p);                                  
                                }
                        }
                }
               
                else { // Turning it on.
                        playersHidden.add(e.getPlayer().getName());
                       
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                                if (p != e.getPlayer()) {
                                        e.getPlayer().hidePlayer(p);
                                }
                        }
                }
        }
       
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e) { // This could be expensive to run every time someone joins.
                // Check if the player already has a clock, or just don't do this here (maybe when the player joins for the first time).
                ItemStack playerHide = new ItemStack(Material.TORCH, 1);
               
                ItemMeta playerHideMeta = playerHide.getItemMeta();
                playerHideMeta.setDisplayName("Hide Players");
                playerHide.setItemMeta(playerHideMeta);
               
                e.getPlayer().getInventory().addItem(playerHide);
               
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        if (p != e.getPlayer()) {
                                if (playersHidden.contains(p.getName())) {
                                        p.hidePlayer(e.getPlayer()); // If they are currently using the clock, hide the new player.
                                }
                               
                                else {
                                        p.showPlayer(e.getPlayer()); // Else, show the new player.
                                }
                        }
                }
        }
}
