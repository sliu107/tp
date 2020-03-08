package seedu.tp.parser;

import seedu.tp.commands.ByeCommand;
import seedu.tp.commands.Command;
import seedu.tp.commands.DeleteCommand;
import seedu.tp.commands.EventFlashcardCommand;
import seedu.tp.commands.ListCommand;
import seedu.tp.commands.OtherFlashcardCommand;
import seedu.tp.commands.PersonFlashcardCommand;
import seedu.tp.commands.TimelineCommand;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidDateFormatException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.UnknownCommandException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Date;

import static seedu.tp.utils.Constants.BYE_COMMAND;
import static seedu.tp.utils.Constants.DELETE_COMMAND;
import static seedu.tp.utils.Constants.EVENT_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.LIST_COMMAND;
import static seedu.tp.utils.Constants.OTHER_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.PERSON_FLASHCARD_COMMAND;
import static seedu.tp.utils.Constants.TIMELINE_COMMAND;

/**
 * Parser class to handle parsing of user input.
 */
public class Parser {
    private FlashcardFactory flashcardFactory;
    private FlashcardList flashcardList;
    private Ui ui;

    /**
     * Constructs the Parser class.
     *
     * @param flashcardFactory flashcard factory to be passed in as argument to commands
     * @param flashcardList    flashcard list to be passed in as argument to commands
     * @param ui               UI to be passed in as argument to commands
     */
    public Parser(FlashcardFactory flashcardFactory, FlashcardList flashcardList, Ui ui) {
        this.flashcardFactory = flashcardFactory;
        this.flashcardList = flashcardList;
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
        case TIMELINE_COMMAND:
            return new TimelineCommand(flashcardList, ui);
        case BYE_COMMAND:
            return new ByeCommand();
        default:
            throw new UnknownCommandException();
        }
    }

    /**
     * Attempt to parse a string representing a date by matching it with formatters.
     * 
     * @param date the string to be parsed
     * @return LocalDate if the string was parsable, null if not
     */
    public static LocalDate parseDate(String date) throws InvalidDateFormatException {
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
            } catch (DateTimeParseException e) {
                continue;
            }
        }
        throw new InvalidDateFormatException();
    }
    
    public static String localDateToString(LocalDate localDate) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        return localDate.format(formatter);
    }
}
