package seedu.tp.utils;

import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.ui.Ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTestUtil {
    private static final InputStream SYS_IN_BACKUP = System.in;

    /**
     * Used to simulate user creation of a flashcard in JUnit testing environment.
     * 
     * @param simulatedInput The desired input of the user
     * @return a <code>FlashcardFactory</code> object that can be used to create Flashcards based on simualtedInput
     */
    public static FlashcardFactory getFlashcardFactoryWithInput(String simulatedInput) {
        ByteArrayInputStream simulatedSystemIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(simulatedSystemIn);
        FlashcardFactory flashcardFactory = new FlashcardFactory(new Ui());
        System.setIn(SYS_IN_BACKUP);
        return flashcardFactory;
    }
}
