package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

public class ReviewedCommand extends Command {
    private FlashcardList flashcardList;
    private int index;
    private Ui ui;

    public ReviewedCommand (FlashcardList flashcardList, int index, Ui ui) {
        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        try {
            flashcardList.getFlashcardAtIdx(index).setReviewStatus(true);
            ui.confirmFlashcardReview(flashcardList.getFlashcardAtIdx(index));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }
}
