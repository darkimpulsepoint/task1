package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class NumericArrayServiceTest {

    private ArraySortServiceImpl sortService;
    private ArrayMathServiceImpl mathService;

    @BeforeEach
    void setUp() {
        sortService = new ArraySortServiceImpl();
        mathService = new ArrayMathServiceImpl();
    }

    private IntegerArray createArrayFrom(int... elements) {
        IntegerArray array = new IntegerArray(10);
        for (int el : elements) {
            array.add(el);
        }
        return array;
    }

    @Test
    @DisplayName("bubbleSort should correctly sort a standard array")
    void testBubbleSort_StandardArray() throws ArrayServiceException {
        IntegerArray arrayToSort = createArrayFrom(5, 1, 4, 2, 8);
        IntegerArray expectedArray = createArrayFrom(1, 2, 4, 5, 8);

        sortService.bubbleSort(arrayToSort);

        assertEquals(expectedArray, arrayToSort);
    }

    @Test
    @DisplayName("bubbleSort should handle an array with negative numbers")
    void testBubbleSort_WithNegativeNumbers() throws ArrayServiceException {
        IntegerArray arrayToSort = createArrayFrom(-5, 10, 0, -20, 1);
        IntegerArray expectedArray = createArrayFrom(-20, -5, 0, 1, 10);

        sortService.bubbleSort(arrayToSort);

        assertEquals(expectedArray, arrayToSort);
    }

    @Test
    @DisplayName("bubbleSort should not fail on an empty array")
    void testBubbleSort_EmptyArray() throws ArrayServiceException {
        IntegerArray emptyArray = createArrayFrom();
        IntegerArray expectedArray = createArrayFrom();

        sortService.bubbleSort(emptyArray);

        assertEquals(expectedArray, emptyArray);
    }

    @Test
    @DisplayName("bubbleSort should handle an already sorted array")
    void testBubbleSort_AlreadySortedArray() throws ArrayServiceException {
        IntegerArray sortedArray = createArrayFrom(10, 20, 30, 40);
        IntegerArray expectedArray = createArrayFrom(10, 20, 30, 40);

        sortService.bubbleSort(sortedArray);

        assertEquals(expectedArray, sortedArray);
    }

    @Test
    @DisplayName("findMaxElement should find the max value in a standard array")
    void testFindMaxElement_StandardArray() {
        IntegerArray array = createArrayFrom(1, 50, 2, -10, 25);

        Optional<Integer> maxOptional = mathService.findMaxElement(array);

        assertTrue(maxOptional.isPresent());
        assertEquals(50, maxOptional.get());
    }

    @Test
    @DisplayName("findMaxElement should return empty Optional for an empty array")
    void testFindMaxElement_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        Optional<Integer> maxOptional = mathService.findMaxElement(emptyArray);

        assertFalse(maxOptional.isPresent());
    }

    @Test
    @DisplayName("findMinElement should find the min value in a standard array")
    void testFindMinElement_StandardArray() {
        IntegerArray array = createArrayFrom(1, 50, 2, -10, 25);

        Optional<Integer> minOptional = mathService.findMinElement(array);

        assertTrue(minOptional.isPresent());
        assertEquals(-10, minOptional.get());
    }

    @Test
    @DisplayName("findMinElement should return empty Optional for an empty array")
    void testFindMinElement_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        Optional<Integer> minOptional = mathService.findMinElement(emptyArray);

        assertEquals(Optional.empty(), minOptional);
    }

    @Test
    @DisplayName("findSum should calculate the correct sum")
    void testFindSum_StandardArray() {
        IntegerArray array = createArrayFrom(10, 20, -5, 1);

        var actualSum = mathService.findSum(array);

        assertEquals(26, actualSum.get());
    }

    @Test
    @DisplayName("findSum should return empty Optional for an empty array")
    void testFindSum_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        var actualSum = mathService.findSum(emptyArray);

        assertTrue(actualSum.isEmpty());
    }

    @Test
    @DisplayName("findAverage should calculate the correct average")
    void testFindAverage_StandardArray() {
        IntegerArray array = createArrayFrom(1, 2, 3, 4, 5);

        var actualAverage = mathService.findAverage(array);

        assertEquals(3.0, actualAverage.get(), 0.0001);
    }

    @Test
    @DisplayName("findAverage should return empty Optional for an empty array")
    void testFindAverage_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        var actualAverage = mathService.findAverage(emptyArray);

        assertFalse(actualAverage.isPresent());
    }

    @Test
    @DisplayName("bubbleSort should throw ArrayServiceException when array is null")
    void testBubbleSort_NullArray() {
        assertThrows(ArrayServiceException.class, () -> sortService.bubbleSort(null));
    }

    @Test
    @DisplayName("findMaxElement should return empty Optional when array is null")
    void testFindMaxElement_NullArray() {
        assertFalse(mathService.findMaxElement(null).isPresent());
    }
}