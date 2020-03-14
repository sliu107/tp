package seedu.tp;

import seedu.tp.commands.Command;
import seedu.tp.exceptions.DuplicateFlashcardException;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.InvalidInputFormatException;
import seedu.tp.exceptions.UnknownCommandException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupFactory;
import seedu.tp.group.GroupList;
import seedu.tp.parser.Parser;
import seedu.tp.ui.Ui;
import seedu.tp.utils.LoggerUtils;

import java.io.IOException;

import static seedu.tp.utils.Constants.LOG_FOLDER;

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
        parser = new Parser(flashcardFactory, flashcardList, groupFactory, groupList, ui);

        LoggerUtils.createFolder(LOG_FOLDER);
        
        try {
            Flashcard.setupLogger();
            FlashcardFactory.setupLogger();
            FlashcardGroup.setupLogger();
        } catch (IOException e) {
            ui.sendLoggingSetupFailedMessage();
        } 
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
            } catch (InvalidInputFormatException e) {
                ui.sendInvalidInputFormatResponse();
            } catch (DuplicateFlashcardException e) {
                ui.sendDuplicateFlashcardResponse();
            } catch (HistoryFlashcardException e) {
                ui.printException(e);
            }
        }
        ui.sendByeMessage();
    }
}
