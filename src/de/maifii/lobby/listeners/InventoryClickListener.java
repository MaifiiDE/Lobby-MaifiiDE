package de.maifii.lobby.listeners;

// Code by Maifii 
// Zeit: 23:04 | 07 , 15
// Discord : MaifiiDE#3511


import de.maifii.lobby.main.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class InventoryClickListener implements Listener {



    @EventHandler
    public void onNormalClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(!Lobby.getBuildMode().contains(player))
        event.setCancelled(true);
    }
}

