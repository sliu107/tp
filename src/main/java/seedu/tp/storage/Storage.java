package seedu.tp.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import seedu.tp.exceptions.DeletionFailedException;
import seedu.tp.exceptions.UnrecognizedFlashcardTypeException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardFactory;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.group.FlashcardGroup;
import seedu.tp.group.GroupList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.tp.utils.Constants.LOG_FOLDER;
import static seedu.tp.utils.Constants.SAVE_FOLDER;

/**
 * Class to save/load savables as JSON.
 */
public class Storage {
    private static final Logger LOGGER = Logger.getLogger(Storage.class.getName());
    private static final String FILE_PATH = LOG_FOLDER + "storage.log";
    private static final String FILE_EXTENSION = ".json";
    private static Storage storage = null;
    private Gson gson;

    private Storage() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Flashcard.class, new AClassAdapter<Flashcard>());
        builder.setPrettyPrinting();
        this.gson = builder.create();
    }

    /**
     * Get an instance of the Storage object.
     *
     * @return the static Storage instance
     */
    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }
    
    private String getJson(Savable savable) {
        return gson.toJson(savable);
    }

    /**
     * Set up the Storage logger. Call once at the start of the program.
     *
     * @throws IOException when logger set up failed
     */
    public static void setupLogger() throws IOException {
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);
        FileHandler fileHandler = new FileHandler(FILE_PATH, true);
        fileHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileHandler);
    }

    /**
     * Save the savable as a formatted JSON string.
     *
     * @param savable the savable to save
     * @throws IOException if the save fails
     */
    public void save(Savable savable) throws IOException {
        String pathName = SAVE_FOLDER + "/" + savable.getFileName() + FILE_EXTENSION;
        File file = new File(pathName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        
        String fileContents;
        if (savable instanceof Flashcard) {
            fileContents = gson.toJson(savable, Flashcard.class);
        } else {
            fileContents = gson.toJson(savable);
        }
        
        FileWriter fileWriter = new FileWriter(pathName);
        fileWriter.write(fileContents);
        fileWriter.close();
    }

    /**
     * Delete a savable from disk.
     *
     * @param savable the savable to delete
     * @throws DeletionFailedException if the deletion fails
     */
    public void delete(Savable savable) throws DeletionFailedException {
        String pathName = SAVE_FOLDER + savable.getFileName() + FILE_EXTENSION;
        File file = new File(pathName);

        boolean success = file.delete();
        if (!success) {
            throw new DeletionFailedException();
        }
    }

    /**
     * Call once at the start of the program to load flashcards and groups from file.
     * @param flashcardList the FlashcardList to load into
     * @param groupList the GroupList to load into
     */
    public void loadAll(FlashcardList flashcardList, GroupList groupList) {
        final String flashcardsFolderString = SAVE_FOLDER + "/" + Flashcard.FLASHCARDS_FOLDER;
        final String groupsFolderString = SAVE_FOLDER + "/" + FlashcardGroup.GROUPS_FOLDER;
        File flashcardsFolder = new File(flashcardsFolderString);
        File groupsFolder = new File(groupsFolderString);
        
        if (flashcardsFolder.exists()) {
            for (File f : flashcardsFolder.listFiles()) {
                try {
                    Flashcard flashcard = gson.fromJson(new FileReader(f), Flashcard.class);
                    flashcardList.addFlashcard(flashcard);
                    LOGGER.info("File: " + f.toString() + " was loaded from disk.");
                } catch (FileNotFoundException e) {
                    LOGGER.warning("File: " + f.toString() + " was not found when loading from disk.");
                }
            }
        }
        
        if (groupsFolder.exists()) {
            for (File f : groupsFolder.listFiles()) {
                try {
                    FlashcardGroup group = gson.fromJson(new FileReader(f), FlashcardGroup.class);
                    groupList.addFlashcardGroup(group);
                    LOGGER.info("File: " + f.toString() + " was loaded from disk.");
                } catch (FileNotFoundException e) {
                    LOGGER.warning("File: " + f.toString() + " was not found when loading from disk.");
                }
            }
        }
    }
}
