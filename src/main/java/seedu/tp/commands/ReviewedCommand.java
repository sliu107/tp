package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.ui.Ui;

/**
 * Command to mark a flashcard as Reviewed.
 */
public class ReviewedCommand extends Command {
    private FlashcardList flashcardList;
    private int index;
    private Ui ui;

    /**
     * Constructor for ReviewedCommand.
     *
     * @param flashcardList list containing all flashcards
     * @param index index of the flashcard to show
     * @param ui instance for user interaction
     */
    public ReviewedCommand(FlashcardList flashcardList, int index, Ui ui) {
        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        try {
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(index);
            flashcard.setReviewStatus(true);
            ui.confirmFlashcardReview(flashcard);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }
}
