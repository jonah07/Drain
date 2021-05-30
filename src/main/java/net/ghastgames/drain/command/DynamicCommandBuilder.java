package net.ghastgames.drain.command;

import net.ghastgames.drain.exception.NonStaticExecutorAlreadySetException;
import net.ghastgames.drain.exception.StaticExecutorAlreadySetException;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class DynamicCommandBuilder {
    private String command;
    private JavaPlugin plugin;
    private String permission;
    private String permissionErrorMessage;
    private String staticMessage;
    private String executionErrorMessage;
    private String conditionReturnedFalseMessage;
    private CommandExecutor executor;
    private List<CommandCondition> executionConditions;
    private boolean playerOnly;

    public DynamicCommandBuilder(String command, JavaPlugin plugin) {
        this.command = command;
        this.plugin = plugin;
        this.executionConditions = new ArrayList<>();
    }

    /**
     * Sets the permission for the command.
     *
     * @param permission The permission (for example: drain.use)
     */
    public DynamicCommandBuilder setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    /**
     * Sets the permission error message. You can use a custom
     * color code.
     *
     * @param message The colored message
     *                You can use your alternate color code.
     * @param colorCodeChar The color code char you want to use. If you
     *                      want to use § (the default one), consider using
     *                      setPermissionErrorMessage(String message).
     */
    public DynamicCommandBuilder setPermissionErrorMessage(String message, char colorCodeChar) {
        return setPermissionErrorMessage(ChatColor.translateAlternateColorCodes(colorCodeChar, message));
    }

    /**
     * Defines the message players get when they don't have the
     * specified permission.
     *
     * @param message The message. You can use color codes (using the § char).
     *                If you want to use your own color codes, consider using
     *                the other method.
     */
    public DynamicCommandBuilder setPermissionErrorMessage(String message) {
        this.permissionErrorMessage = message;
        return this;
    }

    /**
     * Adds an execution condition to the command. Every time a player tries to
     * execute the command, the given CommandCondition will be tested. If
     * CommandCondition#condition returns true, the command will be executed.
     * If it returns false, the command won't be executed and, if set, the
     * sender receives an error message.
     *
     * @param condition The condition.
     */
    public DynamicCommandBuilder addExecutionCondition(CommandCondition condition) {
        this.executionConditions.add(condition);
        return this;
    }

    /**
     * If set to true, the command can only be executed by players.
     * When the console tries to execute the command, it will get
     * an error message (Drain.COMMAND_PLAYER_ONLY)
     *
     * @param playerOnly Whether the command can be executed only by players or not
     */
    public DynamicCommandBuilder setPlayerOnly(boolean playerOnly) {
        this.playerOnly = playerOnly;
        return this;
    }

    /**
     * Sets a static message that will be sent to everyone who successfully executes
     * the command.
     *
     * @throws NonStaticExecutorAlreadySetException If you already set an executor, it will throw
     * a NonStaticExecutorAlreadyDefinedException, because there can only be a static message or an executor.
     *
     * @param message The message. Colors are supported, as long as you use § as the color code char.
     */
    public DynamicCommandBuilder setStaticMessage(String message) {
        if(executor == null) {
            this.staticMessage = message;
        } else {
            throw new NonStaticExecutorAlreadySetException();
        }
        return this;
    }

    /**
     * Sets the command executor. Attention: Don't import Bukkit's command executor!
     *
     * @param executor The executor
     */
    public DynamicCommandBuilder setExecutor(CommandExecutor executor) {
        if(this.staticMessage == null) {
            this.executor = executor;
        } else {
            throw new StaticExecutorAlreadySetException();
        }
        return this;
    }
    
    /**
     * When the condition returns false, this message will be sent to the player.
     * 
     * @param conditionReturnedFalseMessage The message. Colors are supported, as long as you use § as the color code char.
     */
    public DynamicCommandBuilder setConditionReturnedFalseMessage(String conditionReturnedFalseMessage) {
        this.conditionReturnedFalseMessage = conditionReturnedFalseMessage;
        return this;
    }

    /**
     * Adds an option for tab complete to complete
     *
     * Example:
     * /mycommand test
     *
     * The option would be "test"
     *
     * @param option The tabcomplete option
     */
    public DynamicCommandBuilder addTabCompleteOption(String option) {

    }

    /**
     * Builds and registers the command.
     */
    public DynamicCommandBuilder build() {
        DrainCommand command = new DrainCommand();
        command.setCommand(this.command);
        command.setStaticResponse(this.staticMessage);
        command.setPermission(this.permission);
        command.setPermissionErrorMessage(this.permissionErrorMessage);
        command.setConditionReturnedFalseMessage(this.conditionReturnedFalseMessage);
        command.setDrainExecutor(this.executor);
        command.setPlayerOnly(playerOnly);
        command.setDynamicCommand(true);

        BukkitCommandRegistry.registerCommand(command, this.plugin);

        return this;
    }
}
