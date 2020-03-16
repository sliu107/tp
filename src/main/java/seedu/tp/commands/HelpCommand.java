package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.ui.Ui;

/**
 * HelpCommand class to print the help message which shows the list of possible user commands.
 */
public class HelpCommand extends Command {
    Ui ui;

    /**
     * Constructor for HelpCommand.
     *
     * @param ui the instance for user interaction
     */
    public HelpCommand(Ui ui) {
        assert ui != null : "Invalid null Ui!";

        this.ui = ui;
    }

    @Override
    public void execute() throws HistoryFlashcardException {
        ui.sendHelpMessage();
        LOGGER.info("Showed the help message");
    }
}
