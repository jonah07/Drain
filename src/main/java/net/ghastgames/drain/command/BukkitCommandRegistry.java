package net.ghastgames.drain.command;

import net.ghastgames.drain.annotations.PluginCommand;
import net.ghastgames.drain.tabcomplete.TabCompleterImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    /**
     * <strong>It's not recommended to use this method! Use the DynamicCommandBuilder instead.</strong>
     */
    public static void registerCommand(DrainCommand drainCommand, JavaPlugin plugin) {
        commands.add(drainCommand);
        plugin.getCommand(drainCommand.getCommand()).setExecutor((sender, cmd, s, args) -> true);
        plugin.getCommand(drainCommand.getCommand()).setTabCompleter(new TabCompleterImpl());
    }

    public static List<DrainCommand> getCommands() {
        return commands;
    }

    public static DrainCommand getCommand(String command) {
        List<DrainCommand> result = commands.stream().filter(new Predicate<DrainCommand>() {
            @Override
            public boolean test(DrainCommand drainCommand) {
                return drainCommand.getCommand().equalsIgnoreCase(command);
            }
        }).collect(Collectors.toList());

        if(result.size() == 1) {
            return result.get(0);
        } else if (result.size() > 1) {
            throw new RuntimeException();
        } else {
            throw new CommandException(String.format("Command %s not found", command));
        }
    }

    public static DrainCommand getCommand(Command command) {
        return getCommand(command.getName());
    }
}
