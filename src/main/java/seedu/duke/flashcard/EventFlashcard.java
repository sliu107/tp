package seedu.duke.flashcard;

import seedu.duke.ui.Ui;

import java.util.ArrayList;

/**
 * Event flashcard.
 */
public class EventFlashcard extends Flashcard {
    private String startDate;
    private String endDate;

    /**
     * Create an <code>EventFlashcard</code> by prompting the user to enter info.
     * @param ui used to prompt the user
     * @return the created <code>EventFlashcard</code>
     */
    public static EventFlashcard createEventFlashcard(Ui ui) {
        String name = ui.promptUser("Name", false);
        String startDate = ui.promptUser("Start date", false);
        String endDate = ui.promptUser("End date", true);
        String summary = ui.promptUser("Summary", false);
        ArrayList<String> details = new ArrayList<>();
        while (true) {
            String newDetail = ui.promptUser("Detail", true);
            if (newDetail == null) {
                break;
            }
            details.add(newDetail);
        }
        return new EventFlashcard(name, startDate, endDate, summary, details);
    }

    /**
     * Construct an <code>EventFlashcard</code>.
     */
    public EventFlashcard(String name, String startDate, String endDate, String summary, ArrayList<String> details) {
        super(name, summary, details);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Get the string representation of this flashcard.
     * @return string representation
     */
    @Override
    public String toString() {
        String stringRepresentation = "";
        stringRepresentation += (name + System.lineSeparator());
        stringRepresentation += startDate;
        if (endDate != null) {
            stringRepresentation += (" - " + endDate);
        }
        stringRepresentation += (System.lineSeparator() + System.lineSeparator());
        stringRepresentation += summary + System.lineSeparator();
        for (String detail : details) {
            stringRepresentation += ("* " + detail + System.lineSeparator());
        }
        return stringRepresentation;
    }
}
