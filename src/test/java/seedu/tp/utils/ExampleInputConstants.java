package seedu.tp.utils;

import seedu.tp.flashcard.EventFlashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.flashcard.OtherFlashcard;
import seedu.tp.flashcard.PersonFlashcard;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ExampleInputConstants {
    public static final String NEWLINE = System.lineSeparator();

    public static final String NAME = "Example name";
    public static final String START_DATE = "31 07 1843";
    public static final String END_DATE = "25 12 1892";
    public static final LocalDate START_LOCAL_DATE = LocalDate.of(1843, 7, 31);
    public static final LocalDate END_LOCAL_DATE = LocalDate.of(1892, 12, 25);
    public static final String SUMMARY = "Example summary";
    public static final String DETAIL_1 = "Detail 1";
    public static final String DETAIL_2 = "Detail 2";
    public static final List<String> DETAILS = Arrays.asList(DETAIL_1, DETAIL_2);

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

    public static final EventFlashcard EVENT_FLASHCARD = new EventFlashcard(
        "Event 1",
        START_LOCAL_DATE,
        END_LOCAL_DATE,
        "This is an event summary",
        DETAILS
    );
    public static final PersonFlashcard PERSON_FLASHCARD = new PersonFlashcard(
        "Person 1",
        START_LOCAL_DATE,
        END_LOCAL_DATE,
        "This is a person's summmary",
        DETAILS
    );
    public static final OtherFlashcard OTHER_FLASHCARD = new OtherFlashcard(
        "Title 1",
        "This is a summary",
        DETAILS
    );

    public static final FlashcardList EMPTY_FLASHCARD_LIST = new FlashcardList();
    public static final FlashcardList FULL_FLASHCARD_LIST =
        new FlashcardList(Arrays.asList(EVENT_FLASHCARD, PERSON_FLASHCARD, OTHER_FLASHCARD));
}
