package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;

/**
 * HelpCommand class to print the help message which shows the list of possible user commands.
 */
public class HelpCommand extends Command {
    private static final String NEWLINE = System.lineSeparator();
    private static String helpMessage = "Followings are the formats of commands used in the main menu:" + NEWLINE
            + "1. Add an event flashcard: event" + NEWLINE
            + "2. Add a person flashcard: person" + NEWLINE
            + "3. Add an other flashcard: other" + NEWLINE
            + "4. List out all the flashcards: list" + NEWLINE
            + "5. List the flashcards in time order: timeline" + NEWLINE
            + "6. Set the priority of an existing flashcard: priority i/INDEX p/PRIORITY" + NEWLINE
            + "   (Note: There are 4 priority levels: LOW, MEDIUM, HIGH, DEFAULT)" + NEWLINE
            + "7. Set an existing flashcard as reviewed: reviewed i/INDEX" + NEWLINE
            + "8. Show the detailed information of an existing flashcard: show i/INDEX" + NEWLINE
            + "9. Delete a flashcard from the flashcard list: delete i/INDEX" + NEWLINE
            + "10. Set up a new flashcard group: group" + NEWLINE
            + "11. Add a flashcard to an existing group: add" + NEWLINE
            + "12. To exit the History Flashcard: bye" + NEWLINE
            + "Then please follow the instruction given by the program in each situation." + NEWLINE
            + "(Note: Whenever requiring a date you should pick one of the following format:"
            + "       d M yyyy, M yyyy, yyyy, d/M/yyyy, M/yyyy, d-M-yyyy, M-yyyy)";


    @Override
    public CommandFeedback execute() throws HistoryFlashcardException {
        LOGGER.info("Showing the help message");
        return new CommandFeedback(helpMessage);
    }
}
