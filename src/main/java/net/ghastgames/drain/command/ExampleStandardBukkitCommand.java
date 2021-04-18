package net.ghastgames.drain.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExampleStandardBukkitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            if(commandSender.hasPermission("test")) {
                ((Player) commandSender).setHealth(20);
                return true;
            } else {
                commandSender.sendMessage("§cYou are not allowed to do this!");
                return false;
            }
        } else {
            commandSender.sendMessage("§cThis command is player-only!");
            return false;
        }
    }
}
