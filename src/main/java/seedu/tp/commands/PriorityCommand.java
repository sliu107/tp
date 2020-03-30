package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.storage.Storage;
import seedu.tp.ui.Ui;

/**
 * Command to configure priority level of a flashcard.
 */
public class PriorityCommand extends ModifyingCommand {
    private FlashcardList flashcardList;
    private int index;
    private Ui ui;
    private Flashcard.PriorityLevel pl;

    /**
     * Constructor for the PriorityCommand.
     *
     * @param flashcardList list containing all flashcards
     * @param index         index of the flashcard to show
     * @param ui            instance for user interaction
     * @param pl            priority level to set the flashcard to
     */
    public PriorityCommand(FlashcardList flashcardList, int index, Ui ui, Flashcard.PriorityLevel pl) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
        this.pl = pl;
    }

    /**
     * Gets index in the priority command.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }


    /**
     * Gets the priority level in the priority command.
     *
     * @return the priority level
     */
    public Flashcard.PriorityLevel getPl() {
        return pl;
    }

    @Override
    public CommandFeedback execute() throws InvalidFlashcardIndexException {
        try {
            LOGGER.info("Setting the priority for the flashcard " + index + "...");
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(index);
            flashcard.setPriorityLevel(pl);
            LOGGER.info("Set the priority for the flashcard " + index);
            CommandFeedback saveFeedback = save(flashcard);
            String feedback = "Priority has been updated:" + System.lineSeparator()
                    + flashcard.getName() + " | New priority: " + flashcard.getPriorityAsString();
            if (!saveFeedback.isEmpty()) {
                feedback += saveFeedback;
            }
            return new CommandFeedback(feedback);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.warning("IndexOutOfBoundsException occurred when executing the priority command");
            throw new InvalidFlashcardIndexException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PriorityCommand)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        PriorityCommand otherPriorityCommand = (PriorityCommand) obj;
        return otherPriorityCommand.getIndex() == this.index
            && otherPriorityCommand.getPl().equals(this.pl);
    }
}
