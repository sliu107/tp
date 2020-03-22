package seedu.tp.ui;

import seedu.tp.exceptions.InvalidDateFormatException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupList;
import seedu.tp.parser.Parser;
import seedu.tp.studyplan.StudyPlanList;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.tp.utils.Constants.DETAIL_FIELD;
import static seedu.tp.utils.Constants.EMPTY_STRING;
import static seedu.tp.utils.Constants.LOG_FOLDER;
import static seedu.tp.utils.Constants.BULLET_POINT;

/**
 * Ui class.
 */
public class Ui {

    private static final String FILE_PATH = LOG_FOLDER + "ui.log";
    private static final Logger LOGGER = Logger.getLogger(Ui.class.getName());

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Set up the Ui logger. Call once at the start of the program.
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
     * Sends help message to user.
     */
    public void sendHelpMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Followings are the formats of commands used in the main menu:")
            .append(System.lineSeparator());
        stringBuilder.append("1. Add an event flashcard: event").append(System.lineSeparator());
        stringBuilder.append("2. Add a person flashcard: person").append(System.lineSeparator());
        stringBuilder.append("3. Add an other flashcard: other").append(System.lineSeparator());
        stringBuilder.append("4. List out all the flashcards: list").append(System.lineSeparator());
        stringBuilder.append("5. List the flashcards in time order: timeline").append(System.lineSeparator());
        stringBuilder.append("6. Set the priority of an existing flashcard: priority i/INDEX p/PRIORITY")
            .append(System.lineSeparator());
        stringBuilder.append("  (Note: There are 4 priority levels: LOW, MEDIUM, HIGH, DEFAULT)")
            .append(System.lineSeparator());
        stringBuilder.append("7. Set an existing flashcard as reviewed: reviewed i/INDEX")
            .append(System.lineSeparator());
        stringBuilder.append("8. Show the detailed information of an existing flashcard: show i/INDEX")
            .append(System.lineSeparator());
        stringBuilder.append("9. Delete a flashcard from the flashcard list: delete i/INDEX")
            .append(System.lineSeparator());
        stringBuilder.append("10. Set up a new flashcard group: group").append(System.lineSeparator());
        stringBuilder.append("11. Add a flashcard to an existing group: add").append(System.lineSeparator());
        stringBuilder.append("12. To exit the History Flashcard: bye").append(System.lineSeparator());
        stringBuilder.append("13. To get help message: help").append(System.lineSeparator());
        stringBuilder.append("Then please follow the instruction given by the program in each situation.")
            .append(System.lineSeparator());
        stringBuilder.append("(Note: Whenever requiring a date, you should pick one of the following format:")
            .append(System.lineSeparator());
        stringBuilder.append("       d M yyyy, M yyyy, yyyy, d/M/yyyy, M/yyyy, d-M-yyyy, M-yyyy)")
            .append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    /**
     * Prompts the user for a list of details for a flashcard.
     *
     * @return the list of details entered by user
     */
    public List<String> promptUserForDetails() {
        LOGGER.info("Prompting user for details...");
        List<String> details = new ArrayList<>();
        Optional<String> newDetailOptional = promptUserForOptionalField(DETAIL_FIELD);
        while (newDetailOptional.isPresent()) {
            details.add(newDetailOptional.get());
            newDetailOptional = promptUserForOptionalField(DETAIL_FIELD);
        }
        LOGGER.info("Returning details...");
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
        assert !fieldName.isEmpty() : "Invalid empty field name!";
        LOGGER.info("Prompting user for optional field " + fieldName + "...");

        System.out.println("Please enter " + fieldName + " (optional):");
        String input = getNextLine().trim();

        LOGGER.info("Returning optional field " + fieldName + "...");
        return input.equals(EMPTY_STRING) ? Optional.empty() : Optional.of(input);
    }

    /**
     * Prompts the user for a piece of required data used in the construction of a <code>Flashcard</code>.
     *
     * @param fieldName string representing the name of the data to prompt for
     * @return the user's input
     */
    public String promptUserForRequiredField(String fieldName) {
        assert !fieldName.isEmpty() : "Invalid empty field name!";
        LOGGER.info("Prompting user for required field " + fieldName + "...");

        System.out.println("Please enter " + fieldName + ":");
        String input = getNextLine().trim();
        while (input.equals(EMPTY_STRING)) {
            System.out.println("That is a required field! Please enter again.");
            input = getNextLine().trim();
        }

        LOGGER.info("Returning required field " + fieldName + "...");
        return input;
    }

