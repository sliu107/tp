package seedu.tp.group;

import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.flashcard.EventFlashcard;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;

import static seedu.tp.utils.Constants.DESCRIPTION_FIELD;
import static seedu.tp.utils.Constants.INDEXES_FIELD;
import static seedu.tp.utils.Constants.NAME_FIELD;

/**
 *  A group of flashcards which have some of the same characteristics.
 */
public class FlashcardGroup {
    private String name;
    private String description;
    private FlashcardList groupCards = new FlashcardList();

    /**
     * Constructs a <code>FlashcardGroup</code> using some existing cards from the users original list.
     *
     * @param name the name of the group.
     * @param description brief description of the group.
     * @param originalList the original list of flashcards.
     * @param indexes the indexes of the flashcards which are going to be added to this group.
     */
    public FlashcardGroup(String name, String description, FlashcardList originalList, int[] indexes) {
        this.name = name;
        this.description = description;
        for (int i : indexes) {
            groupCards.addFlashcard(originalList.getFlashcardAtIdx(i));
        }
    }

    /**
     * Adds a flashcard to an existing group.
     *
     * @param flashcard the flashcard to be added.
     */
    public void addFlashcardToTheGroup(Flashcard flashcard) {
        groupCards.addFlashcard(flashcard);
    }

    /**
     * Creates an <code>flashcardGroup</code>  by prompting the user to enter info.
     *
     * @param ui used to prompt the user
     * @param flashcardList the flashcardList which used to create the new group
     * @return the new flashcardGroup
     * @throws InvalidFlashcardIndexException if the indexes given by the users are not integers or out of bounds
     */
    public static FlashcardGroup createGroup(Ui ui, FlashcardList flashcardList) throws InvalidFlashcardIndexException {
        try {
            String name = ui.promptUserForRequiredField(NAME_FIELD);
            String description = ui.promptUserForRequiredField(DESCRIPTION_FIELD);
            String[] indexesGiven = ui.promptUserForRequiredField(INDEXES_FIELD).split(" ");
            int[] indexes = new int[indexesGiven.length];
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = Integer.parseInt(indexesGiven[i]) - 1;
            }
            return new FlashcardGroup(name, description, flashcardList, indexes);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }

    /**
     * Gets the string of a group including some basic information.
     *
     * @return String induction of the group.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Group name: ").append(name).append(System.lineSeparator());
        stringBuilder.append("Group description: ").append(description).append(System.lineSeparator());
        stringBuilder.append("There are ").append(groupCards.getTotalFlashcardNum()).append(" in this group.");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FlashcardList getGroupCards() {
        return groupCards;
    }

    /**
     * Check if the current instance is equal to the object passed in.
     *
     * @param obj The object to be compared against the current instance
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FlashcardGroup)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        FlashcardGroup otherFlashcardGroup = (FlashcardGroup) obj;
        return name.equals(otherFlashcardGroup.getName()) && description.equals(otherFlashcardGroup.getDescription())
                && groupCards.equals(otherFlashcardGroup.getGroupCards());
    }
}
