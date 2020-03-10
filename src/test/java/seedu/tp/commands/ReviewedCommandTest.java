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

public class ReviewedCommandTest {
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
    public void reviewedCommand_execute_setReviewStatusSuccessfully() throws InvalidFlashcardIndexException {
        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("You have marked the following flashcard as Reviewed:" + System.lineSeparator());
        expectedOutput.append("Event 1" + System.lineSeparator());

        ReviewedCommand reviewedCommand = new ReviewedCommand(FULL_FLASHCARD_LIST, 0, new Ui());
        reviewedCommand.execute();
        assertEquals(expectedOutput.toString(), capturedOut.toString());
    }
}
