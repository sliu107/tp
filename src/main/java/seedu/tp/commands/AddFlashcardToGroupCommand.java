package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.GroupList;
import seedu.tp.ui.Ui;

public class AddFlashcardToGroupCommand extends Command {
    private Ui ui;
    private GroupList groupList;
    private FlashcardList flashcardList;

    /**
     * Constructs an addFlashcardToGroupCommand.
     *
     * @param ui            the ui need to pass to the execution method
     * @param groupList     the groupList where the flashcard wants to be added in
     * @param flashcardList the flashcardList where the flashcard is in
     */
    public AddFlashcardToGroupCommand(Ui ui, GroupList groupList, FlashcardList flashcardList) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert groupList != null : "Invalid null GroupList!";

        this.ui = ui;
        this.groupList = groupList;
        this.flashcardList = flashcardList;
    }

    @Override
    public void execute() throws HistoryFlashcardException {
        groupList.addFlashcardToOneGroup(ui, flashcardList);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AddFlashcardToGroupCommand)) {
            return false;
        }

        AddFlashcardToGroupCommand otherAddFlashcardToGroupCommand = (AddFlashcardToGroupCommand) obj;
        return this.getFlashcardList().equals(otherAddFlashcardToGroupCommand.getFlashcardList())
            && this.getGroupList().equals(otherAddFlashcardToGroupCommand.getGroupList());
    }

    public GroupList getGroupList() {
        return groupList;
    }

    public FlashcardList getFlashcardList() {
        return flashcardList;
    }
}