package seedu.tp.flashcard;

import seedu.tp.exceptions.InvalidFlashcardIndexException;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Gets the list of flashcards.
     * 
     * @return the list of flashcards
     */
    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    /**
     * Check if the current instance is equal to the object passed in.
     *
     * @param obj The object to be compared against the current instance
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        FlashcardList otherFlashcardList = (FlashcardList) obj;
        if (this.getTotalFlashcardNum() != otherFlashcardList.getTotalFlashcardNum()) {
            return false;
        }

        for (int idx = 0; idx < this.getTotalFlashcardNum(); idx++) {
            if (!this.getFlashcardAtIdx(idx).equals(otherFlashcardList.getFlashcardAtIdx(idx))) {
                return false;
            }
        }
        return true;
    }
}
