package de.maifii.lobby.listeners;



// Code by Maifii 
// Zeit: 22:40 | 07 , 14
// Discord : MaifiiDE#3511


import de.maifii.lobby.main.Lobby;
import de.maifii.lobby.utils.ItemUtils;
import de.maifii.lobby.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;


public class GUI implements Listener {

    private static String NavigatorGUI = "§6>> §eNavigator";
    private static String EffektGUI = "§6>> §eEffekte";


    public void onNavigator(Player spieler) {
        Inventory nav = Bukkit.createInventory(null, 54, NavigatorGUI);

        ItemUtils.setItemInInventory(nav, Material.GRASS, "§6>> §eSpawn", 31);


        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 9);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 0);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 1);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 2);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 6);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 7);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 8);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 17);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 36);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 45);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 46);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 47);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 51);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 52);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 53);
        ItemUtils.setItemInInventory(nav, Material.BARRIER, " ", 44);

        spieler.openInventory(nav);
    }


    public void openEffekt(Player spieler) {
        Inventory eff = Bukkit.createInventory(null, 9*1, EffektGUI);

        ItemUtils.setItemInInventory(eff, Material.RED_ROSE, "§6>> §eHerzen", 0 );


        spieler.openInventory(eff);
    }




    @EventHandler
    public void onNavigatorOpen(PlayerInteractEvent event) {
        if(event.getItem().getType() != Material.COMPASS) return;
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            onNavigator(event.getPlayer());
        }
    }

    @EventHandler
    public void onNavigatorClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player spieler = (Player) event.getWhoClicked();
        if(event.getInventory().getTitle().equals(NavigatorGUI)) {
            event.setCancelled(true);
            switch(event.getCurrentItem().getType()) {
                case GRASS:
                    LocationUtils.useLocation((Player) event.getWhoClicked(), "Spawn");
                    break;
            }
        }
    }

    @EventHandler
    public void OnEffekteClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player spieler = (Player) event.getWhoClicked();
        if(event.getInventory().getTitle().equals(EffektGUI)) {
            event.setCancelled(true);
            switch(event.getCurrentItem().getType()) {
                case RED_ROSE:
                    if(Lobby.getHerzPartikel().contains(spieler)) {
                        spieler.closeInventory();
                        spieler.sendMessage(Lobby.Prefix + "Du hast bereits diesen §ePartikel §7ausgewählt.");
                    }
                    else{
                        spieler.closeInventory();
                        spieler.sendMessage(Lobby.Prefix + "Du hast nun die §Herz Partikel §7ausgewählt.");
                        Lobby.getHerzPartikel().add(spieler);
                    }
                    break;
            }
        }
    }




}
