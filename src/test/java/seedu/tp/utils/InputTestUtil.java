package seedu.tp.utils;

import seedu.tp.commands.AddFlashcardToGroupCommand;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;
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

    public static GroupFactory getGroupFactoryWithInput(String simulatedInput, FlashcardList flashcardList) {
        ByteArrayInputStream simulatedSystemIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(simulatedSystemIn);
        GroupFactory groupFactory = new GroupFactory(new Ui(),flashcardList);
        System.setIn(SYS_IN_BACKUP);
        return groupFactory;
    }

    public static AddFlashcardToGroupCommand getAddFlashcardToGroupCommandWithInput
            (String simulatedInput, FlashcardList flashcardList, GroupList originalGroupList) {
        ByteArrayInputStream simulatedSystemIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(simulatedSystemIn);
        return new AddFlashcardToGroupCommand(new Ui(), originalGroupList, flashcardList);
    }

    public static int[] convertStringIndexesToIntArray(String givenIndexes) {
        String[] idxs = givenIndexes.split(" ");
        int[] indexes = new int[idxs.length];
        for (int i = 0; i<indexes.length; i++){
            indexes[i] = Integer.parseInt(idxs[i]) - 1;
        }
        return indexes;
    }
}
