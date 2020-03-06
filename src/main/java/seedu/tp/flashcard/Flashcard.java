package seedu.tp.flashcard;

import seedu.tp.ui.Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static seedu.tp.utils.Constants.DETAIL_FIELD;

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

    protected static List<String> promptUserForDetails(Ui ui) {
        List<String> details = new ArrayList<>();
        Optional<String> newDetailOptional = ui.promptUserForOptionalField(DETAIL_FIELD);
        while (newDetailOptional.isPresent()) {
            details.add(newDetailOptional.get());
            newDetailOptional = ui.promptUserForOptionalField(DETAIL_FIELD);
        }
        return details;
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
