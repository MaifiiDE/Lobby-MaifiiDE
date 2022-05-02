package de.maifii.lobby.listeners;



// Code by Maifii 
// Zeit: 22:37 | 07 , 14
// Discord : MaifiiDE#3511


import de.maifii.lobby.main.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;


public class BlockListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = (Player) event.getPlayer();

        if(!Lobby.getBuildMode().contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = (Player) event.getPlayer();

        if(!Lobby.getBuildMode().contains(player)) {
            event.setCancelled(true);
        }
    }
}

