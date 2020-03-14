package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DeleteCommand extends Command {

    private static Logger logger = Logger.getLogger(DeleteCommand.class.getName());
    private FlashcardList flashcardList;
    private int index;

    /**
     * Constructor for delete command.
     *
     * @param flashcardList flashcard list for the command to execute on
     * @param index         index in the delete command
     */
    public DeleteCommand(FlashcardList flashcardList, int index) {
        assert flashcardList != null : "Invalid null FlashcardList!";

        this.flashcardList = flashcardList;
        this.index = index;
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
        logger.info("Deleting flashcard at index: " + index);
        flashcardList.deleteFlashcard(index);
        logger.info("Deleted flashcard at index: " + index);
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
