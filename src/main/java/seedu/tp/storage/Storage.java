package seedu.tp.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static seedu.tp.utils.Constants.SAVE_FOLDER;

/**
 * Class to save/load savables as JSON.
 */
public class Storage {
    private Gson gson;
    private static final String FILE_EXTENSION = ".json";
    
    public Storage() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    private String getJson(Savable savable) {
        return gson.toJson(savable);
    }

    /**
     * Save the savable as a formatted JSON string.
     * @param savable
     * @throws IOException
     */
    public void save(Savable savable) throws IOException {
        File saveFolder = new File(SAVE_FOLDER);
        if (!saveFolder.exists()) {
            saveFolder.mkdir();
        }
        
        String pathName = SAVE_FOLDER + savable.getFileName() + FILE_EXTENSION;
        File file = new File(pathName);
        if (!file.exists()) {
            file.createNewFile();
        }
        
        String fileContents = getJson(savable);
        FileWriter fileWriter = new FileWriter(pathName);
        fileWriter.write(fileContents);
        fileWriter.close();
    }
}
