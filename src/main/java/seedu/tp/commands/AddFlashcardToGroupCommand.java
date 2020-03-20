package seedu.tp.commands;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.InvalidInputFormatException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupList;
import seedu.tp.storage.Storage;
import seedu.tp.ui.Ui;

import static seedu.tp.utils.Constants.INDEX_FIELD;
import static seedu.tp.utils.Constants.NAME_FIELD;

public class AddFlashcardToGroupCommand extends ModifyingCommand {
    private Ui ui;
    private GroupList groupList;
    private FlashcardList flashcardList;

    /**
     * Constructs an addFlashcardToGroupCommand.
     *
     * @param ui            the ui need to pass to the execution method
     * @param groupList     the groupList where the flashcard wants to be added in
     * @param flashcardList the flashcardList where the flashcard is in
     */
    public AddFlashcardToGroupCommand(Ui ui, GroupList groupList, FlashcardList flashcardList, Storage storage) {
        super(storage, ui);
        assert flashcardList != null : "Invalid null FlashcardList!";
        assert groupList != null : "Invalid null GroupList!";

        this.ui = ui;
        this.groupList = groupList;
        this.flashcardList = flashcardList;
    }

    @Override
    public void execute() throws HistoryFlashcardException {
        try {
            int flashcardIndex = Integer.parseInt(ui.promptUserForRequiredField(INDEX_FIELD)) - 1;
            String groupName = ui.promptUserForRequiredField(NAME_FIELD);
            
            FlashcardGroup group = groupList.getGroupByName(groupName);
            Flashcard flashcard = flashcardList.getFlashcardAtIdx(flashcardIndex);

            LOGGER.info("Adding a flashcard to an existing group...");
            group.addFlashcardToTheGroup(flashcard);
            ui.confirmAddToGroup(flashcard, group);
            LOGGER.info("Added the flashcard to the group");
            save(group);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AddFlashcardToGroupCommand)) {
            return false;
        }

        AddFlashcardToGroupCommand otherAddFlashcardToGroupCommand = (AddFlashcardToGroupCommand) obj;
        return this.getFlashcardList().equals(otherAddFlashcardToGroupCommand.getFlashcardList())
            && this.getGroupList().equals(otherAddFlashcardToGroupCommand.getGroupList());
    }

    public GroupList getGroupList() {
        return groupList;
    }

    public FlashcardList getFlashcardList() {
        return flashcardList;
    }
}