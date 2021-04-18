package net.ghastgames.drain.command;

import org.bukkit.command.CommandSender;

public class CommandExecutionData {
    private final CommandSender sender;
    private final String[] args;

    public CommandExecutionData(CommandSender sender, String... args) {
        this.sender = sender;
        this.args = args;
    }

    public CommandSender getSender() {
        return sender;
    }

    public String[] getArgs() {
        return args;
    }
}
