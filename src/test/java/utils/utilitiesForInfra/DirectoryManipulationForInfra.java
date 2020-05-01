package utils.utilitiesForInfra;

import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DirectoryManipulationForInfra {

    /**
     * Delete given directory with subdirectories and files recursively
     *
     * @param dir directory to delete
     * @throws IOException if something goes wrong
     */
    public static void deleteDirectoryWithFiles(String dir)
            throws IOException {
        Path pathToDelete = Paths.get(dir);

        Files.walk(pathToDelete)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);

        Assert.assertFalse(Files.exists(pathToDelete), String.format("Directory '%s' still exists", dir));
    }

    /**
     * Get name of a first file in a directory
     *
     * @param dir directory to search file
     * @return absolute name of a first file in a directory
     * @throws FileNotFoundException directory not exists, empty or contains subdirectories only
     */
    public static String getFirstAbsoluteFileName(String dir) throws FileNotFoundException {
        File[] files = new File(dir).listFiles();

        if (files == null || files.length == 0) {
            throw new FileNotFoundException(String.format("The download directory '%s' not exists or is empty", dir));
        }

        for (File file : files) {
            if (file.isFile()) {
                return file.getAbsolutePath();
            }
        }

        throw new FileNotFoundException(String.format("The directory '%s' does not contain files", dir));
    }

}
