package seedu.duke.flashcard;

import seedu.duke.exceptions.UnrecognizedFlashcardTypeException;

public class FlashcardFactory {
    public Flashcard create(String flashcardType) throws UnrecognizedFlashcardTypeException {
        switch(flashcardType.toLowerCase()) {
        case "event":
            return EventFlashcard.createEventFlashcard();
        case "person":
            return PersonFlashcard.createPersonFlashcard();
        case "other":
            return OtherFlashcard.createOtherFlashcard();
        default:
            throw new UnrecognizedFlashcardTypeException("Flashcard types: event, person, other");
        }
    }
}
