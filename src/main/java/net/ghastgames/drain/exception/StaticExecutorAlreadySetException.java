package net.ghastgames.drain.exception;

public class StaticExecutorAlreadySetException extends RuntimeException {

    public StaticExecutorAlreadySetException() {
        super("There is already a static executor!");
    }
}
