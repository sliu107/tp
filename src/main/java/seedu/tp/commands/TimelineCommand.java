package seedu.tp.commands;

import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Command to show a timeline for the existing flashcards.
 */
public class TimelineCommand extends Command {
    private FlashcardList flashcardList;
    private Ui ui;

    /**
     * Constructor for TimelineCommand.
     *
     * @param flashcardList     list containing all flashcards
     * @param ui                instance for user interaction
     */
    public TimelineCommand(FlashcardList flashcardList, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.flashcardList = flashcardList;
        this.ui = ui;
    }

    private String getFeedback(FlashcardList flashcardList) {
        if (flashcardList.isEmpty()) {
            return "You have no flashcard at this moment!";
        }

        List<Flashcard> flashcards = new ArrayList<>(flashcardList.getFlashcards());
        Collections.sort(flashcards);
        StringBuilder feedback = new StringBuilder("Here's an ordered list of the flashcards you have:");
        feedback.append(System.lineSeparator());
        for (Flashcard f : flashcards) {
            feedback.append(f.toString());
            feedback.append(System.lineSeparator());
        }
        return feedback.toString();
    }

    @Override
    public CommandFeedback execute() {
        LOGGER.info("Listing the flashcards in time order...");
        String feedback = getFeedback(flashcardList);
        return new CommandFeedback(feedback);
    }
}
