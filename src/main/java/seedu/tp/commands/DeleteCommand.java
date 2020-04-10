package seedu.tp.commands;

import seedu.tp.exceptions.DeletionFailedException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.storage.Savable;

public class DeleteCommand extends ModifyingCommand {

    private FlashcardList flashcardList;
    private int index;

    /**
     * Constructor for delete command.
     *
     * @param flashcardList flashcard list for the command to execute on
     * @param index         index in the delete command
     */
    public DeleteCommand(FlashcardList flashcardList, int index) {
        assert flashcardList != null : "Invalid null FlashcardList!";

        this.flashcardList = flashcardList;
        this.index = index;
    }

    /**
     * Gets index in the delete command.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the flashcard list in the delete command.
     *
     * @return the flashcard list
     */
    public FlashcardList getFlashcardList() {
        return flashcardList;
    }

    @Override
    public CommandFeedback execute() throws InvalidFlashcardIndexException {
        try {
            final Flashcard deletedFlashcard = flashcardList.getFlashcardAtIdx(index);
            LOGGER.info("Deleting flashcard at index: " + index);
            flashcardList.deleteFlashcard(index);
            LOGGER.info("Deleted flashcard at index: " + index);
            CommandFeedback deleteFeedback = delete(deletedFlashcard);
            String feedback = "The following flashcard has been deleted:" + System.lineSeparator()
                + deletedFlashcard;
            if (!deleteFeedback.isEmpty()) {
                feedback += deleteFeedback;
            }
            return new CommandFeedback(feedback);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.warning("IndexOutOfBoundsException occurred when deleting flashcard at index " + index);
            LOGGER.warning("Throwing InvalidFlashcardIndexException...");
            throw new InvalidFlashcardIndexException();
        }
    }

    private CommandFeedback delete(Savable savable) {
        try {
            storage.delete(savable);
            return new CommandFeedback();
        } catch (DeletionFailedException e) {
            LOGGER.warning("Delete to disk failed for " + savable.getFileName());
            return new CommandFeedback("Deletion could not be saved to disk. Sorry");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        DeleteCommand otherDeleteCommand = (DeleteCommand) obj;
        return otherDeleteCommand.getIndex() == this.index
            && otherDeleteCommand.getFlashcardList().equals(this.flashcardList);
    }
}
