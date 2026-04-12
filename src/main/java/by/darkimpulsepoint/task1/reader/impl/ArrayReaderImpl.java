package by.darkimpulsepoint.task1.reader.impl;

import by.darkimpulsepoint.task1.exception.ArrayReaderException;
import by.darkimpulsepoint.task1.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> read(String filename) throws ArrayReaderException {
        Path path = Paths.get(filename);
        List<String> data;
        try {
            data = Files.readAllLines(path);
            logger.info("Succesfully read {}", filename);
        } catch (IOException e) {
            logger.error("Error reading file {}", filename);
            throw new ArrayReaderException("Error reading file " + filename);
        }

        return data;
    }
}