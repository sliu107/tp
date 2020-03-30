package seedu.tp.commands;

import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.studyplan.StudyPlanList;
import seedu.tp.ui.Ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DisplayStudyPlanCommand extends Command {

    Ui ui;
    StudyPlanList studyPlanList;
    FlashcardList flashcardList;

    /**
     * Constructor for DisplayStudyPlanCommand.
     *
     * @param ui            the UI class to be used by the command
     * @param studyPlanList the study plan to be displayed
     * @param flashcardList the flashcard list to be used by the command
     */
    public DisplayStudyPlanCommand(Ui ui, StudyPlanList studyPlanList, FlashcardList flashcardList) {
        assert ui != null : "Invalid null Ui!";
        assert studyPlanList != null : "Invalid null StudyPlan!";
        assert flashcardList != null : "Invalid null FlashcardList!";

        this.ui = ui;
        this.studyPlanList = studyPlanList;
        this.flashcardList = flashcardList;
    }

    @Override
    public CommandFeedback execute() {
        LOGGER.info("Executing DisplayStudyPlanCommand...");
        StringBuilder feedback = new StringBuilder();
        List<Map.Entry<LocalDate, List<Integer>>> studyPlans = studyPlanList.getStudyPlanList();
        for (Map.Entry<LocalDate, List<Integer>> studyPlanForDay : studyPlans) {
            feedback.append("Date: " + studyPlanForDay.getKey() + System.lineSeparator());
            for (int index : studyPlanForDay.getValue()) {
                try {
                    Flashcard flashcard = flashcardList.getFlashcardAtIdx(index);
                    feedback.append((index + 1) + ": " + flashcard.getName()
                            + " | Reviewed: " + flashcard.getReviewIcon()
                            + " | " + flashcard.getPriorityAsString() + System.lineSeparator());
                } catch (IndexOutOfBoundsException e) {
                    index++;
                    feedback.append("Flashcard with index " + index + " not found. "
                            + "Did you delete this flashcard?" + System.lineSeparator());
                }
            }
        }
        return new CommandFeedback(feedback.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DisplayStudyPlanCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        DisplayStudyPlanCommand otherDisplayStudyPlanCommand = (DisplayStudyPlanCommand) obj;
        return this.ui.equals(otherDisplayStudyPlanCommand.ui)
            & this.studyPlanList.equals(otherDisplayStudyPlanCommand.studyPlanList)
            & this.flashcardList.equals(otherDisplayStudyPlanCommand.flashcardList);
    }
}
