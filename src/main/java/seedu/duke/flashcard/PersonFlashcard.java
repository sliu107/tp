package seedu.duke.flashcard;

import seedu.duke.ui.Ui;

import java.util.ArrayList;

/**
 * Person flashcard.
 */
public class PersonFlashcard extends Flashcard {
    private String birthDate;
    private String deathDate;

    /**
     * Create a <code>PersonFlashcard</code> by prompting the user to enter info.
     * @param ui used to prompt the user
     * @return the created <code>PersonFlashcard</code>
     */
    public static PersonFlashcard createPersonFlashcard(Ui ui) {
        String name = ui.promptUser("Name", false);
        String birthDate = ui.promptUser("Birth date", true);
        String deathDate = null;
        if (birthDate != null) {
            deathDate = ui.promptUser("Death date", true);
        }
        String summary = ui.promptUser("Summary", false);
        ArrayList<String> details = new ArrayList<>();
        while (true) {
            String newDetail = ui.promptUser("Detail", true);
            if (newDetail == null) {
                break;
            }
            details.add(newDetail);
        }
        return new PersonFlashcard(name, birthDate, deathDate, summary, details);
    }

    /**
     * Construct a <code>PersonFlashcard</code>.
     */
    public PersonFlashcard(String name, String birthDate, String deathDate, String summary, ArrayList<String> details) {
        super(name, summary, details);
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    /**
     * Get the string representation of this flashcard.
     * @return string representation
     */
    @Override
    public String toString() {
        String stringRepresentation = "";
        stringRepresentation += (name + System.lineSeparator());
        stringRepresentation += birthDate;
        if (deathDate != null) {
            stringRepresentation += (" - " + deathDate);
        }
        stringRepresentation += (System.lineSeparator() + System.lineSeparator());
        stringRepresentation += summary + System.lineSeparator();
        for (String detail : details) {
            stringRepresentation += ("* " + detail + System.lineSeparator());
        }
        return stringRepresentation;
    }
}
