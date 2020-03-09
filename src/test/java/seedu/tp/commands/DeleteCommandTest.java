package seedu.tp.commands;

import org.junit.jupiter.api.Test;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.FlashcardList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.tp.utils.ExampleInputConstants.EMPTY_FLASHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.EVENT_FLASHCARD;
import static seedu.tp.utils.ExampleInputConstants.FULL_FLAHSHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.OTHER_FLASHCARD;

public class DeleteCommandTest {

    @Test
    public void execute_delete_successful() throws InvalidFlashcardIndexException {
        FlashcardList expectedFlashcardList = new FlashcardList();
        expectedFlashcardList.addFlashcard(EVENT_FLASHCARD);
        expectedFlashcardList.addFlashcard(OTHER_FLASHCARD);

        FlashcardList flashcardList = FULL_FLAHSHCARD_LIST;
        DeleteCommand deleteCommand = new DeleteCommand(flashcardList, 1);
        deleteCommand.execute();

        assertEquals(expectedFlashcardList, flashcardList);
    }

    @Test
    public void execute_deleteFromEmptyList_throwsInvalidFlashcardIndexException() {
        DeleteCommand deleteCommand = new DeleteCommand(EMPTY_FLASHCARD_LIST, 1);
        assertThrows(
            InvalidFlashcardIndexException.class,
            deleteCommand::execute,
            "Expected InvalidFlashcardIndexException"
        );
    }

    @Test
    public void execute_deleteNegativeIndex_throwsInvalidFlashcardIndexException() {
        DeleteCommand deleteCommand = new DeleteCommand(FULL_FLAHSHCARD_LIST, -10);
        assertThrows(
            InvalidFlashcardIndexException.class,
            deleteCommand::execute,
            "Expected InvalidFlashcardIndexException"
        );
    }

    @Test
    public void execute_deleteOutOfBoundIndex_throwsInvalidFlashcardIndexException() {
        DeleteCommand deleteCommand = new DeleteCommand(FULL_FLAHSHCARD_LIST, 100);
        assertThrows(
            InvalidFlashcardIndexException.class,
            deleteCommand::execute,
            "Expected InvalidFlashcardIndexException"
        );
    }
}
