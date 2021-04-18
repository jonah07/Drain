package net.ghastgames.drain.annotations;

import net.ghastgames.drain.command.CommandResponse;
import org.bukkit.command.Command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PluginCommand {

    /**
     * Permission for the command
     */
    String permission() default "";

    /**
     * No permission message
     */
    String noPermissionMessage() default "§cYou are not allowed to do this!";

    /**
     * Auto-/tabcomplete options
     */
    String[] tabcomplete() default {};

    /**
     * <p>
     * If set, the command only sends the given response.
     * The code in the executor method will be ignored.
     * </p>
     * <p>
     * Available placeholders:<br>
     * - %player% -> player's name <br>
     * - %player_displayname% -> player's displayname
     * </p>
     *
     * <p>
     * Tips:<br>
     * Use \n to switch to a new line.<br>
     * Color codes are supported, if you use § as the color code char.
     * </p>
     */
    String response() default "";
}
