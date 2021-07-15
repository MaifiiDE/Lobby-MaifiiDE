package de.maifii.lobby.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Lobby extends JavaPlugin {


    public static final String Prefix = "§6>> §eLobby §7";
    private static Lobby instance;

    private static ArrayList<Player> BuildMode;
    private static ArrayList<Player> WasserPartikel;
    private static ArrayList<Player> EnderPartikel;
    private static ArrayList<Player> HerzPartikel;


    @Override
    public void onEnable() {
        instance = instance;
        WasserPartikel = new ArrayList<Player>();
        EnderPartikel = new ArrayList<Player>();
        HerzPartikel = new ArrayList<Player>();
        BuildMode = new ArrayList<Player>();




    }

    @Override
    public void onDisable() {

    }





    //getters
    public static Lobby getInstance() {
        return instance;
    }

    public static ArrayList<Player> getWasserPartikel() {
        return WasserPartikel;
    }

    public static ArrayList<Player> getHerzPartikel() {
        return HerzPartikel;
    }

    public static ArrayList<Player> getEnderPartikel() {
        return EnderPartikel;
    }

    public static ArrayList<Player> getBuildMode() {
        return BuildMode;
    }

}




