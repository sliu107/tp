package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Command used in the application.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param flashcardList Task list containing all flashcards.
     * @param ui            UI to handle interaction with users.
     */
    public abstract void execute(FlashcardList flashcardList, Ui ui)
        throws HistoryFlashcardException;

    /**
     * Checks whether the command is a bye command.
     *
     * @return Boolean value indicating whether or not the command is a bye command.
     */
    public boolean isBye() {
        return false;
    }
}