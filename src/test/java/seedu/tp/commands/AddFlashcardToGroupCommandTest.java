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
import static seedu.tp.utils.ExampleInputConstants.FULL_FLASHCARD_LIST;
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
        FlashcardGroup expectedGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FULL_FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_3));
        GroupList expectedGroupList = new GroupList();
        expectedGroupList.addFlashcardGroup(expectedGroup);

        //Test case1: Adding flashcards in the order as expected
        FlashcardGroup actualGroup1 = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FULL_FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_1));
        GroupList actualGroupList1 = new GroupList();
        actualGroupList1.addFlashcardGroup(actualGroup1);

        AddFlashcardToGroupCommand addFlashcardToGroupCommand1 = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_3, FULL_FLASHCARD_LIST,actualGroupList1);
        addFlashcardToGroupCommand1.execute();

        assertEquals(expectedGroupList, actualGroupList1);

        //Test case2: Adding flashcards in an different order
        FlashcardGroup actualGroup2 = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FULL_FLASHCARD_LIST,
                convertStringIndexesToIntArray(INDEXES_2));
        GroupList actualGroupList2 = new GroupList();
        actualGroupList2.addFlashcardGroup(actualGroup2);

        AddFlashcardToGroupCommand addFlashcardToGroupCommand2 = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_1, FULL_FLASHCARD_LIST, actualGroupList2);
        addFlashcardToGroupCommand2.execute();

        assertEquals(expectedGroupList, actualGroupList2);
    }

    @Test
    public void addFlashcardToGroupCommand_invalidFlashcardIndex_throwsException()
            throws InvalidFlashcardIndexException {
        GroupList originalGroupList = new GroupList();
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT_1, FULL_FLASHCARD_LIST);
        GroupCommand groupCommand = new GroupCommand(groupFactory, originalGroupList);
        groupCommand.execute();

        AddFlashcardToGroupCommand addFlashcardToGroupCommand = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_2, FULL_FLASHCARD_LIST,originalGroupList);
        assertThrows(
                InvalidFlashcardIndexException.class, addFlashcardToGroupCommand::execute
        );
    }

    @Test
    public void addFlashcardToGroupCommand_unrecognizedFlashcardGroupType_throwsException()
            throws InvalidFlashcardIndexException {
        GroupList originalGroupList = new GroupList();
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT_1, FULL_FLASHCARD_LIST);
        GroupCommand groupCommand = new GroupCommand(groupFactory, originalGroupList);
        groupCommand.execute();

        AddFlashcardToGroupCommand addFlashcardToGroupCommand = getAddFlashcardToGroupCommandWithInput(
                SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT_4, FULL_FLASHCARD_LIST,originalGroupList);
        assertThrows(
                UnrecognizedFlashcardGroupException.class, addFlashcardToGroupCommand::execute
        );
    }
}
