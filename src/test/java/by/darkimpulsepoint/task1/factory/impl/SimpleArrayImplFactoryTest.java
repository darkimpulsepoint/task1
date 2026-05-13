package by.darkimpulsepoint.task1.factory.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
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
        IntegersLineValidator validator = new IntegersLineValidator();
        factory = new IntegerArrayFactory(validator);
    }

    private IntegerArray createExpectedArray(int[] elements) {
        IntegerArray array = new IntegerArray(10);
        for (int element : elements) {
            array.add(element);
        }
        return array;
    }

    @Test
    @DisplayName("Should create IntegerArray for a valid line")
    void testCreateArray_WhenLineIsValid_ShouldReturnOptionalOfArray() {
        String validLine = "10 20 30 40";

        Optional<IntegerArray> resultOptional = factory.createArray(validLine);

        assertTrue(resultOptional.isPresent(), "Optional should contain array for valid line");

        IntegerArray actualArray = resultOptional.get();
        int[] arr = {10, 20, 30, 40};
        IntegerArray expectedArray = createExpectedArray(arr);

        assertEquals(expectedArray, actualArray);
        assertEquals(4, actualArray.size());
    }

    @Test
    @DisplayName("Should return empty Optional for an invalid line")
    void testCreateArray_WhenLineIsInvalid_ShouldReturnEmptyOptional() {
        String invalidLine = "10 abc 30 50";

        Optional<IntegerArray> resultOptional = factory.createArray(invalidLine);

        assertFalse(resultOptional.isPresent(), "Optional should be empty for invalid line");
    }

    @Test
    @DisplayName("Should return empty Optional for an empty line")
    void testCreateArray_WhenLineIsEmpty_ShouldReturnEmptyOptional() {
        String emptyLine = "";

        Optional<IntegerArray> resultOptional = factory.createArray(emptyLine);

        assertFalse(resultOptional.isPresent());
    }

    @Test
    @DisplayName("Should return empty Optional for null line")
    void testCreateArray_WhenLineIsNull_ShouldReturnEmptyOptional() {
        Optional<IntegerArray> resultOptional = factory.createArray(null);

        assertFalse(resultOptional.isPresent());
    }

    @Test
    @DisplayName("Should create array with single element")
    void testCreateArray_WithSingleElement() {
        String line = "999";

        Optional<IntegerArray> resultOptional = factory.createArray(line);

        assertTrue(resultOptional.isPresent());
        assertEquals(1, resultOptional.get().size());
        int[] elements = resultOptional.get().getElements();
        assertEquals(999, elements[0]);
    }

    @Test
    @DisplayName("Should create array with negative numbers")
    void testCreateArray_WithNegativeNumbers() {
        String line = "-5 0 -10 7";

        Optional<IntegerArray> resultOptional = factory.createArray(line);

        assertTrue(resultOptional.isPresent());

        IntegerArray array = resultOptional.get();
        assertEquals(4, array.size());

        int[] elements = array.getElements();
        assertEquals(-5, elements[0]);
        assertEquals(0, elements[1]);
        assertEquals(-10, elements[2]);
        assertEquals(7, elements[3]);
    }

    private Integer getElementSafely(IntegerArray array, int index) {
        try {
            int[] elements = array.getElements();
            return elements[index];
        } catch (Exception e) {
            fail("Failed to get element at index " + index);
            return null;
        }
    }
}