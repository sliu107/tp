package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

public class DeleteCommand extends Command {

    private int index;

    /**
     * Constructor for delete command.
     *
     * @param index Index in the delete command.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(FlashcardList flashcardList, Ui ui)
            throws InvalidFlashcardIndexException {
        flashcardList.deleteFlashcard(index);
    }
}
