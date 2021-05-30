package net.ghastgames.drain.tabcomplete;

public class TabCompleteOption {
    /**
     * The text that has been typed already
     */
    private String condition;
    /**
     * The text to get suggested
     */
    private String option;

    public TabCompleteOption(String condition, String option) {
        this.condition = condition;
        this.option = option;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
