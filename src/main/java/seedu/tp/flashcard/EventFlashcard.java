package seedu.tp.flashcard;

import seedu.tp.ui.Ui;

import java.util.List;

import static seedu.tp.utils.Constants.END_DATE_FIELD;
import static seedu.tp.utils.Constants.NAME_FIELD;
import static seedu.tp.utils.Constants.START_DATE_FIELD;
import static seedu.tp.utils.Constants.SUMMARY_FIELD;

/**
 * Event flashcard.
 */
public class EventFlashcard extends Flashcard {
    private String startDate;
    private String endDate;

    /**
     * Constructs an <code>EventFlashcard</code>.
     */
    public EventFlashcard(String name, String startDate, String endDate, String summary, List<String> details) {
        super(name, summary, details);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Creates an <code>EventFlashcard</code>  by prompting the user to enter info.
     *
     * @param ui used to prompt the user
     * @return the created <code>EventFlashcard</code>
     */
    public static EventFlashcard createEventFlashcard(Ui ui) {
        String name = ui.promptUserForRequiredField(NAME_FIELD);
        String startDate = ui.promptUserForRequiredField(START_DATE_FIELD);
        String endDate = ui.promptUserForRequiredField(END_DATE_FIELD);
        String summary = ui.promptUserForRequiredField(SUMMARY_FIELD);
        List<String> details = ui.promptUserForDetails();
        return new EventFlashcard(name, startDate, endDate, summary, details);
    }

    /**
     * Get the start date of this event flashcard.
     *
     * @return the start date of this event flashcard
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Get the end date of this event flashcard.
     *
     * @return the end date of this event flashcard
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Gets the string representation of event flashcard.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event name: ").append(name).append(System.lineSeparator());
        stringBuilder.append("Event period: ").append(startDate).append("-")
                .append(endDate).append(System.lineSeparator());
        stringBuilder.append("Summary: ").append(summary).append(System.lineSeparator());
        stringBuilder.append("Details: ").append(System.lineSeparator());
        stringBuilder.append(getDetailsString(details));
        return stringBuilder.toString();
    }

    /**
     * Check if the current instance is equal to the object passed in.
     *
     * @param obj The object to be compared against the current instance
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EventFlashcard)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        // Will have to make sure in the future to check for null here if we make other optional fields.
        EventFlashcard otherEventFlashcard = (EventFlashcard) obj;
        return super.equals(obj) && startDate.equals(otherEventFlashcard.getStartDate())
                && endDate.equals(otherEventFlashcard.getEndDate());
    }
}