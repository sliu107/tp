package seedu.tp.commands;

/**
 * Bye command used in the application.
 */
public class ByeCommand extends Command {

    @Override
    public CommandFeedback execute() {
        return null;
    }

    /**
     * Checks whether the command is a bye command.
     *
     * @return Boolean value true value since this is a bye command.
     */
    @Override
    public boolean isBye() {
        LOGGER.info("Ready to quit the program...");
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ByeCommand;
    }
}
