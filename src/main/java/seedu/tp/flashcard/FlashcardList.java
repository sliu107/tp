package seedu.tp.flashcard;

import seedu.tp.commands.ReviewedCommand;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.ui.Ui;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.tp.utils.Constants.LOG_FOLDER;
import static seedu.tp.utils.Constants.REGEX_MATCH_ALL_CHARACTER;

/**
 * List of flashcards.
 */
public class FlashcardList {

    private static final String FILE_PATH = LOG_FOLDER + "flashcard_list.log";
    private static final Logger LOGGER = Logger.getLogger(FlashcardList.class.getName());

    private List<Flashcard> flashcards;
    private int totalReviewedNumber;

    /**
     * Constructor for FlashcardList.
     */
    public FlashcardList() {
        this.flashcards = new ArrayList<>();
        this.totalReviewedNumber = 0;
    }

    /**
     * Constructor for FlashcardList.
     *
     * @param flashcardList the list of flashcards to be added
     */
    public FlashcardList(List<Flashcard> flashcardList) {
        this();

        assert flashcardList != null : "Invalid null flashcard list!";

        this.flashcards.addAll(flashcardList);
    }

    /**
     * Copy constructor for FlashcardList.
     * Note that this is a shallow copy.
     *
     * @param flashcardList the flashcard list to be copied from
     */
    public FlashcardList(FlashcardList flashcardList) {
        this();

        assert flashcardList != null : "Invalid null FlashcardList!";

        for (int i = 0; i < flashcardList.getTotalFlashcardNum(); i++) {
            this.flashcards.add(flashcardList.getFlashcardAtIdx(i));
        }
    }

