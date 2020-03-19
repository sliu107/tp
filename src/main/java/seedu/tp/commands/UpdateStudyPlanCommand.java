package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.studyplan.StudyPlan;
import seedu.tp.ui.Ui;

public class UpdateStudyPlanCommand extends Command {

    private Ui ui;
    private StudyPlan studyPlan;
    private FlashcardList flashcardList;

    /**
     * Constructor for UpdateStudyPlanCommand.
     *
     * @param ui        the UI class to be used in the command
     * @param studyPlan the Study Plan to be updated
     */
    public UpdateStudyPlanCommand(Ui ui, StudyPlan studyPlan, FlashcardList flashcardList) {
        this.ui = ui;
        this.studyPlan = studyPlan;
        this.flashcardList = flashcardList;
    }

    @Override
    public void execute() throws HistoryFlashcardException {
        LOGGER.info("Executing UpdateStudyPlanCommand...");
        studyPlan.updateStudyPlan(ui, flashcardList);
        LOGGER.info("UpdateStudyPlanCommand executed!");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UpdateStudyPlanCommand)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        UpdateStudyPlanCommand otherUpdateStudyPlanCommand = (UpdateStudyPlanCommand) obj;
        return this.ui.equals(otherUpdateStudyPlanCommand.ui)
            & this.studyPlan.equals(otherUpdateStudyPlanCommand.studyPlan)
            & this.flashcardList.equals(otherUpdateStudyPlanCommand.flashcardList);
    }
}
