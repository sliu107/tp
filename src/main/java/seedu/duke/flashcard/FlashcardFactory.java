package seedu.duke.flashcard;

import seedu.duke.exceptions.UnrecognizedFlashcardTypeException;
import seedu.duke.ui.Ui;

/**
 * Flashcard factory class to create flashcards given string.
 */
public class FlashcardFactory {
    private Ui ui;

    public FlashcardFactory(Ui ui) {
        this.ui = ui;
    }

    /**
     * Create a <code>Flashcard</code> given a string.
     * @param flashcardType string representing type of flashcard to create
     * @return constructed <code>Flashcard</code>
     * @throws UnrecognizedFlashcardTypeException if the string is not a valid flashcard type
     */
    public Flashcard create(String flashcardType) throws UnrecognizedFlashcardTypeException {
        switch (flashcardType.toLowerCase()) {
        case "event":
            return EventFlashcard.createEventFlashcard(ui);
        case "person":
            return PersonFlashcard.createPersonFlashcard(ui);
        case "other":
            return OtherFlashcard.createOtherFlashcard(ui);
        default:
            throw new UnrecognizedFlashcardTypeException("Flashcard types: event, person, other");
        }
    }
}
