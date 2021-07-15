package de.maifii.lobby.commands;

import de.maifii.lobby.main.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player spieler = (Player) sender;
        if(sender instanceof Player) {
            if(spieler.hasPermission("lobby.build")) {
                if(args.length == 0) {
                    if(Lobby.getBuildMode().contains(spieler)) {
                        Lobby.getBuildMode().remove(spieler);
                        spieler.sendMessage(Lobby.Prefix+ "Du wurdest aus dem §eBuild-Modus §7entfernt.");
                    }
                    else {
                        Lobby.getBuildMode().add(spieler);
                        spieler.sendMessage(Lobby.Prefix + "Du wurdest in den §eBuild-Modus §7hinzugefügt.");

                    }
                }
                else{
                    spieler.sendMessage(Lobby.Prefix + "Bitte benutze §e/build§7.");
                }
            }
            spieler.sendMessage(Lobby.Prefix + "Dazu hast du §ekeine §7Berechtigung.");
        }
        return false;
    }
}
