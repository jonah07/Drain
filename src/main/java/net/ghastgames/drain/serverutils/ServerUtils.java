package net.ghastgames.drain.serverutils;

import org.bukkit.Bukkit;

public class ServerUtils {

    /**
     * Shuts down the server
     */
    public static void shutdown() {
        Bukkit.getServer().shutdown();
    }
}
