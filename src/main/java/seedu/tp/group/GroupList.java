package seedu.tp.group;

import java.util.ArrayList;
import java.util.List;

/**
 * Lists of flashcard groups.
 */
public class GroupList {
    private List<FlashcardGroup> groupList;

    /**
     * Constructs a list of groups.
     */
    public GroupList(){
        this.groupList = new ArrayList<FlashcardGroup>();
    }

    /**
     * Adds a new group to the group list.
     *
     * @param group the new group to be added to the list
     */
    public void addFlashcardGroup(FlashcardGroup group){
        groupList.add(group);
    }
}
