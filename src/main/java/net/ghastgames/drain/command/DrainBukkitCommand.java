package net.ghastgames.drain.command;

import net.ghastgames.drain.annotations.PluginCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DrainBukkitCommand implements CommandExecutor {

    @PluginCommand(
        response = "§aThis server is using §eDrain §aby EinGriefer §7§o\ngithub.com/GhastGames/Drain"
    )
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
