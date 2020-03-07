package seedu.tp.parser;

import seedu.tp.commands.AddFlashcardToGroupCommand;
import seedu.tp.commands.ByeCommand;
import seedu.tp.commands.Command;
import seedu.tp.commands.DeleteCommand;
import seedu.tp.commands.EventFlashcardCommand;
import seedu.tp.commands.GroupCommand;
import seedu.tp.commands.ListCommand;
import seedu.tp.commands.OtherFlashcardCommand;
import seedu.tp.commands.PersonFlashcardCommand;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.UnknownCommandException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;
import seedu.tp.ui.Ui;

import static seedu.tp.utils.Constants.Add_FLASHCARD_TO_GROUP_COMMAND;
import static seedu.tp.utils.Constants.BYE_COMMAND;
import static seedu.tp.utils.Constants.DELETE_COMMAND;
import static seedu.tp.utils.Constants.EVENT_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.GROUP_COMMAND;
import static seedu.tp.utils.Constants.LIST_COMMAND;
import static seedu.tp.utils.Constants.OTHER_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.PERSON_FLASHCARD_COMMAND;

/**
 * Parser class to handle parsing of user input.
 */
public class Parser {

    private FlashcardFactory flashcardFactory;
    private FlashcardList flashcardList;
    private GroupFactory groupFactory;
    private GroupList groupList;
    private Ui ui;

    /**
     * Constructs the Parser class.
     *
     * @param flashcardFactory flashcard factory to be passed in as argument to commands
     * @param flashcardList    flashcard list to be passed in as argument to commands
     * @param groupFactory  group factory to be passes in as argument to commands
     * @param groupList group list to be passed in as argument to commands
     * @param ui               UI to be passed in as argument to commands
     */
    public Parser(FlashcardFactory flashcardFactory, FlashcardList flashcardList,
                  GroupFactory groupFactory, GroupList groupList, Ui ui) {
        this.flashcardFactory = flashcardFactory;
        this.flashcardList = flashcardList;
        this.groupFactory = groupFactory;
        this.groupList = groupList;
        this.ui = ui;
    }

    /**
     * Parses user input and return the command parsed.
     *
     * @param userInput the user input
     * @return the command parsed from user input
     * @throws HistoryFlashcardException exception that occurred when parsing user input
     */
    public Command parseCommand(String userInput) throws HistoryFlashcardException {
        String[] splittedInput = userInput.split(" ", 2);
        String commandType = splittedInput[0].toLowerCase();

        switch (commandType) {
        case EVENT_FLASHCARD_COMMAND:
            return new EventFlashcardCommand(flashcardList, flashcardFactory);
        case PERSON_FLASHCARD_COMMAND:
            return new PersonFlashcardCommand(flashcardList, flashcardFactory);
        case OTHER_FLASHCARD_COMMAND:
            return new OtherFlashcardCommand(flashcardList, flashcardFactory);
        case LIST_COMMAND:
            return new ListCommand(flashcardList, ui);
        case DELETE_COMMAND:
            try {
                return new DeleteCommand(flashcardList, Integer.parseInt(splittedInput[1]) - 1);
            } catch (Exception e) {
                throw new InvalidFlashcardIndexException();
            }
        case GROUP_COMMAND:
            return new GroupCommand(flashcardList, groupFactory, groupList);
        case Add_FLASHCARD_TO_GROUP_COMMAND:
            return new AddFlashcardToGroupCommand(ui, groupList, flashcardList);
        case BYE_COMMAND:
            return new ByeCommand();
        default:
            throw new UnknownCommandException();
        }
    }
}
