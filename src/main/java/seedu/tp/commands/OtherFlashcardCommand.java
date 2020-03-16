package seedu.tp.commands;

import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;

import static seedu.tp.utils.Constants.OTHER_FLASHCARD_COMMAND;

/**
 * Command to create an other flashcard.
 */
public class OtherFlashcardCommand extends Command {

    private FlashcardList flashcardList;
    private FlashcardFactory flashcardFactory;

    /**
     * Constructor for Other Flashcard Command.
     *
     * @param flashcardList    flashcard list for the command to execute on
     * @param flashcardFactory the flashcard factory to be used in the command
     */
    public OtherFlashcardCommand(FlashcardList flashcardList, FlashcardFactory flashcardFactory) {
        this.flashcardList = flashcardList;
        this.flashcardFactory = flashcardFactory;
    }

    /**
     * Gets the flashcard list in the other flashcard command.
     *
     * @return the flashcard list
     */
    public FlashcardList getFlashcardList() {
        return flashcardList;
    }

    @Override
    public void execute() throws UnrecognizedFlashcardTypeException {
        LOGGER.info("Creating an other flashcard and adding it to the flashcard list...");
        flashcardList.addFlashcard(flashcardFactory.create(OTHER_FLASHCARD_COMMAND));
        LOGGER.info("Created an other flashcard and added it to the flashcard list");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OtherFlashcardCommand)) {
            return false;
        }
        OtherFlashcardCommand otherOtherFlashcardCommand = (OtherFlashcardCommand) obj;
        return otherOtherFlashcardCommand.getFlashcardList().equals(this.flashcardList);
    }
}
