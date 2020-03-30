package seedu.tp.commands;

import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupList;
import seedu.tp.ui.Ui;

import java.util.List;

/**
 * Command to list all existing groups.
 */
public class ShowGroupsCommand extends Command {
    private Ui ui;
    private GroupList groupList;

    /**
     * Constructor for ShowGroupsCommand.
     *
     * @param groupList list of flashcard groups
     * @param ui        instance for user interaction
     */
    public ShowGroupsCommand(GroupList groupList, Ui ui) {
        assert groupList != null : "Invalid null GroupList!";
        assert ui != null : "Invalid null Ui!";

        this.groupList = groupList;
        this.ui = ui;
    }

    @Override
    public CommandFeedback execute() {
        LOGGER.info("Executing ShowGroupsCommand...");
        LOGGER.info("ShowGroupsCommand executed!");
        String feedback = getFeedback(groupList);
        return new CommandFeedback(feedback);
    }

    private String getFeedback(GroupList groupList) {
        if (groupList.getTotalGroupNum() == 0) {
            return "There are no existing groups. Use \"group\" to create a new group.";
        }
        List<FlashcardGroup> groups = groupList.getGroups();
        StringBuilder feedback = new StringBuilder("Here are all existing groups:");
        for (int i = 0; i < groups.size(); i++) {
            FlashcardGroup group = groups.get(i);
            String groupName = group.getName();
            feedback.append(i + 1 + ". " + groupName);
        }
        return feedback.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ShowGroupsCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        ShowGroupsCommand otherShowGroupsCommand = (ShowGroupsCommand) obj;
        return this.groupList.equals(otherShowGroupsCommand.groupList)
            && this.ui.equals(otherShowGroupsCommand.ui);
    }
}
