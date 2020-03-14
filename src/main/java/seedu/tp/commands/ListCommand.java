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
     * Constructor for list command.
     *
     * @param flashcardList flashcard list for the command to execute on
     * @param ui            the UI class to be used by the command
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
        LOGGER.info("Listing flashcards...");
        ui.listAllFlashcards(flashcardList);
        LOGGER.info("Listed flashcards");
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
