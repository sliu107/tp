package seedu.tp.commands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.tp.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.tp.utils.ExampleInputConstants.EMPTY_FLASHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.FULL_FLAHSHCARD_LIST;

public class ListCommandTest {
    private final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
    private final PrintStream backupStdout = System.out;

    @BeforeEach
    public void captureStdout() {
        System.setOut(new PrintStream(capturedOut));
    }

    @AfterEach
    public void restoreStdout() {
        System.setOut(backupStdout);
    }

    @Test
    public void listCommand_execute_listsFlashcardsSuccessfully() {
        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("Here's the list of flashcards you have:" + System.lineSeparator());
        expectedOutput.append("1: Event 1 | Reviewed: N | Not indicated" + System.lineSeparator());
        expectedOutput.append("2: Person 1 | Reviewed: N | Not indicated" + System.lineSeparator());
        expectedOutput.append("3: Title 1 | Reviewed: N | Not indicated" + System.lineSeparator());

        ListCommand listCommand = new ListCommand(FULL_FLAHSHCARD_LIST, new Ui());
        listCommand.execute();
        assertEquals(expectedOutput.toString(), capturedOut.toString());
    }

    @Test
    public void listCommand_executeEmptyList_listsFlashcardsSuccessfully() {
        String expectedOutput = "You have no flashcard at this moment!" + System.lineSeparator();
        ListCommand listCommand = new ListCommand(EMPTY_FLASHCARD_LIST, new Ui());
        listCommand.execute();
        assertEquals(expectedOutput, capturedOut.toString());
    }
}
