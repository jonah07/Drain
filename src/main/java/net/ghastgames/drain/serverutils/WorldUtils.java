package net.ghastgames.drain.serverutils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class WorldUtils {

    /**
     * Imports a world saved in the server directory.
     *
     * @param name name of the world directory
     */
    public static World importWorld(String name) {
        return Bukkit.createWorld(new WorldCreator(name));
    }

    /**
     * Creates a world.
     *
     * @param name The name of the world
     * @param environment The environment, e.g. The End
     * @return The created world
     */
    public static World createWorld(String name, World.Environment environment) {
        WorldCreator creator = new WorldCreator(name);
        creator.environment(environment);
        return Bukkit.createWorld(creator);
    }
}
