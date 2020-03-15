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
        assert flashcardList != null : "Invalid null FlashcardList!";

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
        flashcardList.addFlashcard(flashcardFactory.create(OTHER_FLASHCARD_COMMAND));
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
