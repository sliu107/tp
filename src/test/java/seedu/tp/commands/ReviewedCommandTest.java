package seedu.tp.commands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.tp.utils.ExampleInputConstants.EVENT_FLASHCARD;
import static seedu.tp.utils.ExampleInputConstants.PERSON_FLASHCARD;
import static seedu.tp.utils.ExampleInputConstants.OTHER_FLASHCARD;

public class ReviewedCommandTest {
    private final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
    private final PrintStream backupStdout = System.out;
    private List<Flashcard> flashcards = Arrays.asList(EVENT_FLASHCARD, PERSON_FLASHCARD, OTHER_FLASHCARD);
    private FlashcardList flashcardList = new FlashcardList(flashcards);

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

        ReviewedCommand reviewedCommand = new ReviewedCommand(flashcardList, 0, new Ui());
        reviewedCommand.execute();
        assertEquals(expectedOutput.toString(), capturedOut.toString());
    }
}
