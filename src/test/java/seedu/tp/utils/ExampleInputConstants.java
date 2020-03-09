package seedu.tp.utils;

import java.util.Arrays;
import java.util.List;

import seedu.tp.flashcard.EventFlashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.flashcard.OtherFlashcard;
import seedu.tp.flashcard.PersonFlashcard;

public class ExampleInputConstants {
    public static final String NAME = "Example name";
    public static final String DESCRIPTION = "Example description";
    public static final String START_DATE = "10/5/1784";
    public static final String END_DATE = "17/4/1892";
    public static final String SUMMARY = "Example summary";
    public static final String DETAIL_1 = "Detail 1";
    public static final String DETAIL_2 = "Detail 2";
    public static final List<String> DETAILS = Arrays.asList(DETAIL_1, DETAIL_2);
    public static final String INDEXES = "1 3";
    public static final FlashcardList FLASHCARD_LIST = new FlashcardList()
            .addFlashcard(new EventFlashcard(NAME, START_DATE, END_DATE, SUMMARY, DETAILS))
            .addFlashcard(new PersonFlashcard(NAME, START_DATE, END_DATE, SUMMARY, DETAILS))
            .addFlashcard(new OtherFlashcard(NAME, SUMMARY, DETAILS));
    public static final String NEWLINE = System.lineSeparator();
    public static final String FULL_SIMULATED_INPUT = NAME + NEWLINE
            + START_DATE + NEWLINE
            + END_DATE + NEWLINE
            + SUMMARY + NEWLINE
            + DETAIL_1 + NEWLINE
            + DETAIL_2 + NEWLINE
            + NEWLINE;
    public static final String PARTIAL_SIMULATED_INPUT = NAME + NEWLINE
            + SUMMARY + NEWLINE
            + DETAIL_1 + NEWLINE
            + DETAIL_2 + NEWLINE
            + NEWLINE;
    public static final String SIMULATED_GROUP_COMMAND_INPUT1 = NAME + NEWLINE
            + DESCRIPTION + NEWLINE
            + INDEXES + NEWLINE
            + NEWLINE;

}
