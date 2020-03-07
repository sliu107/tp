package seedu.tp.group;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

/**
 * Group factory class to create flashcard group given string.
 */
public class GroupFactory {
    private Ui ui;
    private FlashcardList flashcardList;

    public GroupFactory(Ui ui, FlashcardList flashcardList){
        this.ui = ui;
        this.flashcardList = flashcardList;
    }

    public FlashcardGroup form() throws InvalidFlashcardIndexException {
        FlashcardGroup group = FlashcardGroup.createGroup(ui, flashcardList);
        ui.confirmFlashcardGroupCreation(group);
        return group;
    }
}
