package seedu.tp.flashcard;

import java.util.List;

/**
 * Abstract flashcard class to represent basic properties of flashcard.
 */
public abstract class Flashcard {
    protected String name;
    protected String summary;
    protected List<String> details;

    protected Flashcard(String name, String summary, List<String> details) {
        this.name = name;
        this.summary = summary;
        this.details = details;
    }

    protected static String getDetailsString(List<String> details) {
        StringBuilder detailsStringBuilder = new StringBuilder();
        for (String detail : details) {
            detailsStringBuilder.append("* ").append(detail).append(System.lineSeparator());
        }
        return detailsStringBuilder.toString();
    }

    /**
     * Gets the name of the flashcard.
     *
     * @return the name of the flashcard
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the summary of the flashcard.
     *
     * @return the summary of the flashcard.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Gets the details of the flashcard.
     *
     * @return the details of the flashcard
     */
    public List<String> getDetails() {
        return details;
    }

    /**
     * Check if the current instance is equal to the object passed in.
     *
     * @param obj The object to be compared against the current instance
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Flashcard)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Flashcard otherFlashcard = (Flashcard) obj;
        return name.equals(otherFlashcard.getName()) && summary.equals(otherFlashcard.getSummary()) &&
                details.equals(otherFlashcard.getDetails());
    }
}
