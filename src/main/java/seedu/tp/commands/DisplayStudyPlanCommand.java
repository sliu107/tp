package seedu.tp.commands;

import seedu.tp.flashcard.FlashcardList;
import seedu.tp.studyplan.StudyPlanList;
import seedu.tp.ui.Ui;

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
    public void execute() {
        LOGGER.info("Executing DisplayStudyPlanCommand...");
        ui.displayStudyPlan(studyPlanList, flashcardList);
        LOGGER.info("DisplayStudyPlanCommand executed!");
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
