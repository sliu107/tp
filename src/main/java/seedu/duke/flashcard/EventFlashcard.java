package seedu.duke.flashcard;

import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class EventFlashcard extends Flashcard {
    private String startDate;
    private String endDate;

    public static EventFlashcard createEventFlashcard() {
        Ui ui = new Ui();
        String name = ui.promptUser("Name", false);
        String startDate = ui.promptUser("Start date", false);
        String endDate = ui.promptUser("End date", true);
        String summary = ui.promptUser("Summary", false);
        ArrayList<String> details = new ArrayList<>();
        while (true) {
            String newDetail = ui.promptUser("Detail", true);
            if (newDetail == null) {
                break;
            }
            details.add(newDetail);
        }
        return new EventFlashcard(name, startDate, endDate, summary, details);
    }

    public EventFlashcard(String name, String startDate, String endDate, String summary, ArrayList<String> details) {
        super(name, summary, details);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        String stringRepresentation = "";
        stringRepresentation += (name + System.lineSeparator());
        stringRepresentation += startDate;
        if (endDate != null) {
            stringRepresentation += (" - " + endDate);
        }
        stringRepresentation += (System.lineSeparator() + System.lineSeparator());
        stringRepresentation += summary + System.lineSeparator();
        for (String detail : details) {
            stringRepresentation += ("* " + detail + System.lineSeparator());
        }
        return stringRepresentation;
    }
}
