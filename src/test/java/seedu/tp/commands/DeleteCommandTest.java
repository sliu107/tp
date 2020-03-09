package seedu.tp.commands;

import org.junit.jupiter.api.Test;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.EventFlashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.flashcard.OtherFlashcard;
import seedu.tp.flashcard.PersonFlashcard;
import seedu.tp.ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.tp.utils.ExampleInputConstants.END_DATE;
import static seedu.tp.utils.ExampleInputConstants.END_LOCAL_DATE;
import static seedu.tp.utils.ExampleInputConstants.START_DATE;
import static seedu.tp.utils.ExampleInputConstants.START_LOCAL_DATE;

public class DeleteCommandTest {
    private static final FlashcardList EMPTY_FLASHCARD_LIST = new FlashcardList();
    private static Ui UI = new Ui();
    private static List<String> DETAILS_LIST = createFlashcardDetailsList();
    private static final EventFlashcard EVENT_FLASHCARD = new EventFlashcard(
            "Event 1",
            START_LOCAL_DATE,
            END_LOCAL_DATE,
            "This is an event summary",
            DETAILS_LIST
    );
    private static final PersonFlashcard PERSON_FLASHCARD = new PersonFlashcard(
            "Person 1",
            START_LOCAL_DATE,
            END_LOCAL_DATE,
            "This is a person's summmary",
            DETAILS_LIST
    );
    private static final OtherFlashcard OTHER_FLASHCARD = new OtherFlashcard(
            "Title 1",
            "This is a summary",
            DETAILS_LIST
    );

    private static FlashcardList createFullFlashcardList() {
        FlashcardList flashcardList = new FlashcardList();
        flashcardList.addFlashcard(EVENT_FLASHCARD);
        flashcardList.addFlashcard(PERSON_FLASHCARD);
        flashcardList.addFlashcard(OTHER_FLASHCARD);
        return flashcardList;
    }

    private static List<String> createFlashcardDetailsList() {
        List<String> details = new ArrayList<>();
        details.add("Detail 1");
        details.add("Detail 2");
        details.add("Detail 3");
        return details;
    }

    @Test
    public void execute_delete_successful() throws InvalidFlashcardIndexException {
        FlashcardList expectedFlashcardList = new FlashcardList();
        expectedFlashcardList.addFlashcard(EVENT_FLASHCARD);
        expectedFlashcardList.addFlashcard(OTHER_FLASHCARD);

        FlashcardList flashcardList = createFullFlashcardList();
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
        DeleteCommand deleteCommand = new DeleteCommand(createFullFlashcardList(), -10);
        assertThrows(
                InvalidFlashcardIndexException.class,
                deleteCommand::execute,
                "Expected InvalidFlashcardIndexException"
        );
    }

    @Test
    public void execute_deleteOutOfBoundIndex_throwsInvalidFlashcardIndexException() {
        DeleteCommand deleteCommand = new DeleteCommand(createFullFlashcardList(), 100);
        assertThrows(
                InvalidFlashcardIndexException.class,
                deleteCommand::execute,
                "Expected InvalidFlashcardIndexException"
        );
    }
}
