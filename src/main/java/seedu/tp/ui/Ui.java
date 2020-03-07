package seedu.tp.ui;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static seedu.tp.utils.Constants.DETAIL_FIELD;
import static seedu.tp.utils.Constants.EMPTY_STRING;

/**
 * Ui class.
 */
public class Ui {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Sends welcome message to user.
     */
    public void sendWelcomeMessage() {
        System.out.println("Welcome to History Flashcard App!");
    }

    /**
     * Sends bye message to user.
     */
    public void sendByeMessage() {
        System.out.println("Thanks for using History Flashcard!");
    }

    /**
     * Prompts the user for a list of details for a flashcard.
     *
     * @return the list of details entered by user
     */
    public List<String> promptUserForDetails() {
        List<String> details = new ArrayList<>();
        Optional<String> newDetailOptional = promptUserForOptionalField(DETAIL_FIELD);
        while (newDetailOptional.isPresent()) {
            details.add(newDetailOptional.get());
            newDetailOptional = promptUserForOptionalField(DETAIL_FIELD);
        }
        return details;
    }

    /**
     * Prompts the user for a piece of optional data used in the construction of a <code>Flashcard</code>.
     * The user can leave the line empty.
     *
     * @param fieldName string representing the name of the data to prompt for
     * @return the user's input
     */
    public Optional<String> promptUserForOptionalField(String fieldName) {
        System.out.println("Please enter " + fieldName + " (optional):");
        String input = getNextLine().trim();
        return input.equals(EMPTY_STRING) ? Optional.empty() : Optional.of(input);
    }

    /**
     * Prompts the user for a piece of required data used in the construction of a <code>Flashcard</code>.
     *
     * @param fieldName string representing the name of the data to prompt for
     * @return the user's input
     */
    public String promptUserForRequiredField(String fieldName) {
        System.out.println("Please enter " + fieldName + ":");
        String input = getNextLine().trim();
        while (input.equals(EMPTY_STRING)) {
            System.out.println("That is a required field! Please enter again.");
            input = getNextLine().trim();
        }
        return input;
    }

    /**
     * Sends flashcard creation confirmation to user.
     *
     * @param flashcard the flashcard created
     */
    public void confirmFlashcardCreation(Flashcard flashcard) {
        System.out.println("You've successfully created the flashcard below:");
        System.out.println(flashcard);
    }

    /**
     * Prints confirmation that flashcard has been marked as reviewed.
     *
     * @param flashcard the flashcard that was reviewed
     */
    public void confirmFlashcardReview (Flashcard flashcard) {
        System.out.println("You have marked the following flashcard as Reviewed: ");
        System.out.println(flashcard.getName());
    }

    /**
     * Prints confirmation that flashcard priority level has been updated.
     *
     * @param flashcard the flashcard that had its priority updated
     */
    public void confirmFlashcardPriority (Flashcard flashcard) {
        System.out.println("Priority has been updated: ");
        System.out.println(flashcard.getName() + " | New priority: " + flashcard.getPriority());
    }

    /**
     * Displays flashcard details according to index specified.
     *
     * @param flashcardList the list containing the flashcard
     * @param index the position of the flashcard in the flashcardList
     */
    public void showFlashcard(FlashcardList flashcardList, int index) throws InvalidFlashcardIndexException {
        System.out.println("Showing flashcard no. " + index + ":");
        try {
            System.out.println(flashcardList.getFlashcardAtIdx(index - 1));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }

    /**
     * Prints out all flashcards in the list.
     *
     * @param flashcardList the list of flashcards to be printed out
     */
    public void listAllFlashcards(FlashcardList flashcardList) {
        if (flashcardList.isEmpty()) {
            System.out.println("You have no flashcard at this moment!");
            return;
        }

        System.out.println("Here's the list of flashcards you have:");
        for (int i = 0; i < flashcardList.getTotalFlashcardNum(); i++) {
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(i);
            System.out.println((i + 1) + ": " + flashcard.getName() + " | Reviewed: " + flashcard.getReviewIcon()
                                + " | " + flashcard.getPriority());
        }
    }

    /**
     * Prints out exception to UI.
     *
     * @param exception the exception to be printed out
     */
    public void printException(Exception exception) {
        System.out.println("An exception has occurred!");
        System.out.println(exception.getMessage());
    }

    /**
     * Sends response to unknown command entered by user.
     */
    public void sendUnknownCommandResponse() {
        System.out.println("Sorry, I don't know how to help with that yet.");
    }

    /**
     * Sends response to invalid flashcard index entered by user.
     */
    public void sendInvalidFlashcardIndexResponse() {
        System.out.println("The flashcard index you entered is invalid");
    }

    /**
     * Gets the next user input line.
     *
     * @return next line
     */
    public String getNextLine() {
        return SCANNER.nextLine();
    }
}
