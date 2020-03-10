package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;

/**
 * Commands to create a new group.
 */
public class GroupCommand extends Command {
    private GroupFactory groupFactory;
    private GroupList groupList;
    private FlashcardList flashcardList;

    /**
     * Constructs a group command.
     *
     * @param flashcardList flashcard list for the command to execute on
     * @param groupFactory  groupFactory the groupCommand use
     * @param groupList     groupList where the groupCommand execute on
     */
    public GroupCommand(FlashcardList flashcardList, GroupFactory groupFactory, GroupList groupList) {
        this.flashcardList = flashcardList;
        this.groupFactory = groupFactory;
        this.groupList = groupList;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        groupList.addFlashcardGroup(groupFactory.form());
    }
}
