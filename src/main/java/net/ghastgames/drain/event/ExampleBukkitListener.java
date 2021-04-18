package net.ghastgames.drain.event;

import net.ghastgames.drain.annotations.Cancel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ExampleBukkitListener implements Listener {

    // Without Drain
    @EventHandler
    public void onEvent(BlockBreakEvent event) {
        if(!event.getPlayer().hasPermission("block.break")) {
            event.setCancelled(true);
        }
    }

    // With Drain
    @EventHandler
    @Cancel
    public void onDrainEvent(BlockBreakEvent event) {}
}
