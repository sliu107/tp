package seedu.duke.flashcard;

import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class OtherFlashcard extends Flashcard {
    public static OtherFlashcard createOtherFlashcard() {
        Ui ui = new Ui();
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

    public OtherFlashcard(String name, String summary, ArrayList<String> details) {
        super(name, summary, details);
    }

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
