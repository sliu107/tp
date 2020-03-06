package seedu.tp.commands;

/**
 * Bye command used in the application.
 */
public class ByeCommand extends Command {

    @Override
    public void execute() {

    }

    /**
     * Checks whether the command is a bye command.
     *
     * @return Boolean value true value since this is a bye command.
     */
    @Override
    public boolean isBye() {
        return true;
    }
}
