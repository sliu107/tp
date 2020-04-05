package seedu.tp;

import seedu.tp.commands.Command;
import seedu.tp.commands.CommandFeedback;
import seedu.tp.exceptions.DuplicateFlashcardException;
import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidDateFormatException;
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
import seedu.tp.studyplan.StudyPlanList;
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
    private StudyPlanList studyPlanList;
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
        studyPlanList = new StudyPlanList();
        parser = new Parser(flashcardFactory, flashcardList, groupFactory, groupList, studyPlanList, ui);

        LoggerUtils.createFolder(LOG_FOLDER);

        try {
            Flashcard.setupLogger();
            FlashcardFactory.setupLogger();
            FlashcardList.setupLogger();
            FlashcardGroup.setupLogger();
            StudyPlanList.setupLogger();
            Command.setupLogger();
            Ui.setupLogger();
            Parser.setupLogger();
        } catch (IOException e) {
            ui.sendLoggingSetupFailedMessage();
        }
    }

    private void runLoop() {
        ui.sendUiLineBreak();
        ui.sendWelcomeMessage();
        while (true) {
            try {
                String fullCommand = ui.getNextLine();
                ui.sendUiLineBreak();
                Command command = parser.parseCommand(fullCommand);
                if (command.isBye()) {
                    break;
                }

                CommandFeedback feedback = command.execute();
                ui.showCommandFeedback(feedback);
                ui.sendUiLineBreak();
            } catch (UnknownCommandException e) {
                ui.sendUnknownCommandResponse();
            } catch (InvalidFlashcardIndexException e) {
                ui.sendInvalidFlashcardIndexResponse();
            } catch (InvalidInputFormatException e) {
                ui.sendInvalidInputFormatResponse();
            } catch (DuplicateFlashcardException e) {
                ui.sendDuplicateFlashcardResponse();
            } catch (InvalidDateFormatException e) {
                ui.sendInvalidDateFormatResponse();
            } catch (HistoryFlashcardException e) {
                ui.printException(e);
            }
        }
        ui.sendByeMessage();
        ui.sendUiLineBreak();
    }
}
