package net.ghastgames.drain.command.argchecker;

import java.util.Arrays;

// https://github.com/EinGriefer/Drain/issues/12
public class CommandArgsChecker {
    private static CommandArgsChecker instance;

    private CommandArgsChecker() {}

    public static CommandArgsChecker getInstance() {
        if(instance == null) instance = new CommandArgsChecker();
        return instance;
    }

    public boolean checkArgs(String[] givenArgs, String template, String... expressions) {
        String[] templateParts = template.split(" ");
        String[] templateArgs = Arrays.copyOfRange(templateParts, 1, templateParts.length); // Copy all arguments
        String command = templateParts[0];
        String cleanCommand = command.replace("/", ""); // Command without slash

        if(templateArgs.length != givenArgs.length) { // TODO: Ignore optional args
            return false;
        }
        return true;
    }
}
