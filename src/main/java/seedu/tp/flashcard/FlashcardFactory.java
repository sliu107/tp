package seedu.tp.flashcard;

import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.ui.Ui;

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
     *
     * @param flashcardType string representing type of flashcard to create
     * @return constructed <code>Flashcard</code>
     * @throws UnrecognizedFlashcardTypeException if the string is not a valid flashcard type
     */
    public Flashcard create(String flashcardType) throws UnrecognizedFlashcardTypeException {
        switch (flashcardType.toLowerCase()) {
        case "event":
            EventFlashcard eventFlashcard = EventFlashcard.createEventFlashcard(ui);
            ui.confirmFlashcardCreation(eventFlashcard);
            return eventFlashcard;
        case "person":
            PersonFlashcard personFlashcard = PersonFlashcard.createPersonFlashcard(ui);
            ui.confirmFlashcardCreation(personFlashcard);
            return personFlashcard;
        case "other":
            OtherFlashcard otherFlashcard = OtherFlashcard.createOtherFlashcard(ui);
            ui.confirmFlashcardCreation(otherFlashcard);
            return otherFlashcard;
        default:
            throw new UnrecognizedFlashcardTypeException("Flashcard types: event, person, other");
        }
    }
}
