package seedu.tp.flashcard;

import java.time.LocalDate;
import java.util.List;

/**
 * Abstract flashcard class to represent basic properties of flashcard.
 */
public abstract class Flashcard implements Comparable<Flashcard> {
    protected String name;
    protected String summary;
    protected List<String> details;
    protected boolean isReviewed;

    public enum priorityLevel {
        LOW,
        MEDIUM,
        HIGH,
        DEFAULT
    }
    protected priorityLevel pl;

    protected Flashcard(String name, String summary, List<String> details) {
        this.name = name;
        this.summary = summary;
        this.details = details;
        this.isReviewed = false;
        this.pl = priorityLevel.DEFAULT;
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
     * Sets the review status of the flashcard.
     *
     * @param isReviewed true if flashcard has been reviewed
     */
    public void setReviewStatus (boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    /**
     * Returns icon based on flashcard's review status.
     *
     * @return "Y" for Yes if reviewed, else "N" for No.
     */
    public String getReviewIcon() {
        return (isReviewed ? "Y" : "N");
    }

    /**
     * Sets the flashcard's priority level.
     *
     * @param pl priority level to be set
     */
    public void setPriorityLevel(priorityLevel pl) {
        this.pl = pl;
    }

    /**
     * Returns the number of "*"s based on flashcard's priority level.
     *
     * @return "*"s to indicate priority level
     */
    public String getPriorityAsString() {
        switch (pl) {
        case LOW:
            return "*";
        case MEDIUM:
            return "**";
        case HIGH:
            return "***";
        default:
            return "Not indicated";
        }
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
        return name.equals(otherFlashcard.getName()) && summary.equals(otherFlashcard.getSummary())
                && details.equals(otherFlashcard.getDetails());
    }
    
    @Override
    public abstract int compareTo(Flashcard flashcard);
}
