package seedu.tp.commands;

import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Command to list all existing flashcards.
 */
public class ListCommand extends Command {

    private FlashcardList flashcardList;
    private Ui ui;

    public ListCommand(FlashcardList flashcardList, Ui ui) {
        this.flashcardList = flashcardList;
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.listAllFlashcards(flashcardList);
    }
}
