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
}
