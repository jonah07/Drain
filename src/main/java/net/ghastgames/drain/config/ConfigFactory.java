package net.ghastgames.drain.config;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigFactory {
    private final JavaPlugin plugin;

    public ConfigFactory(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Adds a default value to the plugin's configuration
     *
     * @param path The path
     *             Example:
     *             "name" would result in a configuration like this:
     *             name: EinGriefer
     *             "permission.command" would result in a configuration like this:
     *             permission:
     *               command: any.thing
     * @param value The default value
     */
    public ConfigFactory addDefaultValue(String path, Object value) {
        this.plugin.getConfig().addDefault(path, value);
        return this;
    }
}
