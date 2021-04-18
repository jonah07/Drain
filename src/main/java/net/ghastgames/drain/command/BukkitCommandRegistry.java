package net.ghastgames.drain.command;

import net.ghastgames.drain.annotations.PluginCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BukkitCommandRegistry {
    private static List<DrainCommand> commands = new ArrayList<>();

    public static void registerCommand(String command, CommandExecutor executor, JavaPlugin plugin) {
        Class<?> executorClass = executor.getClass();
        PluginCommand commandAnnotation = null;

        for(Method method : executorClass.getDeclaredMethods()) {
            if(method.isAnnotationPresent(PluginCommand.class)) {
                commandAnnotation = method.getAnnotation(PluginCommand.class);
            }
        }

        if(commandAnnotation != null) {
            DrainCommand drainCommand = new DrainCommand();
            drainCommand.setCommand(command);
            drainCommand.setExecutor(executor);
            drainCommand.setPermission(commandAnnotation.permission());
            drainCommand.setTabcomplete(Arrays.asList(commandAnnotation.tabcomplete()));
            drainCommand.setPermissionErrorMessage(commandAnnotation.noPermissionMessage());
            drainCommand.setStaticResponse(commandAnnotation.response());

            plugin.getCommand(command).setExecutor(executor);

            commands.add(drainCommand);
        } else {
            throw new IllegalArgumentException("There is no method annotated with @Command!");
        }
    }

    public static List<DrainCommand> getCommands() {
        return commands;
    }
}
