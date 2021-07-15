package de.maifii.lobby.listeners;


// Code by Maifii 
// Zeit: 22:03 | 07 , 14
// Discord : MaifiiDE#3511


import de.maifii.lobby.main.Lobby;
import de.maifii.lobby.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class ConnectionListener implements Listener {

    public void onConnect(PlayerJoinEvent event) {
        Player spieler = (Player) event.getPlayer();

        spieler.getInventory().clear();

        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.COMPASS, "§6>> §eNavigator", 0);
        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BREWING_STAND_ITEM, "§6>> §ePartikel", 0);


    }

    public void onDisconnect(PlayerQuitEvent event) {
        Player spieler = (Player) event.getPlayer();

        Lobby.getBuildMode().remove(spieler);
        Lobby.getEnderPartikel().remove(spieler);
        Lobby.getHerzPartikel().remove(spieler);
        Lobby.getWasserPartikel().remove(spieler);
    }
}

