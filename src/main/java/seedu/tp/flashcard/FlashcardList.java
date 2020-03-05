package seedu.tp.flashcard;

import seedu.tp.exceptions.InvalidFlashcardIndexException;

import java.util.ArrayList;

/**
 * List of flashcards.
 */
public class FlashcardList {
    private ArrayList<Flashcard> flashcards;

    /**
     * Constructor for FlashcardList.
     */
    public FlashcardList() {
        this.flashcards = new ArrayList<>();
    }

    /**
     * Adds a flashcard to the list.
     *
     * @param flashcard the task to be added to the list
     */
    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    /**
     * Deletes a flashcard from the list.
     *
     * @param index the index of the flashcard to be deleted
     * @return the deleted flashcard
     */
    public Flashcard deleteFlashcard(int index) throws InvalidFlashcardIndexException {
        try {
            return flashcards.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
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
}
