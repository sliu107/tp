package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;

public class DeleteCommand extends Command {

    private FlashcardList flashcardList;
    private int index;

    /**
     * Constructor for delete command.
     *
     * @param flashcardList flashcard list for the command to execute on
     * @param index         index in the delete command
     */
    public DeleteCommand(FlashcardList flashcardList, int index) {
        this.flashcardList = flashcardList;
        this.index = index;
    }

    @Override
    public void execute()
        throws InvalidFlashcardIndexException {
        flashcardList.deleteFlashcard(index);
    }
}
