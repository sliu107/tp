package seedu.tp.flashcard;

import seedu.tp.ui.Ui;

import java.util.ArrayList;

import static seedu.tp.utils.Constants.NAME_FIELD;
import static seedu.tp.utils.Constants.SUMMARY_FIELD;

/**
 * Other flashcard.
 */
public class OtherFlashcard extends Flashcard {
    /**
     * Constructs an <code>OtherFlashcard</code>.
     */
    public OtherFlashcard(String name, String summary, ArrayList<String> details) {
        super(name, summary, details);
    }

    /**
     * Creates an <code>OtherFlashcard</code> by prompting the user to enter info.
     *
     * @param ui used to prompt the user
     * @return the created <code>OtherFlashcard</code>
     */
    public static OtherFlashcard createOtherFlashcard(Ui ui) {
        String name = ui.promptUserForRequiredField(NAME_FIELD);
        String summary = ui.promptUserForRequiredField(SUMMARY_FIELD);
        ArrayList<String> details = promptUserForDetails(ui);
        return new OtherFlashcard(name, summary, details);
    }

    /**
     * Gets the string representation of this flashcard.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Title: ").append(name).append(System.lineSeparator());
        stringBuilder.append("Summary: ").append(summary).append(System.lineSeparator());
        stringBuilder.append("Details: ").append(System.lineSeparator());
        stringBuilder.append(getDetailsString(details));
        return stringBuilder.toString();
    }
}
