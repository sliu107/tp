package seedu.tp.commands;

import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import static seedu.tp.utils.Constants.OTHER_FLASHCARD_COMMAND;

/**
 * Command to create an other flashcard.
 */
public class OtherFlashcardCommand extends Command {

    private FlashcardFactory flashcardFactory;

    /**
     * Constructor for Other Flashcard Command.
     *
     * @param flashcardFactory the flashcard factory to be used in the command
     */
    public OtherFlashcardCommand(FlashcardFactory flashcardFactory) {
        this.flashcardFactory = flashcardFactory;
    }

    @Override
    public void execute(FlashcardList flashcardList, Ui ui) throws UnrecognizedFlashcardTypeException {
        flashcardList.addFlashcard(flashcardFactory.create(OTHER_FLASHCARD_COMMAND));
    }
}
