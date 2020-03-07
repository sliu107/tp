package seedu.tp.flashcard;

import java.util.List;

/**
 * Abstract flashcard class to represent basic properties of flashcard.
 */
public abstract class Flashcard {
    protected String name;
    protected String summary;
    protected List<String> details;
    protected boolean isReviewed;
    protected int priorityLevel;

    protected Flashcard(String name, String summary, List<String> details) {
        this.name = name;
        this.summary = summary;
        this.details = details;
        this.isReviewed = false;
        this.priorityLevel = 0;
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
     * @param priorityLevel priority level to be set
     */
    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * Returns the number of "*"s based on flashcard's priority level.
     *
     * @return "*"s to indicate priority level
     */
    public String getPriority() {
        switch (priorityLevel) {
        case 1:
            return "*";
        case 2:
            return "**";
        case 3:
            return "***";
        case 4:
            return "****";
        case 5:
            return "*****";
        default:
            return "Not indicated";
        }
    }
}
