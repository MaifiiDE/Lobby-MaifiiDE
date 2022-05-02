package de.maifii.lobby.main;

import de.maifii.lobby.commands.BuildCommand;
import de.maifii.lobby.commands.SetCommand;
import de.maifii.lobby.listeners.*;
import de.maifii.lobby.listeners.Gadgets.EnderPearlListener;
import net.minecraft.server.v1_8_R3.GameRules;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Lobby extends JavaPlugin {


    public static final String Prefix = "§6>> §eLobby §7";
    private static Lobby instance;

    private static ArrayList<Player> buildMode;
    private static ArrayList<Player> waterParticles;
    private static ArrayList<Player> enderParticles;
    private static ArrayList<Player> heartParticles;


    public void register(PluginManager pluginManager) {
        pluginManager.registerEvents(new BlockListener(), this);
        pluginManager.registerEvents(new GUI(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new ProtectListener(), this);
        pluginManager.registerEvents(new ConnectionListener(), this);
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new EnderPearlListener(), this);

        getCommand("set").setExecutor(new SetCommand());
        getCommand("build").setExecutor(new BuildCommand());
    }

    @Override
    public void onEnable() {

        this.register(Bukkit.getPluginManager());

        instance = instance;
        waterParticles = new ArrayList<Player>();
        enderParticles = new ArrayList<Player>();
        heartParticles = new ArrayList<Player>();
        buildMode = new ArrayList<Player>();
    }

    @Override
    public void onDisable() {

    }





    //getters
    public static Lobby getInstance() {
        return instance;
    }

    public static ArrayList<Player> getWaterParticles() {
        return waterParticles;
    }

    public static ArrayList<Player> getHeartParticles() {
        return heartParticles;
    }

    public static ArrayList<Player> getEnderParticles() {
        return enderParticles;
    }

    public static ArrayList<Player> getBuildMode() {
        return buildMode;
    }

}




