package net.ghastgames.drain.config;

import net.minecraft.server.v1_8_R3.ItemStack;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.Serializable;
import java.util.HashMap;

public class ConfigManager {
    private JavaPlugin plugin;
    private FileConfiguration config;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    /**
     * Returns a saved value
     * @param path The path to the value
     */
    public Object getConfigValue(String path) {
        return config.get(path);
    }

    /**
     * Saves a location in the plugin's configuration file
     *
     * @param path The path to the location
     * @param location The location
     */
    public void saveLocation(String path, Location location) {
        // I know that Location implements ConfigurationSerializable, but when you load a
        // location before the concerning world is loaded, you'll get an exception

        config.set(path + ".x", location.getX());
        config.set(path + ".y", location.getY());
        config.set(path + ".z", location.getZ());
        config.set(path + ".yaw", location.getYaw());
        config.set(path + ".pitch", location.getPitch());
        config.set(path + ".world", location.getWorld().getUID().toString()); // We're saving the UID instead of the name
    }

    /**
     * Saves a value at the given path
     */
    public void setConfigValue(String path, Object value) {
        config.set(path, value);
    }
}
