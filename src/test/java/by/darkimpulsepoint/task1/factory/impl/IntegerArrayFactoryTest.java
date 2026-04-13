package by.darkimpulsepoint.task1.factory.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.validator.impl.IntegersLineValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayFactoryTest {

    private IntegerArrayFactory factory;

    @BeforeEach
    void setUp() {
        IntegersLineValidator realValidator = new IntegersLineValidator();
        factory = new IntegerArrayFactory(realValidator);
    }

    @Test
    @DisplayName("Should create IntegerArray for a valid line")
    void testCreateArray_WhenLineIsValid_ShouldReturnOptionalOfIntegerArray() {
        String validLine = "10 20 30";

        Optional<IntegerArray> resultOptional = factory.createArray(validLine);

        assertTrue(resultOptional.isPresent(), "Optional should not be empty for a valid line");

        IntegerArray expectedArray = new IntegerArray(0);
        expectedArray.add(10);
        expectedArray.add(20);
        expectedArray.add(30);

        assertEquals(expectedArray, resultOptional.get());
    }

    @Test
    @DisplayName("Should return empty Optional for an invalid line")
    void testCreateArray_WhenLineIsInvalid_ShouldReturnEmptyOptional() {
        String invalidLine = "10 abc 30";

        Optional<IntegerArray> resultOptional = factory.createArray(invalidLine);

        assertFalse(resultOptional.isPresent(), "Optional should be empty for an invalid line");
    }

    @Test
    @DisplayName("Should return empty Optional for an empty line")
    void testCreateArray_WhenLineIsEmpty_ShouldReturnEmptyOptional() {
        String emptyLine = "";

        Optional<IntegerArray> resultOptional = factory.createArray(emptyLine);

        assertFalse(resultOptional.isPresent());
    }
}