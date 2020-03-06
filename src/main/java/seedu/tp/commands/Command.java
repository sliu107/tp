package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;

/**
 * Command used in the application.
 */
public abstract class Command {

    /**
     * Executes the command.
     */
    public abstract void execute()
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