    /**
     * Prompts the user for an optional date used in the construction of a <code>Flashcard</code>.
     *
     * @param fieldName string representing name of the date to prompt for
     * @return the parsed date
     */
    public Optional<LocalDate> promptUserForOptionalLocalDate(String fieldName) {
        assert !fieldName.isEmpty() : "Invalid empty field name!";
        LOGGER.info("Prompting user for optional local date field " + fieldName + "...");

        System.out.println("Please enter " + fieldName + " (optional):");
        String input;
        LocalDate localDate = null;

        do {
            input = getNextLine().trim();
            if (input.equals(EMPTY_STRING)) {
                return Optional.empty();
            }
            try {
                localDate = Parser.parseDate(input);
            } catch (InvalidDateFormatException e) {
                System.out.println("That date format couldn't be parsed! Please enter again.");
            }
        } while (localDate == null);

        LOGGER.info("Returning optional local date field " + fieldName + "...");
        return Optional.of(localDate);
    }

    /**
     * Prompts the user for a required date used in the construction of a <code>Flashcard</code>.
     *
     * @param fieldName string representing name of the date to prompt for
     * @return the parsed date
     */
    public LocalDate promptUserForRequiredLocalDate(String fieldName) {
        assert !fieldName.isEmpty() : "Invalid empty field name!";
        LOGGER.info("Prompting user for required local date field " + fieldName + "...");

        System.out.println("Please enter " + fieldName + ":");
        String input;
        LocalDate localDate = null;

        do {
            input = getNextLine().trim();
            try {
                localDate = Parser.parseDate(input);
            } catch (InvalidDateFormatException e) {
                System.out.println("That date format couldn't be parsed! Please enter again.");
            }
        } while (localDate == null);

        LOGGER.info("Returning required local date field " + fieldName + "...");
        return localDate;
    }

    /**
     * Gets the response from the user after the user reviewed a flashcard.
     *
     * @param flashcard the flashcard the user just reviewed
     * @return the response given by the user
     */
    public String promptUserResponseForReviewing(Flashcard flashcard) {
        System.out.println("Do you want to mark this flashcard as reviewed?");
        String input = getNextLine().trim().toLowerCase();
        System.out.println("");
        return input;
    }

    /**
     * Sends confirmation message for completion o random flashcard review.
     *
     * @param reviewedNumber        the number of flashcards reviewed during this self test
     * @param totalUnreviewedNumber the total number of unreviewed flashcards
     */
    public void confirmRandomFlashcardsReviewCompletion(int reviewedNumber, int totalUnreviewedNumber) {
        System.out.println("You have just gone through all the flashcard(s)");
        System.out.println("You have marked " + reviewedNumber + " flashcard(s) as reviewed this time.");
        System.out.println("You still have " + totalUnreviewedNumber + " flashcard(s) have not been reviewed so far.");
        System.out.println("");
    }

    /**
     * Sends flashcard creation confirmation to user.
     *
     * @param flashcard the flashcard created
     */
    public void confirmFlashcardCreation(Flashcard flashcard) {
        assert flashcard != null : "Invalid null flashcard!";

        System.out.println("You've successfully created the flashcard below:");
        System.out.println(flashcard);
    }

    /**
     * Prints confirmation that flashcard has been marked as reviewed.
     *
     * @param flashcard the flashcard that was reviewed
     */
    public void confirmFlashcardReview(Flashcard flashcard) {
        assert flashcard != null : "Invalid null flashcard!";

        System.out.println("You have marked the following flashcard as Reviewed:");
        System.out.println(flashcard.getName());
    }

    /**
     * Prints confirmation that flashcard priority level has been updated.
     *
     * @param flashcard the flashcard that had its priority updated
     */
    public void confirmFlashcardPriority(Flashcard flashcard) {
        assert flashcard != null : "Invalid null flashcard!";

        System.out.println("Priority has been updated:");
        System.out.println(flashcard.getName() + " | New priority: " + flashcard.getPriorityAsString());
    }

