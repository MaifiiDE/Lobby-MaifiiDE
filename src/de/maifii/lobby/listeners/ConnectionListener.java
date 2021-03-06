package de.maifii.lobby.listeners;


// Code by Maifii 
// Zeit: 22:03 | 07 , 14
// Discord : MaifiiDE#3511


import de.maifii.lobby.main.Lobby;
import de.maifii.lobby.utils.ItemUtils;
import de.maifii.lobby.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class ConnectionListener implements Listener {


    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();

        player.getInventory().clear();

        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.COMPASS, "§6>> §eNavigator", 0);
        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BREWING_STAND_ITEM, "§6>> §ePartikel", 2);
        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BARRIER, "§6>> §eGadget auswählen!", 4);
        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.CHEST, "§6>> §eGadgets", 6);

        LocationUtils.useLocation(event.getPlayer(), "Spawn");

        event.setJoinMessage(null);
    }


    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {
        Player player = (Player) event.getPlayer();

        Lobby.getBuildMode().remove(player);
        Lobby.getEnderParticles().remove(player);
        Lobby.getHeartParticles().remove(player);
        Lobby.getWaterParticles().remove(player);

        event.setQuitMessage(null);
    }
}

