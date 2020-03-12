package seedu.tp.commands;

import org.junit.jupiter.api.Test;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.tp.utils.ExampleInputConstants.DESCRIPTION;
import static seedu.tp.utils.ExampleInputConstants.FULL_FLASHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.GROUP_NAME;
import static seedu.tp.utils.ExampleInputConstants.INDEXES_1;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_GROUP_COMMAND_INPUT_1;
import static seedu.tp.utils.InputTestUtil.convertStringIndexesToIntArray;
import static seedu.tp.utils.InputTestUtil.getGroupFactoryWithInput;

public class GroupCommandTest {
    @Test
    public void groupCommand_execute_Successfully() throws InvalidFlashcardIndexException {
        FlashcardGroup expectedGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FULL_FLASHCARD_LIST,
            convertStringIndexesToIntArray(INDEXES_1));
        GroupList expectedGroupList = new GroupList();
        expectedGroupList.addFlashcardGroup(expectedGroup);

        GroupList actualGroupList = new GroupList();
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT_1, FULL_FLASHCARD_LIST);
        GroupCommand groupCommand = new GroupCommand(groupFactory, actualGroupList);
        groupCommand.execute();

        assertEquals(expectedGroupList, actualGroupList);
    }
}
