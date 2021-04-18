package net.ghastgames.drain.tests;

import net.ghastgames.drain.annotations.DrainPlugin;
import org.reflections.Reflections;

import java.util.function.Consumer;

public class ReflectionTest {

    public static void main(String[] args) {
        try {
            Reflections reflections = new Reflections();
            reflections.getTypesAnnotatedWith(DrainPlugin.class).forEach(System.out::println);
        } catch (Exception ignored) {}
    }
}
