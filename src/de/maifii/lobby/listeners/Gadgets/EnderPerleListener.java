package de.maifii.lobby.listeners.Gadgets;

// Code by Maifii 
// Zeit: 06:17 | 07 , 16
// Discord : MaifiiDE#3511


import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class EnderPerleListener implements Listener {


    @EventHandler
    public void onEnderPerle(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.ENDER_PEARL) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Player spieler = event.getPlayer();
                event.setCancelled(true);

                EnderPearl enderPearl = spieler.launchProjectile(EnderPearl.class);
                enderPearl.setPassenger(spieler);
            }
        }
    }
}