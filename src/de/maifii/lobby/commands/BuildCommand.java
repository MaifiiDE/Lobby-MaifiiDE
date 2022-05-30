package de.maifii.lobby.commands;

import de.maifii.lobby.main.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player) {
            if(player.hasPermission("lobby.build")) {
                if(args.length == 0) {
                    if(Lobby.getBuildMode().contains(player)) {
                        Lobby.getBuildMode().remove(player);
                        player.sendMessage(Lobby.Prefix+ "Du wurdest aus dem §eBuild-Modus §7entfernt.");
                    }
                    else {
                        Lobby.getBuildMode().add(player);
                        player.sendMessage(Lobby.Prefix + "Du wurdest in den §eBuild-Modus §7hinzugefügt.");

                    }
                }
                else{
                    player.sendMessage(Lobby.Prefix + "Bitte benutze §e/build§7.");
                }
            }
        }
        return false;
    }
}
