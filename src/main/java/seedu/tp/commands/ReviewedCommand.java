package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.storage.Storage;
import seedu.tp.ui.Ui;

/**
 * Command to mark a flashcard as Reviewed.
 */
public class ReviewedCommand extends ModifyingCommand {
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
    public CommandFeedback execute() throws InvalidFlashcardIndexException {
        try {
            LOGGER.info("Setting flashcard " + index + " as reviewed...");
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(index);
            flashcard.setReviewStatus(true);
            LOGGER.info("Set flashcard " + index + " as reviewed");
            CommandFeedback saveFeedback = save(flashcard);
            String feedback = "You have marked the following flashcard as Reviewed:" + System.lineSeparator()
                    + flashcard.getName();
            if (!saveFeedback.isEmpty()) {
                feedback += saveFeedback;
            }
            return new CommandFeedback(feedback);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.warning("InvalidFlashcardIndexException occurred when executing the reviewed command");
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
