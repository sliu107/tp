package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

public class ResetReviewedCommand extends Command {
    private Ui ui;
    private FlashcardList flashcardList;
    
    public ResetReviewedCommand(Ui ui, FlashcardList flashcardList) {
        this.ui = ui;
        this.flashcardList = flashcardList;
    }
    
    @Override
    public void execute() throws HistoryFlashcardException {
        LOGGER.info("Resetting all the flashcards as unreviewed...");
        flashcardList.resetAsUnreviewed(ui);
        LOGGER.info("Reset all the flashcards as unreviewed.");
    }
}
