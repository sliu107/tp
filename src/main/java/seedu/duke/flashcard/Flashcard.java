package seedu.duke.flashcard;

import java.util.ArrayList;

/**
 * Abstract flashcard class to represent basic properties of flashcard.
 */
public abstract class Flashcard {
    protected String name;
    protected String summary;
    protected ArrayList<String> details;

    protected Flashcard(String name, String summary, ArrayList<String> details) {
        this.name = name;
        this.summary = summary;
        this.details = details;
    }
}
