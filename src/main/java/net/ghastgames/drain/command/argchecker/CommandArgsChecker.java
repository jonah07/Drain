package net.ghastgames.drain.command.argchecker;

// https://github.com/EinGriefer/Drain/issues/12
public class CommandArgsChecker {
    private static CommandArgsChecker instance;

    private CommandArgsChecker() {}

    public static CommandArgsChecker getInstance() {
        if(instance == null) instance = new CommandArgsChecker();
        return instance;
    }
}
