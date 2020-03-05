package seedu.duke;

import seedu.duke.exceptions.UnrecognizedFlashcardTypeException;
import seedu.duke.flashcard.Flashcard;
import seedu.duke.flashcard.FlashcardFactory;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

/**
 * Main class.
 */
public class Main {
    Ui ui;
    FlashcardFactory flashcardFactory;
    ArrayList<Flashcard> flashcards;

    /**
     * Program entry point.
     * @param args CLI args (unused)
     */
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        setup();
        runLoop();
    }

    private void setup() {
        this.ui = new Ui();
        this.flashcardFactory = new FlashcardFactory(this.ui);
        this.flashcards = new ArrayList<>();
    }

    private void runLoop() {
        String userInput;
        while (true) {
            //type Person, Event, Other to create new card
            userInput = ui.getNextLine();
            try {
                Flashcard newFlashcard = flashcardFactory.create(userInput);
                flashcards.add(newFlashcard);
            } catch (UnrecognizedFlashcardTypeException e) {
                System.out.println(e.getMessage());
            }

            // list all your flashcards after you add one. This is just for testing purposes.
            for (Flashcard f : flashcards) {
                System.out.println(System.lineSeparator() + f.toString() + System.lineSeparator());
            }
        }
    }
}
