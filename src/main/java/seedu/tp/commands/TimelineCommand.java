package seedu.tp.commands;

import seedu.tp.exceptions.InvalidDateFormatException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.parser.Parser;
import seedu.tp.ui.Ui;

import java.time.LocalDate;

/**
 * Command to show a timeline for the existing flashcards.
 */
public class TimelineCommand extends Command {
    private FlashcardList flashcardList;
    private Ui ui;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Constructor for TimelineCommand.
     *
     * @param flashcardList list containing all flashcards
     * @param ui            instance for user interaction
     */
    public TimelineCommand(FlashcardList flashcardList, Ui ui) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";

        this.flashcardList = flashcardList;
        this.ui = ui;
        this.startDate = null;
        this.endDate = null;
    }

    /**
     * Constructor for TimelineCommand.
     *
     * @param flashcardList list containing all flashcards
     * @param ui            instance for user interaction
     * @param startDate     the date to start listing flashcards from (inclusive)
     * @param endDate       the date after which to stop listing flashcards from
     */
    public TimelineCommand(FlashcardList flashcardList, Ui ui, String startDate, String endDate) {
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert ui != null : "Invalid null Ui!";
        assert startDate != null : "Invalid null startDate!";
        assert endDate != null : "Invalid null endDate!";

        this.flashcardList = flashcardList;
        this.ui = ui;
        try {
            this.startDate = Parser.parseDate(startDate);
            this.endDate = Parser.parseDate(endDate);
        } catch (InvalidDateFormatException e) {
            System.out.println("That date format couldn't be parsed!");
        }
    }

    @Override
    public void execute() {
        LOGGER.info("Listing the flashcards in order sorted by time...");
        ui.listAllFlashcardsOrdered(flashcardList, startDate, endDate);
        LOGGER.info("Listed the flashcards in order sorted by time.");
    }
}
