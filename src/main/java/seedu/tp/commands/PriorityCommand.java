package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

public class PriorityCommand extends Command {
    private FlashcardList flashcardList;
    private int index;
    private Ui ui;
    private int priorityLevel;

    public PriorityCommand (FlashcardList flashcardList, int index, Ui ui, int priorityLevel) {
        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
        this.priorityLevel = priorityLevel;
    }

    @Override
    public void execute() throws InvalidFlashcardIndexException {
        try {
            flashcardList.getFlashcardAtIdx(index).setPriorityLevel(priorityLevel);
            ui.confirmFlashcardPriority(flashcardList.getFlashcardAtIdx(index));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }
}
