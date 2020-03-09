package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.ui.Ui;

/**
 * Command to show the details of a specified flashcard.
 */
public class ShowCommand extends Command {

    private FlashcardList flashcardList;
    private int index;
    private Ui ui;

    /**
     * Constructor for the ShowCommand
     *
     * @param flashcardList list containing all flashcards
     * @param index index of the flashcard to show
     * @param ui instance for user interaction
     */
    public ShowCommand(FlashcardList flashcardList, int index, Ui ui) {
        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        try {
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(index);
            ui.showFlashcard(flashcard);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }
}