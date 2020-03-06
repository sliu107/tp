package seedu.tp.flashcard;

import seedu.tp.ui.Ui;

import java.util.List;

import static seedu.tp.utils.Constants.BIRTH_DATE_FIELD;
import static seedu.tp.utils.Constants.DEATH_DATE_FIELD;
import static seedu.tp.utils.Constants.NAME_FIELD;
import static seedu.tp.utils.Constants.SUMMARY_FIELD;

/**
 * Person flashcard.
 */
public class PersonFlashcard extends Flashcard {
    private String birthDate;
    private String deathDate;

    /**
     * Constructs a <code>PersonFlashcard</code>.
     */
    public PersonFlashcard(String name, String birthDate, String deathDate, String summary, List<String> details) {
        super(name, summary, details);
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    /**
     * Creates a <code>PersonFlashcard</code> by prompting the user to enter info.
     *
     * @param ui used to prompt the user
     * @return the created <code>PersonFlashcard</code>
     */
    public static PersonFlashcard createPersonFlashcard(Ui ui) {
        String name = ui.promptUserForRequiredField(NAME_FIELD);
        String birthDate = ui.promptUserForRequiredField(BIRTH_DATE_FIELD);
        String deathDate = ui.promptUserForRequiredField(DEATH_DATE_FIELD);
        String summary = ui.promptUserForRequiredField(SUMMARY_FIELD);
        List<String> details = ui.promptUserForDetails();
        return new PersonFlashcard(name, birthDate, deathDate, summary, details);
    }

    /**
     * Gets the string representation of this flashcard.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Person name: ").append(name).append(System.lineSeparator());
        stringBuilder.append("Born: ").append(birthDate).append(System.lineSeparator());
        stringBuilder.append("Died: ").append(deathDate).append(System.lineSeparator());
        stringBuilder.append("Summary: ").append(summary).append(System.lineSeparator());
        stringBuilder.append("Details: ").append(System.lineSeparator());
        stringBuilder.append(getDetailsString(details));
        return stringBuilder.toString();
    }
}
