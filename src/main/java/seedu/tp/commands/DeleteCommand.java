package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

public class DeleteCommand extends Command {

    private FlashcardList flashcardList;
    private int index;
    private Ui ui;

    /**
     * Constructor for delete command.
     *
     * @param flashcardList flashcard list for the command to execute on
     * @param index         index in the delete command
     */
    public DeleteCommand(FlashcardList flashcardList, int index, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";

        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
    }

    /**
     * Gets index in the delete command.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the flashcard list in the delete command.
     *
     * @return the flashcard list
     */
    public FlashcardList getFlashcardList() {
        return flashcardList;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        LOGGER.info("Deleting flashcard at index: " + index);
        flashcardList.deleteFlashcard(ui, index);
        LOGGER.info("Deleted flashcard at index: " + index);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        DeleteCommand otherDeleteCommand = (DeleteCommand) obj;
        return otherDeleteCommand.getIndex() == this.index
            && otherDeleteCommand.getFlashcardList().equals(this.flashcardList);
    }
}
