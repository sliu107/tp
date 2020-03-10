package seedu.tp.commands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.*;
import seedu.tp.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.tp.utils.ExampleInputConstants.*;
import java.time.LocalDate;

public class ShowCommandTest {
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
    public void showCommand_execute_showEventFlashcardSuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedEventOutput = new StringBuilder();
        expectedEventOutput.append("These are the flashcard details:" + System.lineSeparator());
        expectedEventOutput.append("Event name: Event 1" + System.lineSeparator());
        expectedEventOutput.append("Event period: July 31, 1843-December 25, 1892" + System.lineSeparator());
        expectedEventOutput.append("Summary: This is an event summary" + System.lineSeparator());
        expectedEventOutput.append("Details:" + System.lineSeparator());
        expectedEventOutput.append(DETAILS_BULLET_FORM + System.lineSeparator());

        ShowCommand showCommand = new ShowCommand(FULL_FLASHCARD_LIST, 0, new Ui());
        showCommand.execute();
        assertEquals(expectedEventOutput.toString(), capturedOut.toString());
    }

    @Test
    public void showCommand_execute_showPersonFlashcardSuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedPersonOutput = new StringBuilder();
        expectedPersonOutput.append("These are the flashcard details:" + System.lineSeparator());
        expectedPersonOutput.append("Person name: Person 1" + System.lineSeparator());
        expectedPersonOutput.append("Born: July 31, 1843" + System.lineSeparator());
        expectedPersonOutput.append("Died: December 25, 1892" + System.lineSeparator());
        expectedPersonOutput.append("Summary: This is a person's summary" + System.lineSeparator());
        expectedPersonOutput.append("Details:" + System.lineSeparator());
        expectedPersonOutput.append(DETAILS_BULLET_FORM + System.lineSeparator());

        ShowCommand showCommand = new ShowCommand(FULL_FLASHCARD_LIST, 1, new Ui());
        showCommand.execute();
        assertEquals(expectedPersonOutput.toString(), capturedOut.toString());
    }

    @Test
    public void showCommand_execute_showOtherFlashcardSuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedOtherOutput = new StringBuilder();
        expectedOtherOutput.append("These are the flashcard details:" + System.lineSeparator());
        expectedOtherOutput.append("Title: Title 1" + System.lineSeparator());
        expectedOtherOutput.append("Summary: This is a summary" + System.lineSeparator());
        expectedOtherOutput.append("Details:" + System.lineSeparator());
        expectedOtherOutput.append(DETAILS_BULLET_FORM + System.lineSeparator());

        ShowCommand showCommand = new ShowCommand(FULL_FLASHCARD_LIST, 2, new Ui());
        showCommand.execute();
        assertEquals(expectedOtherOutput.toString(), capturedOut.toString());
    }

    @Test
    public void showCommand_getFlashcardFromInvalidIndex_throwsInvalidFlashcardIndexException() {
        FlashcardList flashcardList = new FlashcardList();
        flashcardList.addFlashcard(new OtherFlashcard(NAME, SUMMARY, DETAILS));
        Ui ui = new Ui();
        ShowCommand showCommand = new ShowCommand(flashcardList, 1, ui);
        assertThrows(
                InvalidFlashcardIndexException.class,
                showCommand::execute,
                "Expected InvalidFlashcardIndexException"
        );
    }
}
