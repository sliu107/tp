package seedu.tp.commands;

import seedu.tp.group.GroupList;
import seedu.tp.ui.Ui;

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
    public void execute() {
        LOGGER.info("Executing ShowGroupsCommand...");
        ui.listAllGroups(groupList);
        LOGGER.info("ShowGroupsCommand executed!");
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
