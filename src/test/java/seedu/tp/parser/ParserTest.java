package seedu.tp.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.tp.commands.ByeCommand;
import seedu.tp.commands.Command;
import seedu.tp.commands.DeleteCommand;
import seedu.tp.commands.EventFlashcardCommand;
import seedu.tp.commands.ListCommand;
import seedu.tp.commands.OtherFlashcardCommand;
import seedu.tp.commands.PersonFlashcardCommand;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidDateFormatException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Solution below referenced and adopted from:
// https://github.com/se-edu/addressbook-level2/blob/master/test/java/seedu/addressbook/parser/ParserTest.java
public class ParserTest {

    private Parser parser;

    /**
     * Initializes a new Parser for each test case.
     */
    @BeforeEach
    public void setUp() {
        Ui ui = new Ui();
        FlashcardFactory flashcardFactory = new FlashcardFactory(ui);
        FlashcardList flashcardList = new FlashcardList();
        parser = new Parser(flashcardFactory, flashcardList, ui);
    }

    @Test
    public void parse_eventFlashcardCommand_lowerCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("event");
        assertTrue(command instanceof EventFlashcardCommand);
    }

    @Test
    public void parse_eventFlashcardCommand_mixedCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("EveNt");
        assertTrue(command instanceof EventFlashcardCommand);
    }

    @Test
    public void parse_personFlashcardCommand_lowerCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("person");
        assertTrue(command instanceof PersonFlashcardCommand);
    }

    @Test
    public void parse_personFlashcardCommand_mixedCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("pERson");
        assertTrue(command instanceof PersonFlashcardCommand);
    }

    @Test
    public void parse_otherFlashcardCommand_lowerCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("other");
        assertTrue(command instanceof OtherFlashcardCommand);
    }

    @Test
    public void parse_otherFlashcardCommand_mixedCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("oThER");
        assertTrue(command instanceof OtherFlashcardCommand);
    }

    @Test
    public void parse_listCommand_lowerCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("list");
        assertTrue(command instanceof ListCommand);
    }

    @Test
    public void parse_listCommand_mixedCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("LISt");
        assertTrue(command instanceof ListCommand);
    }

    @Test
    public void parse_deleteCommand_lowerCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("delete 1");
        assertTrue(command instanceof DeleteCommand);
    }

    @Test
    public void parse_deleteCommand_mixedCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("dELEte 1");
        assertTrue(command instanceof DeleteCommand);
    }

    @Test
    public void parse_deleteCommand_wrongNumberFormat() {
        // Solution below adopted from:
        // https://stackoverflow.com/questions/40268446/junit-5-how-to-assert-an-exception-is-thrown
        assertThrows(
            InvalidFlashcardIndexException.class, 
            () -> parser.parseCommand("delete random"),
            "Expected InvalidFlashcardIndexException"
        );
    }

    @Test
    public void parse_byeCommand_lowerCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("bye");
        assertTrue(command instanceof ByeCommand);
    }

    @Test
    public void parse_byeCommand_mixedCaseCorrect() throws HistoryFlashcardException {
        Command command = parser.parseCommand("ByE");
        assertTrue(command instanceof ByeCommand);
    }

    @Test
    public void parse_dateStrings_successfully() throws InvalidDateFormatException {
        String[] dateStrings = {
            "31 07 1999",
            "31 7 1999",
            "3 7 1999",
            "03 7 1843",
            "07 0413",
            "1942",
            "1/8/2012",
            "6/2012",
            "1-8-2012",
            "8-2012"
        };
        
        LocalDate[] expectedLocalDates = {
            LocalDate.of(1999, 7, 31),
            LocalDate.of(1999, 7, 31),
            LocalDate.of(1999, 7, 3),
            LocalDate.of(1843, 7, 3),
            LocalDate.of(413, 7, 1),
            LocalDate.of(1942, 1, 1),
            LocalDate.of(2012, 8, 1),
            LocalDate.of(2012, 6, 1),
            LocalDate.of(2012, 8, 1),
            LocalDate.of(2012, 8, 1)
        };
        
        for (int i = 0; i < dateStrings.length; i++) {
            LocalDate actualLocalDate = Parser.parseDate(dateStrings[i]);
            assertEquals(expectedLocalDates[i], actualLocalDate);
        }
    }

    @Test
    public void parse_invalidDateStrings_throwsInvalidDateFormatException() {
        String[] invalidDateStrings = {
            "asdf",
            "31 13 1999",
            "32 12 1234",
            "07 413",
            "33 02 0512",
            "July 31 1999",
            "31/17 1999",
            "31/7-1999",
            "31 7-1999"
        };
        
        for (String invalidDateString : invalidDateStrings) {
            assertThrows(
                InvalidDateFormatException.class,
                () -> Parser.parseDate(invalidDateString)
            );
        }
    }
}
