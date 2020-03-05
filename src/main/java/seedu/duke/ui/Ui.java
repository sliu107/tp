package seedu.duke.ui;

import java.util.Scanner;

/**
 * Ui class.
 */
public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompt the user for a piece of data used in the construction of a <code>Flashcard</code>.
     * The user can leave the line empty if the data is optional.
     * @param desiredData string representing the name of the data to prompt for
     * @param isOptional whether or not this piece of data is optional.
     * @return the user's input
     */
    public String promptUser(String desiredData, boolean isOptional) {
        System.out.print(desiredData + (isOptional ? "(Optional): " : ": "));
        String input = getNextLine();
        if (!isOptional) {
            while (input.equals("")) {
                System.out.println("That is a required field! Please enter again.");
                System.out.print(desiredData + ": ");
                input = getNextLine();
            }
        }

        if (input.equals("")) {
            return null;
        } else {
            return input;
        }
    }


    /**
     * Get the next user input line.
     * @return next line
     */
    public String getNextLine() {
        return scanner.nextLine();
    }
}
