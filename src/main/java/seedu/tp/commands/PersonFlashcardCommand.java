package seedu.tp.commands;

import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import static seedu.tp.utils.Constants.PERSON_FLASHCARD_COMMAND;

/**
 * Command to create a person flashcard.
 */
public class PersonFlashcardCommand extends Command {

    private FlashcardFactory flashcardFactory;

    /**
     * Constructor for Person Flashcard Command.
     *
     * @param flashcardFactory the flashcard factory to be used in the command
     */
    public PersonFlashcardCommand(FlashcardFactory flashcardFactory) {
        this.flashcardFactory = flashcardFactory;
    }

    @Override
    public void execute(FlashcardList flashcardList, Ui ui) throws UnrecognizedFlashcardTypeException {
        flashcardList.addFlashcard(flashcardFactory.create(PERSON_FLASHCARD_COMMAND));
    }
}
