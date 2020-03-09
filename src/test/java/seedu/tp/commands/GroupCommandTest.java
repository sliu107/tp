package seedu.tp.commands;

import org.junit.jupiter.api.Test;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.tp.utils.ExampleInputConstants.DESCRIPTION;
import static seedu.tp.utils.ExampleInputConstants.FLASHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.INDEXES;
import static seedu.tp.utils.ExampleInputConstants.NAME;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_GROUP_COMMAND_INPUT1;
import static seedu.tp.utils.InputTestUtil.getGroupFactoryWithInput;
import static seedu.tp.utils.InputTestUtil.interpretIndexes;

public class GroupCommandTest {
    @Test
    public void groupCommand_execute_Successfully() throws InvalidFlashcardIndexException {
        FlashcardGroup expectedGroup = new FlashcardGroup(NAME, DESCRIPTION, FLASHCARD_LIST, interpretIndexes(INDEXES));
        GroupList expectedGroupList = new GroupList();
        expectedGroupList.addFlashcardGroup(expectedGroup);

        GroupList actualGroupList = new GroupList();
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT1);
        GroupCommand groupCommand = new GroupCommand(FLASHCARD_LIST, groupFactory, actualGroupList);
        groupCommand.execute();

        assertEquals(expectedGroupList, actualGroupList);
    }
}
