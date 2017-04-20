package com.tonymanou.mowitnow.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class IOUtils {

    private IOUtils() {
        throw new UnsupportedOperationException("Utility class must not be instantiated");
    }

    /**
     * Read all line of the file referenced by the given file path.
     *
     * @param filePath path to the file to load
     * @return A list of lines
     * @throws IOException if an I/O error occurs while reading from the file, or if the path
     *                     string cannot be converted to a {@link Path}
     */
    public static List<String> loadFileLines(String filePath) throws IOException {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (InvalidPathException e) {
            // Wrap unchecked exception into a checked IOException
            throw new IOException(e);
        }
    }
}
