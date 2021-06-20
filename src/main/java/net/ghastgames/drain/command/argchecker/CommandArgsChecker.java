package net.ghastgames.drain.command.argchecker;

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
        String command = templateParts[0];
        String cleanCommand = command.replace("/", ""); // Command without slash

        if(templateParts.length == 1) { // no arguments
            
        }
        return true;
    }
}
