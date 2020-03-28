package seedu.tp.commands;

import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import java.util.List;
import java.util.Map;

public class ListReviewedCommand extends Command {

    private Ui ui;
    private FlashcardList flashcardList;

    /**
     * Constructor for ListReviewedCommand.
     *
     * @param flashcardList the flashcard list for the command to execute on
     * @param ui            the UI class for handling interaction with the user
     */
    public ListReviewedCommand(FlashcardList flashcardList, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.ui = ui;
        this.flashcardList = flashcardList;
    }

    @Override
    public void execute() {
        LOGGER.info("Executing ListReviewedCommand...");
        List<Map.Entry<Integer, Flashcard>> reviewedFlashcards = flashcardList.getAllReviewedFlashcards();
        ui.listAllReviewedFlashcardsWithId(reviewedFlashcards);
        LOGGER.info("Finished executing ListReviewedCommand!");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListReviewedCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        ListReviewedCommand otherListReviewedCommand = (ListReviewedCommand) obj;
        return this.ui.equals(otherListReviewedCommand.ui)
            & this.flashcardList.equals(otherListReviewedCommand.flashcardList);
    }
}
