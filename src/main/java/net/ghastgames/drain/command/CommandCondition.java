package net.ghastgames.drain.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This interface is used to build a command
 * using the DynamicCommandBuilder with a condition.
 * <br>
 * Used in the DynamicCommandBuilder#addExecutionCondition()
 * method.
 */
public interface CommandCondition {

    /**
     * @param data Information about the execution
     * @return Whether the command should be executed or not.
     */
    boolean condition(CommandExecutionData data);
}
