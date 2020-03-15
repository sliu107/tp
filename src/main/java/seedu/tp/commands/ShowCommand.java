package seedu.tp.commands;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Command to show the details of a specified flashcard.
 */
public class ShowCommand extends Command {

    private FlashcardList flashcardList;
    private int index;
    private Ui ui;

    /**
     * Constructor for the ShowCommand.
     *
     * @param flashcardList list containing all flashcards
     * @param index         index of the flashcard to show
     * @param ui            instance for user interaction
     */
    public ShowCommand(FlashcardList flashcardList, int index, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.flashcardList = flashcardList;
        this.index = index;
        this.ui = ui;
    }

    /**
     * Gets index in the show command.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ShowCommand)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        ShowCommand otherShowCommand = (ShowCommand) obj;
        return otherShowCommand.getIndex() == this.index;
    }
}