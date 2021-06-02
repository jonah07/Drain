package net.ghastgames.drain.tabcomplete;

import net.ghastgames.drain.command.BukkitCommandRegistry;
import net.ghastgames.drain.command.DrainCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TabCompleterImpl implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String alreadyTyped, String[] args) {
        DrainCommand drainCommand = BukkitCommandRegistry.getCommand(command);

        // Return when there are no tab complete options
        if(drainCommand.getTabCompleteOptions().size() == 0) {
            return Collections.emptyList();
        }

        List<TabCompleteOption> options = drainCommand.getTabCompleteOptions();

        Stream<TabCompleteOption> optionStream = options.stream();

        optionStream = optionStream.filter(new Predicate<TabCompleteOption>() {
            @Override
            public boolean test(TabCompleteOption tabCompleteOption) {
                return tabCompleteOption.getCondition().isEmpty() || tabCompleteOption.getCondition().equalsIgnoreCase(alreadyTyped);
            }
        });

        return Arrays.asList();
    }
}
