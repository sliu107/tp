package seedu.tp.commands;

import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;

import java.util.List;
import java.util.Map;

public class ListReviewedCommand extends Command {

    private FlashcardList flashcardList;

    /**
     * Constructor for ListReviewedCommand.
     *
     * @param flashcardList the flashcard list for the command to execute on
     */
    public ListReviewedCommand(FlashcardList flashcardList) {
        assert flashcardList != null : "Invalid null FlashcardList!";

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
        feedback.append(System.lineSeparator());
        for (int i = 0; i < flashcardListWithId.size(); i++) {
            Map.Entry<Integer, Flashcard> flashcardEntry = flashcardListWithId.get(i);
            feedback.append((i + 1) + ": " + flashcardEntry.getValue().getName()
                + " | Reviewed: " + flashcardEntry.getValue().getReviewIcon()
                + " | " + flashcardEntry.getValue().getPriorityAsString()
                + " | ID: " + (flashcardEntry.getKey() + 1));
            feedback.append(System.lineSeparator());
        }
        return feedback.toString().trim();
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
        return this.flashcardList.equals(otherListReviewedCommand.flashcardList);
    }
}
