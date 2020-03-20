package seedu.tp.commands;

import seedu.tp.storage.Savable;
import seedu.tp.storage.Storage;
import seedu.tp.ui.Ui;

import java.io.IOException;

/**
 * Abstract class for commands that modify an object and need to save to disk after executing.
 */
public abstract class ModifyingCommand extends Command {
    Storage storage;
    Ui ui;
    
    protected ModifyingCommand(Storage storage, Ui ui) {
        assert storage != null : "Invalid null Storage!";
        assert ui != null : "Invalid null Ui!";
        this.storage = storage;
        this.ui = ui;
    }
    
    protected void save(Savable savable) {
        try {
            LOGGER.info("Attempting to save " + savable.getFileName() + " to disk...");
            storage.save(savable);
            LOGGER.info("Successfully saved " + savable.getFileName() + " to disk.");
        } catch (IOException e) {
            LOGGER.warning("Save to disk failed for " + savable.getFileName());
            ui.sendFailedToSaveResponse();
        }
    }
}
