package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Command to configure priority level of a flashcard.
 */
public class PriorityCommand extends Command {
    private FlashcardList flashcardList;
    private int index;
    private Ui ui;
    private Flashcard.PriorityLevel pl;

    /**
     * Constructor for the PriorityCommand
     *
     * @param flashcardList list containing all flashcards
     * @param index index of the flashcard to show
     * @param ui instance for user interaction
     * @param pl priority level to set the flashcard to
     */
    public PriorityCommand(FlashcardList flashcardList, int index, Ui ui, Flashcard.PriorityLevel pl) {
        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
        this.pl = pl;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        try {
            flashcardList.getFlashcardAtIdx(index).setPriorityLevel(pl);
            ui.confirmFlashcardPriority(flashcardList.getFlashcardAtIdx(index));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }
}
