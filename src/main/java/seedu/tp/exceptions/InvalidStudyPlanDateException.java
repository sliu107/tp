package seedu.tp.exceptions;

/**
 * Exception for invalid study plan date.
 */
public class InvalidStudyPlanDateException extends HistoryFlashcardException {

    public InvalidStudyPlanDateException(String errorMessage) {
        super(errorMessage);
    }
}
