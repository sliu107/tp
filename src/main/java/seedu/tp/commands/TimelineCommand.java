package seedu.tp.commands;

import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Command to show a timeline for the existing flashcards.
 */
public class TimelineCommand extends Command {
    private FlashcardList flashcardList;
    private Ui ui;

    /**
     * Constructor for TimelineCommand.
     *
     * @param flashcardList     list containing all flashcards
     * @param ui                instance for user interaction
     */
    public TimelineCommand(FlashcardList flashcardList, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.flashcardList = flashcardList;
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.listAllFlashcardsOrdered(flashcardList);
    }
}
