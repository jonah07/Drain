package net.ghastgames.drain.tabcomplete;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteUtils {

    /**
     * Converts a List of TabCompleteOptions into a string list
     *
     * @param tabCompleteOptions The list to be converted
     * @return The string list containing all options
     */
    public static List<String> convertTabCompleteOptionsToString(List<TabCompleteOption> tabCompleteOptions) {
        List<String> returnList = new ArrayList<>();

        tabCompleteOptions.forEach((option) -> returnList.add(option.getOption()));

        return returnList;
    }
}
