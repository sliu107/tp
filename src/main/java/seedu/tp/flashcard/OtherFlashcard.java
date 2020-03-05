package seedu.tp.flashcard;

import seedu.tp.ui.Ui;

import java.util.ArrayList;

/**
 * Other flashcard.
 */
public class OtherFlashcard extends Flashcard {
    /**
     * Create an <code>OtherFlashcard</code> by prompting the user to enter info.
     * @param ui used to prompt the user
     * @return the created <code>OtherFlashcard</code>
     */
    public static OtherFlashcard createOtherFlashcard(Ui ui) {
        String name = ui.promptUser("Name", false);
        String summary = ui.promptUser("Summary", false);
        ArrayList<String> details = new ArrayList<>();
        while (true) {
            String newDetail = ui.promptUser("Detail", true);
            if (newDetail == null) {
                break;
            }
            details.add(newDetail);
        }
        return new OtherFlashcard(name, summary, details);
    }

    /**
     * Construct an <code>OtherFlashcard</code>.
     */
    public OtherFlashcard(String name, String summary, ArrayList<String> details) {
        super(name, summary, details);
    }

    /**
     * Get the string representation of this flashcard.
     * @return string representation
     */
    @Override
    public String toString() {
        String stringRepresentation = "";
        stringRepresentation += (name + System.lineSeparator() + System.lineSeparator());
        stringRepresentation += summary + System.lineSeparator();
        for (String detail : details) {
            stringRepresentation += ("* " + detail + System.lineSeparator());
        }
        return stringRepresentation;
    }
}