    /**
     * Set up the FlashcardList logger. Call once at the start of the program.
     *
     * @throws IOException when logger set up failed
     */
    public static void setupLogger() throws IOException {
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);
        FileHandler fileHandler = new FileHandler(FILE_PATH, true);
        fileHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileHandler);
    }

    /**
     * Adds a flashcard to the list.
     *
     * @param flashcard the task to be added to the list
     * @return the updated flashcardList with new flashcard just be added in
     */
    public FlashcardList addFlashcard(Flashcard flashcard) {
        assert flashcard != null : "Invalid null flashcard!";

        flashcards.add(flashcard);
        LOGGER.info("Added flashcard " + flashcard.getName() + " to list.");
        return this;
    }

    /**
     * Deletes a flashcard from the list.
     *
     * @param index the index of the flashcard to be deleted
     * @return the deleted flashcard
     */
    public Flashcard deleteFlashcard(int index) throws InvalidFlashcardIndexException {
        try {
            Flashcard flashcard = flashcards.remove(index);
            LOGGER.info("Deleted flashcard " + flashcard.getName() + " from list.");
            return flashcard;
        } catch (IndexOutOfBoundsException e) {
            LOGGER.warning("IndexOutOfBoundsException occurred when deleting flashcard at index " + index);
            LOGGER.warning("Throwing InvalidFlashcardIndexException...");
            throw new InvalidFlashcardIndexException();
        }
    }

    /**
     * Resets all the flashcards as unreviewed.
     *
     * @param ui the ui used to communicate with the user
     */
    public void resetAsUnreviewed(Ui ui) {
        assert flashcards != null : "Invalid flashcardList";
        assert ui != null : "Invalid ui";

        for (Flashcard flashcard : flashcards) {
            flashcard.setReviewStatus(false);
        }
        ui.confirmResetCompletion();
    }

     /**
     * Randomize the flashcard list to help user for reviewing.
     *
     * @return the random flashcard list
     */
    public FlashcardList reviewRandomFlashcards(Ui ui) throws InvalidFlashcardIndexException {
        assert flashcards != null : "Invalid null flashcard!";

        FlashcardList randomFlashcards = new FlashcardList(flashcards);
        Collections.shuffle(randomFlashcards.getFlashcards(), new Random(System.currentTimeMillis()));
        LOGGER.info("The flashcards have been randomized.");

        int reviewedNumber = 0;
        for (Flashcard flashcard : randomFlashcards.getFlashcards()) {
            System.out.println(flashcard);
            if (flashcard.isReviewed) {
                System.out.println("You have already reviewed this flashcard.");
                System.out.println("");
            } else if (ui.promptUserResponseForReviewing(flashcard).equals("yes")) {
                ReviewedCommand reviewedCommand = new ReviewedCommand(this,
                        flashcards.indexOf(flashcard), ui);
                reviewedCommand.execute();
                reviewedNumber++;
            } else {
                continue;
            }
        }
        int totalUnreviewedNumber = flashcards.size() - totalReviewedNumber;
        ui.confirmRandomFlashcardsReviewCompletion(reviewedNumber, totalUnreviewedNumber);
        return randomFlashcards;
    }

    /**
     * Return whether or not this FlashcardList contains specified flashcard.
     *
     * @param flashcard the flashcard to check
     * @return whether or not this FlashcardList contains specified flashcard
     */
    public boolean contains(Flashcard flashcard) {
        assert flashcard != null : "Invalid null flashcard!";
        return flashcards.contains(flashcard);
    }

    /**
     * Gets the flashcard at a specific index.
     *
     * @param idx the index.
     * @return the flashcard at the specified index
     */
    public Flashcard getFlashcardAtIdx(int idx) {
        return flashcards.get(idx);
    }

    /**
     * Checks if the flashcard list is empty.
     *
     * @return boolean value indicating whether or not the flashcard list is empty
     */
    public boolean isEmpty() {
        return flashcards.isEmpty();
    }

    /**
     * Gets the total number of flashcards in the list.
     *
     * @return total number of flashcards in the list
     */
    public int getTotalFlashcardNum() {
        return flashcards.size();
    }

    /**
     * Updates the number of reviewed flashcards.
     *
     * @param totalReviewedNumber the updated number of reviewed flashcards
     */
    public void setTotalReviewedNumber(int totalReviewedNumber) {
        this.totalReviewedNumber = totalReviewedNumber;
    }

    /**
     * Gets the number of reviewed flashcards.
     *
     * @return the total number of reviewed flashcards at this moment
     */
    public int getTotalReviewedNumber() {
        return totalReviewedNumber;
    }

    /**
     * Gets the list of flashcards.
     *
     * @return the list of flashcards
     */
    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    /**
     * Gets all reviewed flashcards with IDs.
     *
     * @return the list of reviewed flashcards with IDs
     */
    public List<Map.Entry<Integer, Flashcard>> getAllReviewedFlashcards() {
        LOGGER.info("Getting all reviewed flashcards...");
        List<Map.Entry<Integer, Flashcard>> reviewedFlashcards = new ArrayList<>();
        for (int i = 0; i < flashcards.size(); i++) {
            Flashcard flashcard = flashcards.get(i);
            if (flashcard.isReviewed()) {
                reviewedFlashcards.add(new AbstractMap.SimpleEntry<>(i, flashcard));
            }
        }
        LOGGER.info("Got all reviewed flashcards!");
        return reviewedFlashcards;
    }

    /**
     * Gets all flashcards which contain a certain keyword with IDs.
     *
     * @param keyword the specified keyword
     * @return the list of flashcards containing the specified keyword with IDs
     */
    public List<Map.Entry<Integer, Flashcard>> getAllFlashcardsWithKeyword(String keyword) {
        LOGGER.info("Getting all flashcards with keyword " + keyword + "...");
        List<Map.Entry<Integer, Flashcard>> flashcardsWithKeyword = new ArrayList<>();
        for (int i = 0; i < flashcards.size(); i++) {
            Flashcard flashcard = flashcards.get(i);
            if (flashcard.getName().matches(REGEX_MATCH_ALL_CHARACTER + keyword + REGEX_MATCH_ALL_CHARACTER)) {
                flashcardsWithKeyword.add(new AbstractMap.SimpleEntry<>(i, flashcard));
            }
        }
        LOGGER.info("Got all flashcards with keyword " + keyword + "!");
        return flashcardsWithKeyword;
    }

    /**
     * Check if the current instance is equal to the object passed in.
     *
     * @param obj The object to be compared against the current instance
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FlashcardList)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        FlashcardList otherFlashcards = (FlashcardList) obj;
        if (this.getTotalFlashcardNum() != otherFlashcards.getTotalFlashcardNum()) {
            return false;
        }

        List<Flashcard> flashcardList = new ArrayList<Flashcard>(this.getFlashcards());
        Collections.sort(flashcardList);
        List<Flashcard> otherFlashcardList = new ArrayList<Flashcard>(otherFlashcards.getFlashcards());
        Collections.sort(otherFlashcardList);
        for (int idx = 0; idx < this.getTotalFlashcardNum(); idx++) {
            if (!flashcardList.get(idx).equals(otherFlashcardList.get(idx))) {
                return false;
            }
        }
        return true;
    }
}
