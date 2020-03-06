package seedu.tp.commands;

import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;

import static seedu.tp.utils.Constants.EVENT_FLASHCARD_COMMAND;

/**
 * Command to create an event flashcard.
 */
public class EventFlashcardCommand extends Command {

    private FlashcardList flashcardList;
    private FlashcardFactory flashcardFactory;

    /**
     * Constructor for Event Flashcard Command.
     *
     * @param flashcardList    flashcard list for the command to execute on
     * @param flashcardFactory the flashcard factory to be used in the command
     */
    public EventFlashcardCommand(FlashcardList flashcardList, FlashcardFactory flashcardFactory) {
        this.flashcardList = flashcardList;
        this.flashcardFactory = flashcardFactory;
    }

    @Override
    public void execute() throws UnrecognizedFlashcardTypeException {
        flashcardList.addFlashcard(flashcardFactory.create(EVENT_FLASHCARD_COMMAND));
    }
}
