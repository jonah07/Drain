package net.ghastgames.drain.command;

import org.bukkit.command.CommandExecutor;

import java.util.List;

public class DrainCommand {
    private String command;
    private List<String> tabcomplete;
    private String permission;
    private CommandExecutor executor;
    private String permissionErrorMessage;
    private String staticResponse;

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
}
