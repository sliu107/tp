package seedu.tp.commands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.tp.utils.ExampleInputConstants.FULL_FLASHCARD_LIST;
import static seedu.tp.flashcard.Flashcard.PriorityLevel;

public class PriorityCommandTest {
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
    public void priorityCommand_execute_setDefaultPrioritySuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedEventOutputDefault = new StringBuilder();
        expectedEventOutputDefault.append("Priority has been updated:" + System.lineSeparator());
        expectedEventOutputDefault.append("Event 1 | New priority: Not indicated" + System.lineSeparator());

        PriorityCommand priorityCommand = new PriorityCommand(FULL_FLASHCARD_LIST, 0, new Ui(), PriorityLevel.DEFAULT);
        priorityCommand.execute();
        assertEquals(expectedEventOutputDefault.toString(), capturedOut.toString());
    }

    @Test
    public void priorityCommand_execute_setHighPrioritySuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedEventOutputHigh = new StringBuilder();
        expectedEventOutputHigh.append("Priority has been updated:" + System.lineSeparator());
        expectedEventOutputHigh.append("Event 1 | New priority: ***" + System.lineSeparator());

        PriorityCommand priorityCommand = new PriorityCommand(FULL_FLASHCARD_LIST, 0, new Ui(), PriorityLevel.HIGH);
        priorityCommand.execute();
        assertEquals(expectedEventOutputHigh.toString(), capturedOut.toString());
    }

    @Test
    public void priorityCommand_execute_setMediumPrioritySuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedPersonOutput = new StringBuilder();
        expectedPersonOutput.append("Priority has been updated:" + System.lineSeparator());
        expectedPersonOutput.append("Person 1 | New priority: **" + System.lineSeparator());

        PriorityCommand priorityCommand = new PriorityCommand(FULL_FLASHCARD_LIST, 1, new Ui(), PriorityLevel.MEDIUM);
        priorityCommand.execute();
        assertEquals(expectedPersonOutput.toString(), capturedOut.toString());
    }

    @Test
    public void priorityCommand_execute_setLowPrioritySuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedOtherOutput = new StringBuilder();
        expectedOtherOutput.append("Priority has been updated:" + System.lineSeparator());
        expectedOtherOutput.append("Title 1 | New priority: *" + System.lineSeparator());

        PriorityCommand priorityCommand = new PriorityCommand(FULL_FLASHCARD_LIST, 2, new Ui(), PriorityLevel.LOW);
        priorityCommand.execute();
        assertEquals(expectedOtherOutput.toString(), capturedOut.toString());
    }
}
