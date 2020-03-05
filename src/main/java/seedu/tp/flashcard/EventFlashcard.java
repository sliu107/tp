package seedu.tp.flashcard;

import seedu.tp.ui.Ui;

import java.util.ArrayList;

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
    public EventFlashcard(String name, String startDate, String endDate, String summary, ArrayList<String> details) {
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
        ArrayList<String> details = promptUserForDetails(ui);
        return new EventFlashcard(name, startDate, endDate, summary, details);
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
}
