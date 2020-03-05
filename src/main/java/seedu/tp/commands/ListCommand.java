package seedu.tp.commands;

import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(FlashcardList flashcardList, Ui ui) {
        ui.listAllFlashcards(flashcardList);
    }
}
