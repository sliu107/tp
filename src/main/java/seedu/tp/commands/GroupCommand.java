package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;
import seedu.tp.storage.Storage;
import seedu.tp.ui.Ui;

/**
 * Commands to create a new group.
 */
public class GroupCommand extends ModifyingCommand {
    private GroupFactory groupFactory;
    private GroupList groupList;

    /**
     * Constructs a group command.
     *
     * @param groupFactory groupFactory the groupCommand use
     * @param groupList    groupList where the groupCommand execute on
     */
    public GroupCommand(GroupFactory groupFactory, GroupList groupList, Ui ui, Storage storage) {
        super(storage, ui);
        assert groupFactory != null : "Invalid null GroupFactory!";
        assert groupList != null : "Invalid null GroupList!";

        this.groupFactory = groupFactory;
        this.groupList = groupList;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        LOGGER.info("Creating a new group...");
        FlashcardGroup flashcardGroup = groupFactory.form();
        groupList.addFlashcardGroup(flashcardGroup);
        LOGGER.info("Created a new group");
        save(flashcardGroup);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GroupCommand)) {
            return false;
        }

        GroupCommand otherGroupCommand = (GroupCommand) obj;
        return this.getGroupList().equals(otherGroupCommand.getGroupList());
    }

    public GroupList getGroupList() {
        return groupList;
    }
}
