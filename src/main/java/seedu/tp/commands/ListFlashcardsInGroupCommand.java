package seedu.tp.commands;

import seedu.tp.exceptions.UnrecognizedFlashcardGroupException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.GroupList;
import seedu.tp.ui.Ui;

/**
 * Command to list all flashcards in a specified group.
 */
public class ListFlashcardsInGroupCommand extends Command {
    private Ui ui;
    private GroupList groupList;
    private String groupName;

    /**
     * Constructor for ListGroupCommand.
     *
     * @param groupList list of all existing groups
     * @param ui        instance for user interaction
     * @param groupName name of the group to list all flashcards for
     */
    public ListFlashcardsInGroupCommand(GroupList groupList, Ui ui, String groupName) {
        assert groupList != null : "Invalid null GroupList!";
        assert ui != null : "Invalid null Ui!";
        assert !groupName.isEmpty() : "Invalid empty groupName!";

        this.groupList = groupList;
        this.ui = ui;
        this.groupName = groupName;
    }

    @Override
    public void execute() throws UnrecognizedFlashcardGroupException {
        LOGGER.info("Executing ListGroupCommand...");
        try {
            FlashcardList flashcardsInGroup = groupList.getFlashcardsInGroup(groupName);
            ui.listFlashcardsInGroup(flashcardsInGroup, groupName);
        } catch (UnrecognizedFlashcardGroupException e) {
            ui.sendInvalidFlashcardGroupResponse();
            LOGGER.warning("UnrecognizedFlashcardGroupException occurred when executing ListGroupCommand.");
        }
        LOGGER.info("Finished executing ListGroupCommand!");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListFlashcardsInGroupCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        ListFlashcardsInGroupCommand otherListFlashcardsInGroupCommand = (ListFlashcardsInGroupCommand) obj;
        return this.ui.equals(otherListFlashcardsInGroupCommand.ui)
                && this.groupList.equals(otherListFlashcardsInGroupCommand.groupList)
                && this.groupName.equals(otherListFlashcardsInGroupCommand.groupName);
    }
}