    /**
     * Displays flashcard details according to index specified.
     *
     * @param flashcard the flashcard to be displayed
     */
    public void showFlashcard(Flashcard flashcard) {
        assert flashcard != null : "Invalid null flashcard!";

        System.out.println("These are the flashcard details:");
        System.out.println(flashcard);
    }

    /**
     * Sends flashcard group creation confirmation to user.
     *
     * @param flashcardGroup the flashcard group created
     */
    public void confirmFlashcardGroupCreation(FlashcardGroup flashcardGroup) {
        assert flashcardGroup != null : "Invalid null flashcard group!";

        System.out.println("You've successfully created the group below:");
        System.out.println(flashcardGroup);
    }

    /**
     * Sends confirmation message that the flashcard is successfully added to a group.
     * *
     *
     * @param flashcardGroup the flashcard group the flashcard is added into.
     * @param flashcard      the flashcard just be added into the group
     */
    public void confirmFlashcardAdditionToGroup(FlashcardGroup flashcardGroup, Flashcard flashcard) {
        assert flashcardGroup != null : "Invalid null flashcard group!";
        assert flashcard != null : "Invalid null flashcard!";

        System.out.println("You've successfully added the flashcard below:");
        System.out.println(flashcard);
        System.out.println("To the group:");
        System.out.println(flashcardGroup);
    }

    /**
     * Lists all existing groups created by the user.
     *
     * @param groupList the list of all flashcard groups
     */
    public void listAllGroups(GroupList groupList) {
        assert groupList != null : "Invalid null GroupList!";

        if (groupList.getTotalGroupNum() == 0) {
            System.out.println("There are no existing groups. Use \"group\" to create a new group.");
            return;
        }
        List<FlashcardGroup> groups = groupList.getGroups();
        System.out.println("Here are all existing groups:");
        for (int i = 0; i < groups.size(); i++) {
            FlashcardGroup group = groups.get(i);
            String groupName = group.getName();
            System.out.println(i + 1 + ". " + groupName);
        }
    }

    /**
     * Prints out all flashcards in the list.
     *
     * @param flashcardList the list of flashcards to be printed out
     */
    public void listAllFlashcards(FlashcardList flashcardList) {
        assert flashcardList != null : "Invalid null flashcard list!";

        if (flashcardList.isEmpty()) {
            System.out.println("You have no flashcard at this moment!");
            return;
        }

        System.out.println("Here's the list of flashcards you have:");
        for (int i = 0; i < flashcardList.getTotalFlashcardNum(); i++) {
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(i);
            System.out.println((i + 1) + ": " + flashcard.getName()
                + " | Reviewed: " + flashcard.getReviewIcon()
                + " | " + flashcard.getPriorityAsString());
        }
    }

    /**
     * Lists all flashcards in a specified group.
     *
     * @param flashcardList       list of all flashcards in the group
     * @param groupIdentifier     name or index of the group
     */
    public void listFlashcardsInGroup(FlashcardList flashcardList, String groupIdentifier) {
        assert flashcardList != null : "Invalid null flashcard list!";

        if (flashcardList.isEmpty()) {
            System.out.println("There are no flashcards in the group!");
            return;
        }

        System.out.println(groupIdentifier + " contains the following flashcards:");
        for (Flashcard flashcard : flashcardList.getFlashcards()) {
            System.out.println(BULLET_POINT + flashcard.getName()
                + " | Reviewed: " + flashcard.getReviewIcon()
                + " | " + flashcard.getPriorityAsString());
        }
    }

    /**
     * Lists all flashcards along with their IDs.
     *
     * @param flashcardListWithId the list of flashcards with IDs.
     */
    public void listAllFlashcardsWithId(List<Map.Entry<Integer, Flashcard>> flashcardListWithId) {
        assert flashcardListWithId != null : "Invalid null flashcard list!";

        LOGGER.info("Listing flashcards with ID...");
        if (flashcardListWithId.isEmpty()) {
            System.out.println("You have no flashcard matching your query!");
            return;
        }

        System.out.println("Here's the list of flashcards you are looking for:");
        for (int i = 0; i < flashcardListWithId.size(); i++) {
            Map.Entry<Integer, Flashcard> flashcardEntry = flashcardListWithId.get(i);
            System.out.println((i + 1) + ": " + flashcardEntry.getValue().getName()
                + " | Reviewed: " + flashcardEntry.getValue().getReviewIcon()
                + " | " + flashcardEntry.getValue().getPriorityAsString()
                + " | ID: " + (flashcardEntry.getKey() + 1));
        }
        LOGGER.info("Listed flashcards with ID!");
    }

