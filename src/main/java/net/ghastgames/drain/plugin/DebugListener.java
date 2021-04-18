package net.ghastgames.drain.plugin;

import net.ghastgames.drain.annotations.Cancel;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DebugListener implements Listener {

    @EventHandler
    @Cancel(
            permission = "blocks.break",
            errorMessage = "§cYou are not allowed to break blocks here!"
    )
    public void onBlockBreak(BlockBreakEvent event) {}

    @EventHandler
    @Cancel
    public void onDamage(EntityDamageEvent event) {}
}
