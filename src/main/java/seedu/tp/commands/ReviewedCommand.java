package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
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
     * @param index         index of the flashcard to show
     * @param ui            instance for user interaction
     */
    public ReviewedCommand(FlashcardList flashcardList, int index, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
    }

    /**
     * Gets index in the reviewed command.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ReviewedCommand)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        ReviewedCommand otherReviewedCommand = (ReviewedCommand) obj;
        return otherReviewedCommand.getIndex() == this.index;
    }
}
