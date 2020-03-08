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
     * @param ui the ui need to pass to the execution method
     * @param groupList the groupList where the flashcard wants to be added in
     * @param flashcardList the flashcardList where the flashcard is in
     */
    public AddFlashcardToGroupCommand(Ui ui, GroupList groupList, FlashcardList flashcardList) {
        this.ui = ui;
        this.groupList = groupList;
        this.flashcardList = flashcardList;
    }

    @Override
    public void execute() throws HistoryFlashcardException {
        groupList.addFlashcardToOneGroup(ui,flashcardList);
    }
}
