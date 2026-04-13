package by.darkimpulsepoint.task1.parser.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayParserTest {

    private IntegerArrayParser parser;

    @BeforeEach
    void setUp() {
        parser = new IntegerArrayParser();
    }

    @Test
    @DisplayName("Should parse a valid line of positive integers")
    void testParseLine_ValidPositiveIntegers() {
        String line = "1 5 10 25 100";
        Integer[] expected = {1, 5, 10, 25, 100};

        Integer[] actual = parser.parseLine(line);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Should parse a line with negative and zero integers")
    void testParseLine_WithNegativeAndZero() {
        String line = "-10 0 5 -1 50";
        Integer[] expected = {-10, 0, 5, -1, 50};

        Integer[] actual = parser.parseLine(line);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Should handle extra spaces between and around numbers")
    void testParseLine_WithExtraSpaces() {
        String line = "   5    10   -20 ";
        Integer[] expected = {5, 10, -20};

        Integer[] actual = parser.parseLine(line);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Should throw NumberFormatException for a line with invalid characters")
    void testParseLine_InvalidCharacters_ShouldThrowException() {
        String line = "1 2 three 4";

        assertThrows(NumberFormatException.class, () -> {
            parser.parseLine(line);
        });
    }

    @Test
    @DisplayName("Should throw NumberFormatException for an empty string")
    void testParseLine_EmptyString_ShouldThrowException() {
        String line = "";

        assertThrows(NumberFormatException.class, () -> {
            parser.parseLine(line);
        });
    }
}