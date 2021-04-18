package net.ghastgames.drain.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates EventHandlers that only cancel the event.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cancel {

    /**
     * If the player has the permission, the event will not be cancelled
     */
    String permission() default "";

    /**
     * If set, the player receives a custom message.
     */
    String errorMessage() default "";
}
