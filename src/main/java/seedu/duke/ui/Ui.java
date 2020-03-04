package seedu.duke.ui;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

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


    public String getNextLine() {
        return scanner.nextLine();
    }
}
