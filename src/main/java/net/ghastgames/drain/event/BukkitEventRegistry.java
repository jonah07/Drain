package net.ghastgames.drain.event;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import net.ghastgames.drain.annotations.Cancel;
import net.ghastgames.drain.utils.Pair;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BukkitEventRegistry {
    private static final List<String> bukkitEventList = new ArrayList<>();
    private static final List<String> cancelledEventList = new ArrayList<>(); // All events to be canceled
    private static final HashMap<String, String> eventPermissionList = new HashMap<>(); // All events with a permission
    private static final HashMap<String, String> eventErrorMessageList = new HashMap<>(); // All events with an error message

    private static EventExecutor cancelEventExecutor;

    static {
        ClassInfoList events = new ClassGraph()
                .enableClassInfo()
                .scan()
                .getClassInfo(Event.class.getName())
                .getSubclasses()
                .filter(info -> !info.isAbstract());

        for (ClassInfo classInfo : events) {
            bukkitEventList.add(classInfo.getName());
        }
    }

    public static void registerListener(Listener givenListener, JavaPlugin plugin) {
        Bukkit.getLogger().info("1");
        for(Method method : givenListener.getClass().getDeclaredMethods()) {
            Bukkit.getLogger().info("2");
            if(method.isAnnotationPresent(EventHandler.class) && method.getParameterCount() == 1) {
                Bukkit.getLogger().info("3");
                if(method.isAnnotationPresent(Cancel.class)) {
                    Class<?> eventClass = method.getParameterTypes()[0];
                    Bukkit.getLogger().info("4");
                    if(bukkitEventList.contains(eventClass.getName())) {
                        cancelledEventList.add(eventClass.getSimpleName());

                        if(!method.getAnnotation(Cancel.class).permission().equals("")) {
                            eventPermissionList.put(eventClass.getSimpleName(), method.getAnnotation(Cancel.class).permission());
                        }

                        if(!method.getAnnotation(Cancel.class).errorMessage().equals("")) {
                            eventErrorMessageList.put(eventClass.getSimpleName(), method.getAnnotation(Cancel.class).errorMessage());
                        }

                        Bukkit.getLogger().info("5 - " + eventClass.getName());
                    }
                } else {
                    BukkitEventRegistry.registerListener(givenListener, plugin);
                    Bukkit.getLogger().info("6");
                }
            }
        }
    }

    public static List<String> getCancelledEventList() {
        return cancelledEventList;
    }

    public static HashMap<String, String> getEventErrorMessageList() {
        return eventErrorMessageList;
    }

    public static HashMap<String, String> getEventPermissionList() {
        return eventPermissionList;
    }
}
