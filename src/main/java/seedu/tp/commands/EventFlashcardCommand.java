package seedu.tp.commands;

import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import static seedu.tp.utils.Constants.EVENT_FLASHCARD_COMMAND;

/**
 * Command to create an event flashcard.
 */
public class EventFlashcardCommand extends Command {

    private FlashcardFactory flashcardFactory;

    /**
     * Constructor for Event Flashcard Command.
     *
     * @param flashcardFactory the flashcard factory to be used in the command
     */
    public EventFlashcardCommand(FlashcardFactory flashcardFactory) {
        this.flashcardFactory = flashcardFactory;
    }

    @Override
    public void execute(FlashcardList flashcardList, Ui ui) throws UnrecognizedFlashcardTypeException {
        flashcardList.addFlashcard(flashcardFactory.create(EVENT_FLASHCARD_COMMAND));
    }
}
