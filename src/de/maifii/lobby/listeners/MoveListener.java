package de.maifii.lobby.listeners;


// Code by Maifii 
// Zeit: 22:10 | 07 , 14
// Discord : MaifiiDE#3511


import de.maifii.lobby.main.Lobby;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();

        if(Lobby.getEnderParticles().contains(player)) {
            player.getWorld().playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 1);
        }
        if(Lobby.getHeartParticles().contains(player)) {
            player.getWorld().playEffect(player.getLocation(), Effect.HEART, 1);
        }
        if(Lobby.getWaterParticles().contains(player)) {
            player.getWorld().playEffect(player.getLocation(), Effect.WATERDRIP, 1);
        }

    }
}

