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
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Solution below referenced and adopted from:
// https://github.com/se-edu/addressbook-level2/blob/master/test/java/seedu/addressbook/parser/ParserTest.java
public class ParserTest {

    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser(new FlashcardFactory(new Ui()));
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
}
