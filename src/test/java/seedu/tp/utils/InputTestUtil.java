package seedu.tp.utils;

import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.ui.Ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTestUtil {
    private static final InputStream SYS_IN_BACKUP = System.in;

    public static FlashcardFactory getFlashcardFactoryWithInput(String simulatedInput) {
        ByteArrayInputStream simulatedSystemIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(simulatedSystemIn);
        FlashcardFactory flashcardFactory = new FlashcardFactory(new Ui());
        System.setIn(SYS_IN_BACKUP);
        return flashcardFactory;
    }
}
