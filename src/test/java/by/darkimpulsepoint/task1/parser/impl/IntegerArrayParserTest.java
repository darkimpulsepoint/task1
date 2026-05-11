package by.darkimpulsepoint.task1.parser.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayParserTest {

    private IntegerArrayParser parser;

    @BeforeEach
    void setUp() {
        parser = new IntegerArrayParser();
    }

    @Test
    @DisplayName("Should correctly parse line with multiple integers separated by spaces")
    void shouldParseMultipleIntegers() throws Exception {
        String input = "1 2 3 4 5";

        IntegerArray result = parser.parseLine(input);

        assertEquals(5, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
        assertEquals(4, result.get(3));
        assertEquals(5, result.get(4));
    }

    @Test
    @DisplayName("Should parse line with single integer")
    void shouldParseSingleInteger() throws Exception {
        String input = "42";

        IntegerArray result = parser.parseLine(input);

        assertEquals(1, result.size());
        assertEquals(42, result.get(0));
    }

    @Test
    @DisplayName("Should parse line with negative numbers")
    void shouldParseNegativeNumbers() throws Exception {
        String input = "-5 -10 0 15 -999";

        IntegerArray result = parser.parseLine(input);

        assertEquals(5, result.size());
        assertEquals(-5, result.get(0));
        assertEquals(-10, result.get(1));
        assertEquals(0, result.get(2));
        assertEquals(15, result.get(3));
        assertEquals(-999, result.get(4));
    }

    @Test
    @DisplayName("Should parse line with extra whitespace")
    void shouldHandleExtraWhitespace() throws Exception {
        String input = "  10   20    30  ";

        IntegerArray result = parser.parseLine(input);

        assertEquals(3, result.size());
        assertEquals(10, result.get(0));
        assertEquals(20, result.get(1));
        assertEquals(30, result.get(2));
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
    void shouldParseLargeIntegersWithinRange() throws Exception {
        String input = Integer.MAX_VALUE + " " + Integer.MIN_VALUE + " 0";

        IntegerArray result = parser.parseLine(input);

        assertEquals(3, result.size());
        assertEquals(Integer.MAX_VALUE, result.get(0));
        assertEquals(Integer.MIN_VALUE, result.get(1));
        assertEquals(0, result.get(2));
    }

    @Test
    @DisplayName("Should parse line with only one number and multiple spaces")
    void shouldParseWithMultipleSpaces() throws Exception {
        String input = "   777   ";

        IntegerArray result = parser.parseLine(input);

        assertEquals(1, result.size());
        assertEquals(777, result.get(0));
    }
}