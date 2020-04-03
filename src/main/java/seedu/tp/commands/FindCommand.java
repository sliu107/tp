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
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";
        assert keyword != null : "Invalid null keyword!";

        this.flashcardList = flashcardList;
        this.ui = ui;
        this.keyword = keyword;
    }

    @Override
    public CommandFeedback execute() {
        LOGGER.info("Executing FindCommand...");
        List<Map.Entry<Integer, Flashcard>> flashcardsWithKeyword = flashcardList.getAllFlashcardsWithKeyword(keyword);
        String feedback = getFeedback(flashcardsWithKeyword);
        return new CommandFeedback(feedback);
    }

    private String getFeedback(List<Map.Entry<Integer, Flashcard>> flashcardListWithId) {
        if (flashcardListWithId.isEmpty()) {
            return "You have no flashcard matching your query!";
        }

        StringBuilder feedback = new StringBuilder("Here's the list of flashcards you are looking for:");
        feedback.append(System.lineSeparator());
        for (int i = 0; i < flashcardListWithId.size(); i++) {
            Map.Entry<Integer, Flashcard> flashcardEntry = flashcardListWithId.get(i);
            feedback.append((i + 1) + ": " + flashcardEntry.getValue().getName()
                + " | Reviewed: " + flashcardEntry.getValue().getReviewIcon()
                + " | " + flashcardEntry.getValue().getPriorityAsString()
                + " | ID: " + (flashcardEntry.getKey() + 1));
            feedback.append(System.lineSeparator());
        }
        return feedback.toString().trim();
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
