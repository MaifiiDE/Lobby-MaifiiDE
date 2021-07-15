package de.maifii.lobby.listeners;


// Code by Maifii 
// Zeit: 22:10 | 07 , 14
// Discord : MaifiiDE#3511


import de.maifii.lobby.main.Lobby;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {


    public void onMove(PlayerMoveEvent event) {
        Player spieler = (Player) event.getPlayer();

        if(Lobby.getEnderPartikel().contains(spieler)) {
            spieler.getWorld().playEffect(spieler.getLocation(), Effect.ENDER_SIGNAL, 1);
        }
        if(Lobby.getHerzPartikel().contains(spieler)) {
            spieler.getWorld().playEffect(spieler.getLocation(), Effect.HEART, 1);
        }

    }
}

