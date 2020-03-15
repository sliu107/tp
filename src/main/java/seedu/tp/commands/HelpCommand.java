package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.ui.Ui;

public class HelpCommand extends Command {
    Ui ui;

    public HelpCommand(Ui ui) {
        assert ui != null : "Invalid null Ui!";

        this.ui = ui;
    }

    @Override
    public void execute() throws HistoryFlashcardException {
        ui.sendHelpMessage();
    }
}
