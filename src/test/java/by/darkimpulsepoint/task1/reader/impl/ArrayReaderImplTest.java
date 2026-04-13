package by.darkimpulsepoint.task1.reader.impl;

import by.darkimpulsepoint.task1.exception.ArrayReaderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayReaderImplTest {

    private ArrayReaderImpl reader;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        reader = new ArrayReaderImpl();
    }

    @Test
    @DisplayName("Should read all lines from an existing file")
    void read_WhenFileExistsAndIsReadable_ShouldReturnListOfLines() throws ArrayReaderException, IOException {
        Path testFile = tempDir.resolve("testfile.txt");

        List<String> expectedLines = Arrays.asList(
                "1 2 3 4 5",
                "10 20 30",
                "-5 0 5"
        );

        Files.write(testFile, expectedLines);

        List<String> actualLines = reader.read(testFile.toString());

        assertNotNull(actualLines);
        assertEquals(expectedLines.size(), actualLines.size());
        assertEquals(expectedLines, actualLines);
    }

    @Test
    @DisplayName("Should throw ArrayReaderException when file does not exist")
    void read_WhenFileDoesNotExist_ShouldThrowArrayReaderException() {
        Path nonExistentFile = tempDir.resolve("non_existent_file.txt");

        ArrayReaderException exception = assertThrows(
                ArrayReaderException.class,
                () -> reader.read(nonExistentFile.toString())
        );

        assertTrue(exception.getMessage().contains("Error reading file"));
    }

    @Test
    @DisplayName("Should return an empty list for an empty file")
    void read_WhenFileIsEmpty_ShouldReturnEmptyList() throws IOException, ArrayReaderException {
        Path emptyFile = tempDir.resolve("empty.txt");
        Files.createFile(emptyFile);

        List<String> actualLines = reader.read(emptyFile.toString());

        assertNotNull(actualLines);
        assertTrue(actualLines.isEmpty());
    }
}