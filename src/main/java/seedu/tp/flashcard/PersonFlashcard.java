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
     * Get the birth date of this person flashcard.
     *
     * @return the birth date of this person flashcard
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Get the death date of this person flashcard.
     *
     * @return the death date of this person flashcard
     */
    public String getDeathDate() {
        return deathDate;
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

    /**
     * Check if the current instance is equal to the object passed in.
     *
     * @param obj The object to be compared against the current instance
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PersonFlashcard)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        // Will have to make sure in the future to check for null here if we make other optional fields.
        PersonFlashcard otherEventFlashcard = (PersonFlashcard) obj;
        return super.equals(obj) && birthDate.equals(otherEventFlashcard.getBirthDate())
                && deathDate.equals(otherEventFlashcard.getDeathDate());
    }
}
