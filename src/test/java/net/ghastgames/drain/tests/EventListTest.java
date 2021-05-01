package net.ghastgames.drain.tests;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerEvent;

// to clarify, this is a code generator to generate the bukkit event listener class
public class EventListTest {

    public static void main(String[] args) {
        ClassInfoList events = new ClassGraph()
                .enableClassInfo()
                .enableMethodInfo()
                .scan()
                .getClassInfo(Event.class.getName())
                .getSubclasses()
                .filter(info -> !info.isAbstract());
        events.forEach((classInfo) -> printMethod(classInfo));
    }

    public static void printMethod(ClassInfo classInfo) {
        String eventName = classInfo.getSimpleName();
        System.out.println(" ");
        System.out.println("@EventHandler");
        System.out.println("public void on" + eventName + "(" + eventName + " event) {");
        System.out.println("    BukkitEventHandler.handleBukkitEvent(event.getClass());");
        System.out.println("    if(event instanceof Cancellable) {");
        System.out.println("        BukkitEventHandler.handleCancellableBukkitEvent(event.getClass(), (Cancellable) event);");
        System.out.println("    }");

        if(classInfo.hasMethod("getPlayer")) {
            System.out.println("    BukkitEventHandler.handlePlayerBukkitEvent(event.getClass(), event.getPlayer());");
        }

        if(classInfo.hasMethod("getEntity")) {
            System.out.println("    BukkitEventHandler.handleEntityEvent(event.getClass(), event.getEntity());");
        }

        System.out.println("}");
        System.out.println(" ");
    }
}
