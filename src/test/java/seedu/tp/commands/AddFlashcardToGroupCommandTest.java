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
import static seedu.tp.utils.ExampleInputConstants.INDEXES_3;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_1;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_2;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_3;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_4;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_GROUP_COMMAND_INPUT_1;
import static seedu.tp.utils.InputTestUtil.getGroupFactoryWithInput;
import static seedu.tp.utils.InputTestUtil.convertStringIndexesToIntArray;
import static seedu.tp.utils.InputTestUtil.getAddFlashcardToGroupCommandWithInput;

public class AddFlashcardToGroupCommandTest {
    @Test
    public void addFlashcardToGroupCommand_execute_Successfully() throws HistoryFlashcardException {
        FlashcardGroup expectedGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_3));
        GroupList expectedGroupList = new GroupList();
        expectedGroupList.addFlashcardGroup(expectedGroup);

        //Test case1: Adding flashcards in the order as expected
        FlashcardGroup actualGroup_1 = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_1));
        GroupList actualGroupList_1 = new GroupList();
        actualGroupList_1.addFlashcardGroup(actualGroup_1);

        AddFlashcardToGroupCommand addFlashcardToGroupCommand_1 = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_3, FLASHCARD_LIST,actualGroupList_1);
        addFlashcardToGroupCommand_1.execute();

        assertEquals(expectedGroupList, actualGroupList_1);

        //Test case2: Adding flashcards in an different order
        FlashcardGroup actualGroup_2 = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_2));
        GroupList actualGroupList_2 = new GroupList();
        actualGroupList_2.addFlashcardGroup(actualGroup_2);

        AddFlashcardToGroupCommand addFlashcardToGroupCommand_2 = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_1, FLASHCARD_LIST, actualGroupList_2);
        addFlashcardToGroupCommand_2.execute();

        assertEquals(expectedGroupList, actualGroupList_2);
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
                InvalidFlashcardIndexException.class, addFlashcardToGroupCommand::execute
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
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_4, FLASHCARD_LIST,originalGroupList);
        assertThrows(
                UnrecognizedFlashcardGroupException.class, addFlashcardToGroupCommand::execute
        );
    }
}
