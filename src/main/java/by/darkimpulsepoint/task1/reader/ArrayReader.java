package by.darkimpulsepoint.task1.reader;

import by.darkimpulsepoint.task1.exception.ArrayReaderException;
import java.util.List;

public interface ArrayReader {
    List<String> read(String path) throws ArrayReaderException;
}