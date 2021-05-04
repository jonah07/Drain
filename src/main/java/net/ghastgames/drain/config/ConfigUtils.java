package net.ghastgames.drain.config;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class ConfigUtils {

    /**
     * Gets a location saved by Drain from a configuration
     *
     * @param plugin Plugin
     * @param path The path of the location
     * @return The Bukkit location
     */
    public static Location getLocationFromConfig(JavaPlugin plugin, String path) {
        ConfigurationSection locationSection = plugin.getConfig().getConfigurationSection(path);
        int x = locationSection.getInt("x");
        int y = locationSection.getInt("y");
        int z = locationSection.getInt("z");
        int yaw = locationSection.getInt("yaw");
        int pitch = locationSection.getInt("pitch");
        World world = Bukkit.getWorld(UUID.fromString(locationSection.getString("world")));
        return new Location(world, x, y, z, yaw, pitch);
    }
}
