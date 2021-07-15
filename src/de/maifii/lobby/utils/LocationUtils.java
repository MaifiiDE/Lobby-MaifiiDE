package de.maifii.lobby.utils;

import de.maifii.lobby.main.Lobby;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;


public class LocationUtils {
    public static void setLocation(String name, Player spieler){
        File ordner = new File("plugins//Lobby//");
        File file = new File("plugins//Lobby//" + name + ".yml");

        if(!ordner.exists()){
            ordner.mkdir();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Location loc = spieler.getLocation();

        cfg.set("X", loc.getBlockX());
        cfg.set("Y", loc.getBlockY());
        cfg.set("Z", loc.getBlockZ());
        cfg.set("Welt", loc.getWorld().getName());
        cfg.set("Yaw", loc.getYaw());
        cfg.set("Pitch", loc.getPitch());

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void useLocation(Player spieler, String name){
        File file = new File("plugins//Lobby//" + name + ".yml");

        if(!file.exists()){
            spieler.sendMessage(Lobby.Prefix + "Diese §eLocation §7wurde nicht gefunden.");
        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        World welt = Bukkit.getWorld(cfg.getString("Welt"));
        double yaw = cfg.getDouble("Yaw");
        double pitch = cfg.getDouble("Pitch");

        spieler.teleport(new Location(welt, cfg.getDouble("X"), cfg.getDouble("Y"), cfg.getDouble("Z"), (float) yaw, (float) pitch));
        spieler.getWorld().playEffect(spieler.getLocation(), Effect.SMOKE, 1);
        spieler.playSound(spieler.getLocation(), Sound.NOTE_PLING, 1, 1);
    }

}