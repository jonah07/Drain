package net.ghastgames.drain;

import net.ghastgames.drain.command.DrainBukkitCommand;
import net.ghastgames.drain.event.listeners.BukkitListeners;
import net.ghastgames.drain.plugin.DebugListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@net.ghastgames.drain.annotations.DrainPlugin
public class DrainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().addDefault("debug", false);
        getConfig().options().copyDefaults(true);

        if(!new File(getConfig().getCurrentPath()).exists()) {
            saveDefaultConfig();
        }

        if(getConfig().getBoolean("debug")) {
            Drain.getInstance().registerListener(new DebugListener(), this);
        }

        Drain.getInstance().registerCommand("drain", new DrainBukkitCommand(), this);

        registerListener(new BukkitListeners());
    }

    public static void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, Bukkit.getPluginManager().getPlugin("Drain"));
    }
}
