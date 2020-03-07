package seedu.tp;

import seedu.tp.commands.Command;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.UnknownCommandException;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;
import seedu.tp.parser.Parser;
import seedu.tp.ui.Ui;

/**
 * Main class.
 */
public class Main {
    private Ui ui;
    private FlashcardFactory flashcardFactory;
    private FlashcardList flashcardList;
    private GroupFactory groupFactory;
    private GroupList groupList;
    private Parser parser;

    /**
     * Program entry point.
     *
     * @param args CLI args (unused)
     */
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        setup();
        runLoop();
    }

    private void setup() {
        ui = new Ui();
        flashcardFactory = new FlashcardFactory(ui);
        flashcardList = new FlashcardList();
        groupFactory = new GroupFactory(ui, flashcardList);
        groupList = new GroupList();
        parser = new Parser(flashcardFactory, flashcardList, groupFactory, groupList,ui);
    }

    private void runLoop() {
        ui.sendWelcomeMessage();
        boolean isBye = false;
        while (!isBye) {
            try {
                String fullCommand = ui.getNextLine();
                Command command = parser.parseCommand(fullCommand);
                command.execute();
                isBye = command.isBye();
            } catch (UnknownCommandException e) {
                ui.sendUnknownCommandResponse();
            } catch (InvalidFlashcardIndexException e) {
                ui.sendInvalidFlashcardIndexResponse();
            } catch (HistoryFlashcardException e) {
                ui.printException(e);
            }
        }
        ui.sendByeMessage();
    }
}
