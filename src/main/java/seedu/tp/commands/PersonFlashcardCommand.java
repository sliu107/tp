package seedu.tp.commands;

import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;

import static seedu.tp.utils.Constants.PERSON_FLASHCARD_COMMAND;

/**
 * Command to create a person flashcard.
 */
public class PersonFlashcardCommand extends Command {

    private FlashcardList flashcardList;
    private FlashcardFactory flashcardFactory;

    /**
     * Constructor for Person Flashcard Command.
     *
     * @param flashcardList    flashcard list for the command to execute on
     * @param flashcardFactory the flashcard factory to be used in the command
     */
    public PersonFlashcardCommand(FlashcardList flashcardList, FlashcardFactory flashcardFactory) {
        this.flashcardList = flashcardList;
        this.flashcardFactory = flashcardFactory;
    }

    @Override
    public void execute() throws UnrecognizedFlashcardTypeException {
        flashcardList.addFlashcard(flashcardFactory.create(PERSON_FLASHCARD_COMMAND));
    }
}