    /**
     * Prints out all flashcards in the list ordered by start/birth date. Other cards come last
     *
     * @param flashcardList the list of flashcards to be printed out
     */
    public void listAllFlashcardsOrdered(FlashcardList flashcardList) {
        assert flashcardList != null : "Invalid null flashcard list!";

        if (flashcardList.isEmpty()) {
            System.out.println("You have no flashcards at this moment!");
            return;
        }

        List<Flashcard> flashcards = new ArrayList<>(flashcardList.getFlashcards());
        Collections.sort(flashcards);
        System.out.println("Here's a sorted list of the flashcards you have:");
        for (Flashcard f : flashcards) {
            System.out.println(f);
        }
    }

    /**
     * Displays a list of all the user's study plan(s) sorted by date.
     *
     * @param studyPlanList the study plan to be displayed
     * @param flashcardList the flashcard list
     */
    public void displayStudyPlan(StudyPlanList studyPlanList, FlashcardList flashcardList) {
        assert studyPlanList != null : "Invalid null StudyPlan!";
        assert flashcardList != null : "Invalid null FlashcardList!";

        LOGGER.info("Displaying study plan...");
        List<Map.Entry<LocalDate, List<Integer>>> studyPlans = studyPlanList.getStudyPlanList();
        for (Map.Entry<LocalDate, List<Integer>> studyPlanForDay : studyPlans) {
            System.out.println("Date: " + studyPlanForDay.getKey());
            for (int index : studyPlanForDay.getValue()) {
                Flashcard flashcard = flashcardList.getFlashcardAtIdx(index);
                System.out.println((index + 1) + ": " + flashcard.getName()
                    + " | Reviewed: " + flashcard.getReviewIcon()
                    + " | " + flashcard.getPriorityAsString());
            }
        }
        LOGGER.info("study plan displayed!");
    }

    /**
     * Prints out exception to UI.
     *
     * @param exception the exception to be printed out
     */
    public void printException(Exception exception) {
        LOGGER.warning("Sending exception to user...");
        LOGGER.warning(exception.toString());
        System.out.println("An exception has occurred!");
        System.out.println(exception.getMessage());
    }

    /**
     * Sends response to unknown command entered by user.
     */
    public void sendUnknownCommandResponse() {
        LOGGER.info("Sending unknown command response to user...");
        System.out.println("Sorry, I don't know how to help with that yet.");
    }

    /**
     * Sends response to invalid flashcard index entered by user.
     */
    public void sendInvalidFlashcardIndexResponse() {
        LOGGER.info("Sending invalid flashcard index response to user...");
        System.out.println("The flashcard index you entered is invalid");
    }

    public void sendLoggingSetupFailedMessage() {
        LOGGER.info("Sending logging set up failed response to user...");
        System.out.println("Logging setup failed! Logs will be printed to console instead of saved to file.");
    }

    public void sendInvalidInputFormatResponse() {
        LOGGER.info("Sending invalid input format response to user...");
        System.out.println("Please use the correct input format. Use \"help\" to view all commands.");
    }

    public void sendDuplicateFlashcardResponse() {
        LOGGER.info("Send duplicate flashcard response to user...");
        System.out.println("Duplicate flashcard detected. The flashcard has not been added.");
    }

    /**
     * Sends response to invalid flashcard group name/index entered by user.
     */
    public void sendInvalidFlashcardGroupResponse() {
        LOGGER.info("Send invalid flashcard group response to user...");
        System.out.println("Please enter a valid flashcard group name or index."
                + " Use \"showgroups\" to view all groups.");
    }

    /**
     * Gets the next user input line.
     *
     * @return next line
     */
    public String getNextLine() {
        return scanner.nextLine();
    }
}
