package net.ghastgames.drain.command;

import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

public class DrainCommand {
    /*
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
     */

    private String command;
    private List<String> tabcomplete;
    private String permission;
    private CommandExecutor executor;
    private String permissionErrorMessage;
    private String staticResponse;
    private String conditionReturnedFalseMessage;
    private net.ghastgames.drain.command.CommandExecutor drainExecutor;
    private List<CommandCondition> conditions = new ArrayList<>();
    private boolean playerOnly = false;
    private boolean dynamicCommand = false;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<String> getTabcomplete() {
        return tabcomplete;
    }

    public void setTabcomplete(List<String> tabcomplete) {
        this.tabcomplete = tabcomplete;
    }

    public String getPermissionErrorMessage() {
        return permissionErrorMessage;
    }

    public void setPermissionErrorMessage(String permissionErrorMessage) {
        this.permissionErrorMessage = permissionErrorMessage;
    }

    public String getStaticResponse() {
        return staticResponse;
    }

    public void setStaticResponse(String staticResponse) {
        this.staticResponse = staticResponse;
    }

    public net.ghastgames.drain.command.CommandExecutor getDrainExecutor() {
        return drainExecutor;
    }

    public void setDrainExecutor(net.ghastgames.drain.command.CommandExecutor drainExecutor) {
        this.drainExecutor = drainExecutor;
    }

    public List<CommandCondition> getConditions() {
        return conditions;
    }

    public String getConditionReturnedFalseMessage() {
        return conditionReturnedFalseMessage;
    }

    public void setConditionReturnedFalseMessage(String conditionReturnedFalseMessage) {
        this.conditionReturnedFalseMessage = conditionReturnedFalseMessage;
    }

    public boolean isDynamicCommand() {
        return dynamicCommand;
    }

    public void setDynamicCommand(boolean dynamicCommand) {
        this.dynamicCommand = dynamicCommand;
    }

    public boolean isPlayerOnly() {
        return playerOnly;
    }

    public void setPlayerOnly(boolean playerOnly) {
        this.playerOnly = playerOnly;
    }


}
