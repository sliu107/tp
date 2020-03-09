package seedu.tp.commands;

import org.junit.jupiter.api.Test;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.tp.utils.ExampleInputConstants.DESCRIPTION;
import static seedu.tp.utils.ExampleInputConstants.FLASHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.GROUP_NAME;
import static seedu.tp.utils.ExampleInputConstants.INDEXES_1;
import static seedu.tp.utils.ExampleInputConstants.INDEXES_2;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT;
import static seedu.tp.utils.InputTestUtil.interpretIndexes;
import static seedu.tp.utils.InputTestUtil.getAddFlashcardToGroupCommandWithInput;

public class AddFlashcardToGroupCommandTest {
    @Test
    public void addFlashcardToGroupCommand_execute_Successfully() throws HistoryFlashcardException {
        FlashcardGroup expectedGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FLASHCARD_LIST, interpretIndexes(INDEXES_2));
        GroupList expectedGroupList = new GroupList();
        expectedGroupList.addFlashcardGroup(expectedGroup);

        FlashcardGroup actualGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FLASHCARD_LIST, interpretIndexes(INDEXES_1));
        GroupList actualGroupList = new GroupList();
        actualGroupList.addFlashcardGroup(actualGroup);

        AddFlashcardToGroupCommand addFlashcardToGroupCommand = getAddFlashcardToGroupCommandWithInput
                (SIMULATED_ADD_FLASHCARD_TO_GROUP_INPUT, FLASHCARD_LIST, actualGroupList);
        addFlashcardToGroupCommand.execute();

        assertEquals(expectedGroupList, actualGroupList);
    }

}
