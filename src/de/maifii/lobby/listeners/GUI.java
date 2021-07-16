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
    private static String EffektGUI = "§6>> §ePartikel";
    private static String GadgetsGUI = "§6>> §eGadgets";


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
        ItemUtils.setItemInInventory(eff, Material.WATER_LILY, "§6>> §eWasser", 1);


        ItemUtils.setItemInInventory(eff, Material.BARRIER, "§6>> §eAblegen", 8);

        spieler.openInventory(eff);
    }

    public void openGadgetsGUI(Player spieler) {
        Inventory gad = Bukkit.createInventory(null, 9*1, GadgetsGUI);

        ItemUtils.setItemInInventory(gad, Material.ENDER_PEARL, "§6>> §eEnderperle", 0);

        spieler.openInventory(gad
        );
    }




@EventHandler
public void onGadgetOpen(PlayerInteractEvent event) {
        if(event.getItem() != null);
        if(event.getItem().getType() != Material.CHEST) return;
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            openGadgetsGUI(event.getPlayer());
        }
}


    @EventHandler
    public void onNavigatorOpen(PlayerInteractEvent event) {
        if(event.getItem() !=null);
        if (event.getItem().getType() != Material.COMPASS) return;
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            onNavigator(event.getPlayer());
        }
    }

    @EventHandler
    public void onEffektOpen(PlayerInteractEvent event){
        if(event.getItem() != null);
        if (event.getItem().getType() != Material.BREWING_STAND_ITEM) return;
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            openEffekt(event.getPlayer());
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
    public void onGadgetsClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player spieler = (Player) event.getWhoClicked();
        if(event.getInventory().getTitle().equals(GadgetsGUI)) {
            event.setCancelled(true);
            switch(event.getCurrentItem().getType()) {
                case ENDER_PEARL:
                    ItemUtils.setItemInInventory(spieler.getInventory(), Material.ENDER_PEARL, "§6>> §eEnderperle" ,4);
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
                    if(Lobby.getWasserPartikel().contains(spieler)) {
                        Lobby.getWasserPartikel().remove(spieler);
                    }
                    if(Lobby.getHerzPartikel().contains(spieler)) {
                        spieler.closeInventory();
                        spieler.sendMessage(Lobby.Prefix + "Du hast bereits diesen §ePartikel §7ausgewählt.");
                    }
                    else{
                        spieler.closeInventory();
                        spieler.sendMessage(Lobby.Prefix + "Du hast nun die §eHerz Partikel §7ausgewählt.");
                        Lobby.getHerzPartikel().add(spieler);
                    }
                    break;
                case WATER_LILY:
                    if(Lobby.getHerzPartikel().contains(spieler)) {
                        Lobby.getHerzPartikel().remove(spieler);
                    }
                    if(Lobby.getWasserPartikel().contains(spieler)) {
                        spieler.closeInventory();
                        spieler.sendMessage(Lobby.Prefix + "Du hast bereits diesen §ePartikel §7ausgewählt.");
                }
                    else{
                        spieler.closeInventory();
                        spieler.sendMessage(Lobby.Prefix + "Du hast nun die §eWasser Partikel §7ausgewählt.");
                        Lobby.getWasserPartikel().add(spieler);
                    }
                    break;
                case BARRIER:
                    Lobby.getEnderPartikel().remove(spieler);
                    Lobby.getHerzPartikel().remove(spieler);
                    Lobby.getWasserPartikel().remove(spieler);

                    spieler.closeInventory();
                    spieler.sendMessage(Lobby.Prefix + "Du hast §ealle §7deine Partikel abgelegt");
                    break;
            }
        }
    }

}

