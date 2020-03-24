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
    private String groupIdentifier;

    /**
     * Constructor for ListGroupCommand.
     *
     * @param groupList       list of all existing groups
     * @param ui              instance for user interaction
     * @param groupIdentifier name or index of the group to list all flashcards for
     */
    public ListFlashcardsInGroupCommand(GroupList groupList, Ui ui, String groupIdentifier) {
        assert groupList != null : "Invalid null GroupList!";
        assert ui != null : "Invalid null Ui!";
        assert !groupIdentifier.isEmpty() : "Invalid empty groupIdentifier!";

        this.groupList = groupList;
        this.ui = ui;
        this.groupIdentifier = groupIdentifier;
    }

    @Override
    public void execute() {
        LOGGER.info("Executing ListFlashcardsInGroupCommand...");
        try {
            FlashcardList flashcardsInGroup = groupList.getFlashcardsInGroup(groupIdentifier);
            ui.listFlashcardsInGroup(flashcardsInGroup, groupIdentifier);
        } catch (UnrecognizedFlashcardGroupException e) {
            ui.sendInvalidFlashcardGroupResponse();
            LOGGER.warning("UnrecognizedFlashcardGroupException occurred when executing "
                    + "ListFlashcardsInGroupCommand.");
        }
        LOGGER.info("Finished executing ListFlashcardsInGroupCommand!");
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
            && this.groupIdentifier.equals(otherListFlashcardsInGroupCommand.groupIdentifier);
    }
}
