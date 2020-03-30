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
    public CommandFeedback execute() {
        LOGGER.info("Executing ListReviewedCommand...");
        List<Map.Entry<Integer, Flashcard>> reviewedFlashcards = flashcardList.getAllReviewedFlashcards();
        String feedback = getFeedback(reviewedFlashcards);
        return new CommandFeedback(feedback);
    }

    private String getFeedback(List<Map.Entry<Integer, Flashcard>> flashcardListWithId) {
        if (flashcardListWithId.isEmpty()) {
            return "You have no reviewed flashcards! " + "Use \"reviewed [INDEX]\" to mark a flashcard as reviewed.";
        }

        StringBuilder feedback = new StringBuilder("Here's the list of reviewed flashcards:");
        for (int i = 0; i < flashcardListWithId.size(); i++) {
            Map.Entry<Integer, Flashcard> flashcardEntry = flashcardListWithId.get(i);
            feedback.append((i + 1) + ": " + flashcardEntry.getValue().getName()
                    + " | Reviewed: " + flashcardEntry.getValue().getReviewIcon()
                    + " | " + flashcardEntry.getValue().getPriorityAsString()
                    + " | ID: " + (flashcardEntry.getKey() + 1));
        }
        return feedback.toString();
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
