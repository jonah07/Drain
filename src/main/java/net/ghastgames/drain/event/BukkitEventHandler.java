package net.ghastgames.drain.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Predicate;

public class BukkitEventHandler {

    public static void handleBukkitEvent(Class<?> event) {

    }

    public static void handleCancellableBukkitEvent(Class<?> event, Cancellable cancellable) {
        boolean playerEvent;
        try {
            event.getMethod("getPlayer", null);
            playerEvent = true;
        } catch (Exception ignored) {
            playerEvent = false;
        }

        if(!Arrays.stream(event.getInterfaces()).anyMatch(clazz -> clazz.getSimpleName().equalsIgnoreCase("Callable"))) {
            playerEvent = false;
        }

        if(BukkitEventRegistry.getCancelledEventList().contains(event.getSimpleName()) && !playerEvent) {
            cancellable.setCancelled(true);
        }
    }

    public static void handlePlayerBukkitEvent(PlayerEvent event, Class<?> eventClass, Player player, Cancellable cancellable) {
        if(cancellable != null) {
            if (cancellable.isCancelled()) {
                if (BukkitEventRegistry.getCancelledEventList().contains(eventClass.getSimpleName())) {
                    if (BukkitEventRegistry.getEventPermissionList().containsKey(eventClass.getSimpleName())) {
                        // Permission needed
                        if (player.hasPermission(BukkitEventRegistry.getEventPermissionList().get(eventClass.getSimpleName()))) {
                            cancellable.setCancelled(false);
                        } else {
                            player.sendMessage(BukkitEventRegistry.getEventErrorMessageList().get(eventClass.getSimpleName()));
                        }
                    }
                }
            }
        }
    }

    public static void handleEntityEvent(EntityEvent event, Class<?> eventClass, Entity entity, Cancellable cancellable) {

    }
}
