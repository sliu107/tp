package seedu.tp.commands;

import org.junit.jupiter.api.Test;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.UnrecognizedFlashcardGroupException;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.tp.utils.ExampleInputConstants.DESCRIPTION;
import static seedu.tp.utils.ExampleInputConstants.FLASHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.GROUP_NAME;
import static seedu.tp.utils.ExampleInputConstants.INDEXES_1;
import static seedu.tp.utils.ExampleInputConstants.INDEXES_2;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_1;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_2;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_3;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_GROUP_COMMAND_INPUT_1;
import static seedu.tp.utils.InputTestUtil.getGroupFactoryWithInput;
import static seedu.tp.utils.InputTestUtil.convertStringIndexesToIntArray;
import static seedu.tp.utils.InputTestUtil.getAddFlashcardToGroupCommandWithInput;

public class AddFlashcardToGroupCommandTest {
    @Test
    public void addFlashcardToGroupCommand_execute_Successfully() throws HistoryFlashcardException {
        FlashcardGroup expectedGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_2));
        GroupList expectedGroupList = new GroupList();
        expectedGroupList.addFlashcardGroup(expectedGroup);

        FlashcardGroup actualGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_1));
        GroupList actualGroupList = new GroupList();
        actualGroupList.addFlashcardGroup(actualGroup);

        AddFlashcardToGroupCommand addFlashcardToGroupCommand = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_1, FLASHCARD_LIST, actualGroupList);
        addFlashcardToGroupCommand.execute();

        assertEquals(expectedGroupList, actualGroupList);
    }

    @Test
    public void addFlashcardToGroupCommand_invalidFlashcardIndex_throwsException()
            throws InvalidFlashcardIndexException {
        GroupList originalGroupList = new GroupList();
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT_1, FLASHCARD_LIST);
        GroupCommand groupCommand = new GroupCommand(groupFactory, originalGroupList);
        groupCommand.execute();

        AddFlashcardToGroupCommand addFlashcardToGroupCommand = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_2, FLASHCARD_LIST,originalGroupList);
        assertThrows(
                InvalidFlashcardIndexException.class, () -> addFlashcardToGroupCommand.execute()
        );
    }

    @Test
    public void addFlashcardToGroupCommand_unrecognizedFlashcardGroupType_throwsException()
            throws InvalidFlashcardIndexException {
        GroupList originalGroupList = new GroupList();
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT_1, FLASHCARD_LIST);
        GroupCommand groupCommand = new GroupCommand(groupFactory, originalGroupList);
        groupCommand.execute();

        AddFlashcardToGroupCommand addFlashcardToGroupCommand = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_3, FLASHCARD_LIST,originalGroupList);
        assertThrows(
                UnrecognizedFlashcardGroupException.class, () -> addFlashcardToGroupCommand.execute()
        );
    }
}
