package seedu.tp.commands;

import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import java.util.List;
import java.util.Map;

public class FindCommand extends Command {

    FlashcardList flashcardList;
    Ui ui;
    String keyword;

    /**
     * Constructor for FindCommand.
     *
     * @param flashcardList the flashcard list to be used by the command
     * @param ui            the Ui to be used for interaction with user
     * @param keyword       the specified keyword
     */
    public FindCommand(FlashcardList flashcardList, Ui ui, String keyword) {
        this.flashcardList = flashcardList;
        this.ui = ui;
        this.keyword = keyword;
    }

    @Override
    public void execute() {
        List<Map.Entry<Integer, Flashcard>> flashcardsWithKeyword = flashcardList.getAllFlashcardsWithKeyword(keyword);
        ui.listAllFlashcardsWithId(flashcardsWithKeyword);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FindCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        FindCommand otherFindCommand = (FindCommand) obj;
        return this.ui.equals(otherFindCommand.ui)
            & this.flashcardList.equals(otherFindCommand.flashcardList)
            & this.keyword.equals(otherFindCommand.keyword);
    }
}
