package seedu.duke.exceptions;

public class UnrecognizedFlashcardTypeException extends Exception {
    public UnrecognizedFlashcardTypeException(String errorMessage) {
        super(errorMessage);
    }
}
