package net.ghastgames.drain.exception;

public class NonStaticExecutorAlreadySetException extends RuntimeException {

    public NonStaticExecutorAlreadySetException() {
        super("There is already a non-static executor set!");
    }
}
