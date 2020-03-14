package seedu.tp.commands;

import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Command to list all existing flashcards.
 */
public class ListCommand extends Command {

    private static Logger logger = Logger.getLogger(ListCommand.class.getName());
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

    private static void setupLogger() {
        // Solution below referenced and adopted from: https://www.youtube.com/watch?v=W0_Man88Z3Q&feature=youtu.be
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        logger.addHandler(consoleHandler);
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
        logger.info("Listing flashcards...");
        ui.listAllFlashcards(flashcardList);
        logger.info("Listed flashcards");
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
