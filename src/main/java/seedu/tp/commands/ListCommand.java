package seedu.tp.commands;

import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Command to list all existing flashcards.
 */
public class ListCommand extends Command {

    private FlashcardList flashcardList;
    private Ui ui;

    /**
     * Constructor for ListCommand.
     *
     * @param flashcardList the flashcard list to be used in the command
     * @param ui            the UI object ot be used in the command
     */
    public ListCommand(FlashcardList flashcardList, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";

        this.flashcardList = flashcardList;
        this.ui = ui;
    }

    /**
     * Gets the flashcard list in the list command.
     *
     * @return the flashcard list
     */
    public FlashcardList getFlashcardList() {
        return flashcardList;
    }

    @Override
    public void execute() {
        ui.listAllFlashcards(flashcardList);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListCommand)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        ListCommand otherListCommand = (ListCommand) obj;
        return otherListCommand.getFlashcardList().equals(this.flashcardList);
    }
}
