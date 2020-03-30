package seedu.tp.commands;

import jdk.jfr.Event;
import seedu.tp.flashcard.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import seedu.tp.exceptions.InvalidDateFormatException;
import seedu.tp.parser.Parser;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static seedu.tp.utils.Constants.BULLET_POINT;

/**
 * Command to show a timeline for the existing flashcards.
 */
public class TimelineCommand extends Command {
    private FlashcardList flashcardList;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Constructor for TimelineCommand.
     *
     * @param flashcardList     list containing all flashcards
     */
    public TimelineCommand(FlashcardList flashcardList) {
        assert flashcardList != null : "Invalid null FlashcardList!";

        this.flashcardList = flashcardList;
        this.startDate = null;
        this.endDate = null;
    }

    /**
     * Constructor for TimelineCommand.
     *
     * @param flashcardList list containing all flashcards
     * @param startDate     the date to start listing flashcards from (inclusive)
     * @param endDate       the date after which to stop listing flashcards from
     */
    public TimelineCommand(FlashcardList flashcardList, String startDate, String endDate) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert startDate != null : "Invalid null startDate!";
        assert endDate != null : "Invalid null endDate!";

        try {
            this.startDate = Parser.parseDate(startDate);
            this.endDate = Parser.parseDate(endDate);
            List<Flashcard> filteredFlashcardList = flashcardList.getFlashcards().stream()
                    .filter(flashcard -> isValidFlashcard(flashcard)).collect(Collectors.toList());
            this.flashcardList = new FlashcardList(filteredFlashcardList);
        } catch (InvalidDateFormatException e) {
            System.out.println("That date format couldn't be parsed!");
        }
    }

    private boolean isValidFlashcard(Flashcard f) {
        LocalDate cardStartDate;
        if (f instanceof EventFlashcard) {
            EventFlashcard eventFlashcard = (EventFlashcard) f;
            cardStartDate = eventFlashcard.getStartDate();
        } else if (f instanceof PersonFlashcard) {
            PersonFlashcard personFlashcard = (PersonFlashcard) f;
            cardStartDate = personFlashcard.getBirthDate();
        } else {
            return false;
        }

        if (cardStartDate.compareTo(this.startDate) >= 0 && cardStartDate.compareTo(this.endDate) <= 0) {
            return true;
        } else {
            return false;
        }
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
            feedback.append(BULLET_POINT + f.getShortDescription());
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
