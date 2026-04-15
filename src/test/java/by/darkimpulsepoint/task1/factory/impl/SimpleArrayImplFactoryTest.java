package by.darkimpulsepoint.task1.factory.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.entity.SimpleArrayImpl;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.validator.impl.IntegersLineValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NumericArrayFactoryTest {

    private NumericArrayFactory factory;

    @BeforeEach
    void setUp() {
        IntegersLineValidator validator = new IntegersLineValidator();
        factory = new NumericArrayFactory(validator);
    }

    private SimpleArrayImpl<Integer> createExpectedArray(int[] elements) {
        SimpleArrayImpl<Integer> array = new SimpleArrayImpl<>(10);
        for (int element : elements) {
            array.add(element);
        }
        return array;
    }

    @Test
    @DisplayName("Should create NumericArray for a valid line")
    void testCreateArray_WhenLineIsValid_ShouldReturnOptionalOfArray() {
        String validLine = "10 20 30 40";

        Optional<SimpleArray<Integer>> resultOptional = factory.createArray(validLine);

        assertTrue(resultOptional.isPresent(), "Optional should contain array for valid line");

        SimpleArray<Integer> actualArray = resultOptional.get();
        int[] arr = {10, 20, 30, 40};
        SimpleArrayImpl<Integer> expectedArray = createExpectedArray(arr);

        assertEquals(expectedArray, actualArray);
        assertEquals(4, actualArray.size());
    }

    @Test
    @DisplayName("Should return empty Optional for an invalid line")
    void testCreateArray_WhenLineIsInvalid_ShouldReturnEmptyOptional() {
        String invalidLine = "10 abc 30 50";

        Optional<SimpleArray<Integer>> resultOptional = factory.createArray(invalidLine);

        assertFalse(resultOptional.isPresent(), "Optional should be empty for invalid line");
    }

    @Test
    @DisplayName("Should return empty Optional for an empty line")
    void testCreateArray_WhenLineIsEmpty_ShouldReturnEmptyOptional() {
        String emptyLine = "";

        Optional<SimpleArray<Integer>> resultOptional = factory.createArray(emptyLine);

        assertFalse(resultOptional.isPresent());
    }

    @Test
    @DisplayName("Should return empty Optional for null line")
    void testCreateArray_WhenLineIsNull_ShouldReturnEmptyOptional() {
        Optional<SimpleArray<Integer>> resultOptional = factory.createArray(null);

        assertFalse(resultOptional.isPresent());
    }

    @Test
    @DisplayName("Should create array with single element")
    void testCreateArray_WithSingleElement() throws SimpleArrayException {
        String line = "999";

        Optional<SimpleArray<Integer>> resultOptional = factory.createArray(line);

        assertTrue(resultOptional.isPresent());
        assertEquals(1, resultOptional.get().size());
        assertEquals(999, resultOptional.get().get(0));
    }

    @Test
    @DisplayName("Should create array with negative numbers")
    void testCreateArray_WithNegativeNumbers() {
        String line = "-5 0 -10 7";

        Optional<SimpleArray<Integer>> resultOptional = factory.createArray(line);

        assertTrue(resultOptional.isPresent());

        SimpleArray<Integer> array = resultOptional.get();
        assertEquals(4, array.size());

        // Проверяем содержимое
        assertEquals(-5, getElementSafely(array, 0));
        assertEquals(0, getElementSafely(array, 1));
        assertEquals(-10, getElementSafely(array, 2));
        assertEquals(7, getElementSafely(array, 3));
    }

    private Integer getElementSafely(SimpleArray<Integer> array, int index) {
        try {
            return array.get(index);
        } catch (Exception e) {
            fail("Failed to get element at index " + index);
            return null;
        }
    }
}