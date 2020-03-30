package seedu.tp.parser;

import seedu.tp.commands.AddFlashcardToGroupCommand;
import seedu.tp.commands.ByeCommand;
import seedu.tp.commands.Command;
import seedu.tp.commands.DeleteCommand;
import seedu.tp.commands.EventFlashcardCommand;
import seedu.tp.commands.GroupCommand;
import seedu.tp.commands.HelpCommand;
import seedu.tp.commands.ListCommand;
import seedu.tp.commands.OtherFlashcardCommand;
import seedu.tp.commands.PersonFlashcardCommand;
import seedu.tp.commands.PriorityCommand;
import seedu.tp.commands.ReviewedCommand;
import seedu.tp.commands.ShowCommand;
import seedu.tp.commands.TimelineCommand;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidDateFormatException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.InvalidInputFormatException;
import seedu.tp.exceptions.UnknownCommandException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;
import seedu.tp.storage.Storage;
import seedu.tp.ui.Ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.tp.utils.Constants.ADD_FLASHCARD_TO_GROUP_COMMAND;
import static seedu.tp.utils.Constants.BYE_COMMAND;
import static seedu.tp.utils.Constants.DELETE_COMMAND;
import static seedu.tp.utils.Constants.EMPTY_SPACE;
import static seedu.tp.utils.Constants.EVENT_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.GROUP_COMMAND;
import static seedu.tp.utils.Constants.HELP_COMMAND;
import static seedu.tp.utils.Constants.LIST_COMMAND;
import static seedu.tp.utils.Constants.LOG_FOLDER;
import static seedu.tp.utils.Constants.OTHER_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.PERSON_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.PRIORITY_COMMAND;
import static seedu.tp.utils.Constants.REVIEWED_COMMAND;
import static seedu.tp.utils.Constants.SHOW_COMMAND;
import static seedu.tp.utils.Constants.TIMELINE_COMMAND;

/**
 * Parser class to handle parsing of user input.
 */
public class Parser {

    private static final String FILE_PATH = LOG_FOLDER + "parser.log";
    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());

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
     * @param groupFactory     group factory to be passes in as argument to commands
     * @param groupList        group list to be passed in as argument to commands
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
     * Set up the Parser logger. Call once at the start of the program.
     *
     * @throws IOException when logger set up failed
     */
    public static void setupLogger() throws IOException {
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);
        FileHandler fileHandler = new FileHandler(FILE_PATH, true);
        fileHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileHandler);
    }

    /**
     * Attempt to parse a string representing a date by matching it with formatters.
     *
     * @param date the string to be parsed
     * @return LocalDate if the string was parsable, null if not
     */
    public static LocalDate parseDate(String date) throws InvalidDateFormatException {
        assert date != null : "Invalid null date!";

        final DateTimeFormatter[] dateTimeFormatters = {
            DateTimeFormatter.ofPattern("d M yyyy"),
            new DateTimeFormatterBuilder()
                .appendPattern("M yyyy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter(),
            new DateTimeFormatterBuilder()
                .appendPattern("yyyy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .toFormatter(),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            new DateTimeFormatterBuilder()
                .appendPattern("M/yyyy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter(),
            DateTimeFormatter.ofPattern("d-M-yyyy"),
            new DateTimeFormatterBuilder()
                .appendPattern("M-yyyy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter(),
        };

        for (DateTimeFormatter formatter : dateTimeFormatters) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeParseException ignored) {
                continue;
            }
        }

        LOGGER.warning("User entered invalid date time: ");
        LOGGER.warning(date);
        throw new InvalidDateFormatException();
    }

    /**
     * Converts local date type object to string representation.
     *
     * @param localDate the local date object
     * @return string representation of the LocalDate object
     */
    public static String localDateToString(LocalDate localDate) {
        assert localDate != null : "Invalid null LocalDate!";

        final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.US);
        return localDate.format(formatter);
    }

    /**
     * Parses user input and return the command parsed.
     *
     * @param userInput the user input
     * @return the command parsed from user input
     * @throws HistoryFlashcardException exception that occurred when parsing user input
     */
    public Command parseCommand(String userInput) throws HistoryFlashcardException {
        assert userInput != null : "Invalid null user input!";

        String[] splitInput = userInput.split(EMPTY_SPACE, 3);
        String commandType = splitInput[0].toLowerCase();

        switch (commandType) {
        case EVENT_FLASHCARD_COMMAND:
            return new EventFlashcardCommand(flashcardList, flashcardFactory);
        case PERSON_FLASHCARD_COMMAND:
            return new PersonFlashcardCommand(flashcardList, flashcardFactory);
        case OTHER_FLASHCARD_COMMAND:
            return new OtherFlashcardCommand(flashcardList, flashcardFactory);
        case LIST_COMMAND:
            return new ListCommand(flashcardList);
        case SHOW_COMMAND:
            try {
                return new ShowCommand(flashcardList, Integer.parseInt(splitInput[1]) - 1);
            } catch (IndexOutOfBoundsException e) {
                LOGGER.warning("InvalidFlashcardIndexException occurred when parsing: " + userInput);
                throw new InvalidFlashcardIndexException();
            }
        case REVIEWED_COMMAND:
            return new ReviewedCommand(flashcardList, Integer.parseInt(splitInput[1]) - 1);
        case DELETE_COMMAND:
            try {
                return new DeleteCommand(flashcardList, Integer.parseInt(splitInput[1]) - 1);
            } catch (NumberFormatException e) {
                LOGGER.warning("InvalidFlashcardIndexException occurred when parsing: " + userInput);
                throw new InvalidFlashcardIndexException();
            }
        case PRIORITY_COMMAND:
            try {
                Flashcard.PriorityLevel pl = Flashcard.PriorityLevel.valueOf(splitInput[2]);
                return new PriorityCommand(flashcardList, Integer.parseInt(splitInput[1]) - 1, pl);
            } catch (NumberFormatException e) {
                LOGGER.warning("InvalidFlashcardIndexException occurred when parsing: " + userInput);
                throw new InvalidFlashcardIndexException();
            } catch (IllegalArgumentException e) {
                throw new InvalidInputFormatException();
            }
        case TIMELINE_COMMAND:
            return new TimelineCommand(flashcardList);
        case GROUP_COMMAND:
            return new GroupCommand(groupFactory, groupList);
        case ADD_FLASHCARD_TO_GROUP_COMMAND:
            return new AddFlashcardToGroupCommand(ui, groupList, flashcardList);
        case HELP_COMMAND:
            return new HelpCommand();
        case BYE_COMMAND:
            return new ByeCommand();
        default:
            LOGGER.warning("UnknownCommandException occurred when parsing: " + userInput);
            throw new UnknownCommandException();
        }
    }
}
