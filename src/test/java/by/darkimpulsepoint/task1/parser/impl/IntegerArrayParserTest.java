package by.darkimpulsepoint.task1.parser.impl;

import by.darkimpulsepoint.task1.parser.ArrayParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayParserTest {

    private ArrayParser<Integer> parser;

    @BeforeEach
    void setUp() {
        parser = new IntegerArrayParser();
    }

    @Test
    @DisplayName("Should correctly parse line with multiple integers separated by spaces")
    void shouldParseMultipleIntegers() {
        String input = "1 2 3 4 5";
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] result = parser.parseLine(input);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Should parse line with single integer")
    void shouldParseSingleInteger() {
        String input = "42";
        Integer[] expected = {42};

        Integer[] result = parser.parseLine(input);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Should parse line with negative numbers")
    void shouldParseNegativeNumbers() {
        String input = "-5 -10 0 15 -999";
        Integer[] expected = {-5, -10, 0, 15, -999};

        Integer[] result = parser.parseLine(input);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Should parse line with extra whitespace")
    void shouldHandleExtraWhitespace() {
        String input = "  10   20    30  ";
        Integer[] expected = {10, 20, 30};

        Integer[] result = parser.parseLine(input);

        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Should throw NullPointerException when input is null")
    void shouldThrowExceptionWhenInputIsNull(String input) {
        assertThrows(NullPointerException.class, () -> parser.parseLine(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 2 abc 4",
            "123 45.6 78",
            "1 two 3",
            "1 2 3.14"
    })
    @DisplayName("Should throw NumberFormatException for invalid integer formats")
    void shouldThrowNumberFormatExceptionForInvalidInput(String input) {
        assertThrows(NumberFormatException.class, () -> parser.parseLine(input));
    }

    @Test
    @DisplayName("Should handle very large integers within Integer range")
    void shouldParseLargeIntegersWithinRange() {
        String input = Integer.MAX_VALUE + " " + Integer.MIN_VALUE + " 0";
        Integer[] expected = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        Integer[] result = parser.parseLine(input);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Should parse line with only one number and multiple spaces")
    void shouldParseWithMultipleSpaces() {
        String input = "   777   ";
        Integer[] expected = {777};

        Integer[] result = parser.parseLine(input);

        assertArrayEquals(expected, result);
    }
}