package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.ui.Ui;

public class ShowCommand extends Command {

    private FlashcardList flashcardList;
    private int index;
    private Ui ui;

    public ShowCommand(FlashcardList flashcardList, int index, Ui ui) {
        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        try {
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(index - 1);
            ui.showFlashcard(flashcard);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }
}