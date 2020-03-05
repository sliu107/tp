package seedu.tp.parser;

import seedu.tp.commands.ByeCommand;
import seedu.tp.commands.Command;
import seedu.tp.commands.DeleteCommand;
import seedu.tp.commands.EventFlashcardCommand;
import seedu.tp.commands.ListCommand;
import seedu.tp.commands.OtherFlashcardCommand;
import seedu.tp.commands.PersonFlashcardCommand;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.UnknownCommandException;
import seedu.tp.flashcard.FlashcardFactory;

import static seedu.tp.utils.Constants.BYE_COMMAND;
import static seedu.tp.utils.Constants.DELETE_COMMAND;
import static seedu.tp.utils.Constants.EVENT_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.LIST_COMMAND;
import static seedu.tp.utils.Constants.OTHER_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.PERSON_FLASHCARD_COMMAND;

/**
 * Parser class to handle parsing of user input.
 */
public class Parser {

    private FlashcardFactory flashcardFactory;

    public Parser(FlashcardFactory flashcardFactory) {
        this.flashcardFactory = flashcardFactory;
    }

    /**
     * Parses user input and return the command parsed.
     *
     * @param userInput the user input
     * @return the command parsed from user input
     * @throws HistoryFlashcardException exception that occurred when parsing user input
     */
    public Command parseCommand(String userInput) throws HistoryFlashcardException {
        String[] array = userInput.split(" ", 2);
        String commandType = array[0].toLowerCase();

        switch (commandType) {
        case EVENT_FLASHCARD_COMMAND:
            return new EventFlashcardCommand(flashcardFactory);
        case PERSON_FLASHCARD_COMMAND:
            return new PersonFlashcardCommand(flashcardFactory);
        case OTHER_FLASHCARD_COMMAND:
            return new OtherFlashcardCommand(flashcardFactory);
        case LIST_COMMAND:
            return new ListCommand();
        case DELETE_COMMAND:
            try {
                return new DeleteCommand(Integer.parseInt(array[1]) - 1);
            } catch (Exception e) {
                throw new InvalidFlashcardIndexException();
            }
        case BYE_COMMAND:
            return new ByeCommand();
        default:
            throw new UnknownCommandException();
        }
    }
}
