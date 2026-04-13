package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayServiceTest {

    private IntegerArrayService service;

    @BeforeEach
    void setUp() {
        service = new IntegerArrayService();
    }

    private IntegerArray createArrayFrom(int... elements) {
        IntegerArray array = new IntegerArray(0);
        for (int el : elements) {
            array.add(el);
        }
        return array;
    }

    @Test
    @DisplayName("bubbleSort should correctly sort a standard array")
    void testBubbleSort_StandardArray() {
        IntegerArray arrayToSort = createArrayFrom(5, 1, 4, 2, 8);
        IntegerArray expectedArray = createArrayFrom(1, 2, 4, 5, 8);

        service.bubbleSort(arrayToSort);

        assertEquals(expectedArray, arrayToSort);
    }

    @Test
    @DisplayName("bubbleSort should handle an array with negative numbers")
    void testBubbleSort_WithNegativeNumbers() {
        IntegerArray arrayToSort = createArrayFrom(-5, 10, 0, -20, 1);
        IntegerArray expectedArray = createArrayFrom(-20, -5, 0, 1, 10);

        service.bubbleSort(arrayToSort);

        assertEquals(expectedArray, arrayToSort);
    }

    @Test
    @DisplayName("bubbleSort should not fail on an empty array")
    void testBubbleSort_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();
        IntegerArray expectedArray = createArrayFrom();

        service.bubbleSort(emptyArray);

        assertEquals(expectedArray, emptyArray);
    }

    @Test
    @DisplayName("bubbleSort should handle an already sorted array")
    void testBubbleSort_AlreadySortedArray() {
        IntegerArray sortedArray = createArrayFrom(10, 20, 30, 40);
        IntegerArray expectedArray = createArrayFrom(10, 20, 30, 40);

        service.bubbleSort(sortedArray);

        assertEquals(expectedArray, sortedArray);
    }

    @Test
    @DisplayName("findMaxElement should find the max value in a standard array")
    void testFindMaxElement_StandardArray() {
        IntegerArray array = createArrayFrom(1, 50, 2, -10, 25);

        Optional<Integer> maxOptional = service.findMaxElement(array);

        assertTrue(maxOptional.isPresent());
        assertEquals(50, maxOptional.get());
    }

    @Test
    @DisplayName("findMaxElement should return empty Optional for an empty array")
    void testFindMaxElement_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        Optional<Integer> maxOptional = service.findMaxElement(emptyArray);

        assertFalse(maxOptional.isPresent());
    }

    @Test
    @DisplayName("findMinElement should find the min value in a standard array")
    void testFindMinElement_StandardArray() {
        IntegerArray array = createArrayFrom(1, 50, 2, -10, 25);

        Optional<Integer> minOptional = service.findMinElement(array);

        assertTrue(minOptional.isPresent());
        assertEquals(-10, minOptional.get());
    }

    @Test
    @DisplayName("findMinElement should return empty Optional for an empty array")
    void testFindMinElement_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        Optional<Integer> minOptional = service.findMinElement(emptyArray);

        assertEquals(Optional.empty(), minOptional);
    }

    @Test
    @DisplayName("findSum should calculate the correct sum")
    void testFindSum_StandardArray() {
        IntegerArray array = createArrayFrom(10, 20, -5, 1);

        Integer sum = service.findSum(array);

        assertEquals(26, sum);
    }

    @Test
    @DisplayName("findSum should return 0 for an empty array")
    void testFindSum_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        Integer sum = service.findSum(emptyArray);

        assertEquals(0, sum);
    }

    @Test
    @DisplayName("findAverage should calculate the correct average")
    void testFindAverage_StandardArray() {
        IntegerArray array = createArrayFrom(1, 2, 3, 4, 5);

        Double average = service.findAverage(array);

        assertEquals(3.0, average, 0.0001);
    }

    @Test
    @DisplayName("findAverage should handle floating point results correctly")
    void testFindAverage_FloatingPointResult() {
        IntegerArray array = createArrayFrom(1, 2, 4, 4);

        Double average = service.findAverage(array);

        assertEquals(2.75, average, 0.0001);
    }

    @Test
    @DisplayName("findAverage should return 0.0 for an empty array")
    void testFindAverage_EmptyArray() {
        IntegerArray emptyArray = createArrayFrom();

        Double average = service.findAverage(emptyArray);

        assertEquals(0.0, average, 0.0001);
    }
}