package net.ghastgames.drain;

/*
TODO:
    - Add @Cancel annotation for methods to cancel an event automatically

        @Cancel
        @EventHandler
        public void onEvent(BlocKPlaceEvent event) {}

        Idea: Get all methods annotated with the annotation, add an EventHandler
 */

import net.ghastgames.drain.command.BukkitCommandRegistry;
import net.ghastgames.drain.event.BukkitEventRegistry;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Drain {
    private static Drain instance;

    public static String COMMAND_PLAYER_ONLY = "§cThis command is player-only!";

    private Drain() {}

    /**
     * @return The Drain instance
     */
    public static Drain getInstance() {
        if(instance == null) {
            instance = new Drain();
        }
        return instance;
    }

    /**
     * <p>
     * Registers a listener. If you register your listener using this method,
     * you should not register it again using the bukkit method.
     * </p>
     *
     * <p>
     * Only if you use this method, Drain annotations (for example @Cancel)
     * are supported.
     * </p>
     *
     * @param listener The listener (implements org.bukkit.Listener)
     * @param plugin The plugin (extends org.bukkit.plugin.java.JavaPlugin)
     */
    public void registerListener(Listener listener, JavaPlugin plugin) {
        BukkitEventRegistry.registerListener(listener, plugin);
    }

    /**
     * <p>
     * Registers a command. If you register your command using the following method,
     * you should NOT register it again using Bukkit's methods.
     * </p>
     *
     * <p>
     * Registering your command using this method is required, if you want
     * to use Drain annotations.
     * </p>
     *
     * @param command The command (without a slash at the beginning)
     *                Example: If you want your command to be accessible using
     *                /hello, the correct value would be hello.
     * @param executor The executor (implements CommandExecutor)
     * @param plugin The main class of your Bukkit plugin
     */
    public void registerCommand(String command, CommandExecutor executor, JavaPlugin plugin) {
        BukkitCommandRegistry.registerCommand(command, executor, plugin);
    }
}
