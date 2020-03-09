package seedu.tp.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import seedu.tp.flashcard.EventFlashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.flashcard.OtherFlashcard;
import seedu.tp.flashcard.PersonFlashcard;

public class ExampleInputConstants {
    public static final String FLASHCARD_NAME = "Example flashcard name";
    public static final String GROUP_NAME = "Example flashcard group name";
    public static final String UNIONIZED_GROUP_NAME = "blah blah blah";
    public static final String DESCRIPTION = "Example description";
    public static final String START_DATE = "31 07 1843";
    public static final String END_DATE = "25 12 1892";
    public static final LocalDate START_LOCAL_DATE = LocalDate.of(1843, 7, 31);
    public static final LocalDate END_LOCAL_DATE = LocalDate.of(1892, 12, 25);
    public static final String SUMMARY = "Example summary";
    public static final String DETAIL_1 = "Detail 1";
    public static final String DETAIL_2 = "Detail 2";
    public static final List<String> DETAILS = Arrays.asList(DETAIL_1, DETAIL_2);
    public static final String INDEX_1 = "2";
    public static final String INDEX_2 = "-1";
    public static final String INDEXES_1 = "1 3";
    public static final String INDEXES_2 = "1 2 3";
    public static final String INVALID_INDEXES = "0 -1 5";
    public static final FlashcardList FLASHCARD_LIST = new FlashcardList()
            .addFlashcard(new EventFlashcard(FLASHCARD_NAME, START_LOCAL_DATE, END_LOCAL_DATE, SUMMARY, DETAILS))
            .addFlashcard(new PersonFlashcard(FLASHCARD_NAME, START_LOCAL_DATE, END_LOCAL_DATE, SUMMARY, DETAILS))
            .addFlashcard(new OtherFlashcard(FLASHCARD_NAME, SUMMARY, DETAILS));
    public static final String NEWLINE = System.lineSeparator();
    public static final String FULL_SIMULATED_INPUT = FLASHCARD_NAME + NEWLINE
            + START_DATE + NEWLINE
            + END_DATE + NEWLINE
            + SUMMARY + NEWLINE
            + DETAIL_1 + NEWLINE
            + DETAIL_2 + NEWLINE
            + NEWLINE;
    public static final String PARTIAL_SIMULATED_INPUT = FLASHCARD_NAME + NEWLINE
            + SUMMARY + NEWLINE
            + DETAIL_1 + NEWLINE
            + DETAIL_2 + NEWLINE
            + NEWLINE;
    public static final String SIMULATED_GROUP_COMMAND_INPUT_1 = GROUP_NAME + NEWLINE
            + DESCRIPTION + NEWLINE
            + INDEXES_1 + NEWLINE
            + NEWLINE;
    public static final String SIMULATED_GROUP_COMMAND_INPUT_2 = GROUP_NAME + NEWLINE
            + DESCRIPTION + NEWLINE
            + INVALID_INDEXES + NEWLINE
            + NEWLINE;
    public static final String SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_1 = INDEX_1 + NEWLINE
            + GROUP_NAME + NEWLINE
            + NEWLINE;
    public static final String SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_2 = INDEX_2 + NEWLINE
            + GROUP_NAME + NEWLINE
            + NEWLINE;
    public static final String SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_3 = INDEX_1 + NEWLINE
            + UNIONIZED_GROUP_NAME + NEWLINE
            + NEWLINE;
}
