package seedu.tp.commands;

import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Command to list all existing flashcards.
 */
public class ListCommand extends Command {

    private FlashcardList flashcardList;
    private Ui ui;

    /**
     * Constructor for list command.
     *
     * @param flashcardList flashcard list for the command to execute on
     * @param ui            the UI class to be used by the command
     */
    public ListCommand(FlashcardList flashcardList, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.flashcardList = flashcardList;
        this.ui = ui;
    }

    /**
     * Gets the flashcard list in the list command.
     *
     * @return the flashcard list
     */
    public FlashcardList getFlashcardList() {
        return flashcardList;
    }

    @Override
    public CommandFeedback execute() {
        LOGGER.info("Listing flashcards...");
        String feedback = getFeedback(flashcardList);
        return new CommandFeedback(feedback);
    }

    private String getFeedback(FlashcardList flashcardList) {
        if (flashcardList.isEmpty()) {
            return "You have no flashcard at this moment!";
        }

        StringBuilder feedback = new StringBuilder("Here's the list of flashcards you have:" + System.lineSeparator());
        for (int i = 0; i < flashcardList.getTotalFlashcardNum(); i++) {
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(i);
            String nextLine = (i + 1) + ": " + flashcard.getName() + " | Reviewed: " + flashcard.getReviewIcon()
                    + " | " + flashcard.getPriorityAsString() + System.lineSeparator();
            feedback.append(nextLine);
        }
        return feedback.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListCommand)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        ListCommand otherListCommand = (ListCommand) obj;
        return otherListCommand.getFlashcardList().equals(this.flashcardList);
    }
}
