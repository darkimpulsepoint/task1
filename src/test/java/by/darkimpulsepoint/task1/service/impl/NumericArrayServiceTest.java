package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.SimpleArrayImpl;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.service.NumericArrayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NumericArrayServiceTest {

    private NumericArrayService<Integer> service;

    @BeforeEach
    void setUp() {
        service = new IntegerArrayService();
    }

    private SimpleArrayImpl<Integer> createArrayFrom(int... elements) {
        SimpleArrayImpl<Integer> array = new SimpleArrayImpl<>(10); // начальная ёмкость 10
        for (int el : elements) {
            array.add(el);
        }
        return array;
    }

    @Test
    @DisplayName("bubbleSort should correctly sort a standard array")
    void testBubbleSort_StandardArray() throws SimpleArrayException, ArrayServiceException {
        SimpleArrayImpl<Integer> arrayToSort = createArrayFrom(5, 1, 4, 2, 8);
        SimpleArrayImpl<Integer> expectedArray = createArrayFrom(1, 2, 4, 5, 8);

        service.bubbleSort(arrayToSort);

        assertEquals(expectedArray, arrayToSort);
    }

    @Test
    @DisplayName("bubbleSort should handle an array with negative numbers")
    void testBubbleSort_WithNegativeNumbers() throws SimpleArrayException, ArrayServiceException {
        SimpleArrayImpl<Integer> arrayToSort = createArrayFrom(-5, 10, 0, -20, 1);
        SimpleArrayImpl<Integer> expectedArray = createArrayFrom(-20, -5, 0, 1, 10);

        service.bubbleSort(arrayToSort);

        assertEquals(expectedArray, arrayToSort);
    }

    @Test
    @DisplayName("bubbleSort should not fail on an empty array")
    void testBubbleSort_EmptyArray() throws SimpleArrayException, ArrayServiceException {
        SimpleArrayImpl<Integer> emptyArray = createArrayFrom();
        SimpleArrayImpl<Integer> expectedArray = createArrayFrom();

        service.bubbleSort(emptyArray);

        assertEquals(expectedArray, emptyArray);
    }

    @Test
    @DisplayName("bubbleSort should handle an already sorted array")
    void testBubbleSort_AlreadySortedArray() throws SimpleArrayException, ArrayServiceException {
        SimpleArrayImpl<Integer> sortedArray = createArrayFrom(10, 20, 30, 40);
        SimpleArrayImpl<Integer> expectedArray = createArrayFrom(10, 20, 30, 40);

        service.bubbleSort(sortedArray);

        assertEquals(expectedArray, sortedArray);
    }

    @Test
    @DisplayName("findMaxElement should find the max value in a standard array")
    void testFindMaxElement_StandardArray() throws SimpleArrayException {
        SimpleArrayImpl<Integer> array = createArrayFrom(1, 50, 2, -10, 25);

        Optional<Integer> maxOptional = service.findMaxElement(array);

        assertTrue(maxOptional.isPresent());
        assertEquals(50, maxOptional.get());
    }

    @Test
    @DisplayName("findMaxElement should return empty Optional for an empty array")
    void testFindMaxElement_EmptyArray() throws SimpleArrayException {
        SimpleArrayImpl<Integer> emptyArray = createArrayFrom();

        Optional<Integer> maxOptional = service.findMaxElement(emptyArray);

        assertFalse(maxOptional.isPresent());
    }

    @Test
    @DisplayName("findMinElement should find the min value in a standard array")
    void testFindMinElement_StandardArray() throws SimpleArrayException {
        SimpleArrayImpl<Integer> array = createArrayFrom(1, 50, 2, -10, 25);

        Optional<Integer> minOptional = service.findMinElement(array);

        assertTrue(minOptional.isPresent());
        assertEquals(-10, minOptional.get());
    }

    @Test
    @DisplayName("findMinElement should return empty Optional for an empty array")
    void testFindMinElement_EmptyArray() throws SimpleArrayException {
        SimpleArrayImpl<Integer> emptyArray = createArrayFrom();

        Optional<Integer> minOptional = service.findMinElement(emptyArray);

        assertEquals(Optional.empty(), minOptional);
    }

    @Test
    @DisplayName("findSum should calculate the correct sum")
    void testFindSum_StandardArray() throws SimpleArrayException {
        SimpleArrayImpl<Integer> array = createArrayFrom(10, 20, -5, 1);

        var actualSum = service.findSum(array);

        assertEquals(26, actualSum.get());
    }

    @Test
    @DisplayName("findSum should return 0 for an empty array")
    void testFindSum_EmptyArray() {
        SimpleArrayImpl<Integer> emptyArray = createArrayFrom();

        var actualSum = service.findSum(emptyArray);

        assertEquals(0, actualSum.get());
    }

    @Test
    @DisplayName("findAverage should calculate the correct average")
    void testFindAverage_StandardArray() {
        SimpleArrayImpl<Integer> array = createArrayFrom(1, 2, 3, 4, 5);

        var actualAverage = service.findAverage(array);

        assertEquals(3.0, actualAverage.get(), 0.0001);
    }

    @Test
    @DisplayName("findAverage should handle floating point results correctly")
    void testFindAverage_FloatingPointResult() throws SimpleArrayException {
        SimpleArrayImpl<Integer> array = createArrayFrom(1, 2, 4, 4);


    }

    @Test
    @DisplayName("findAverage should return 0.0 for an empty array")
    void testFindAverage_EmptyArray() throws SimpleArrayException {
        SimpleArrayImpl<Integer> emptyArray = createArrayFrom();

        var actualAverage = service.findAverage(emptyArray);

        assertEquals(false, actualAverage.isPresent());
    }

    @Test
    @DisplayName("bubbleSort should throw SimpleArrayException when array is null")
    void testBubbleSort_NullArray() {
        assertThrows(ArrayServiceException.class, () -> service.bubbleSort(null));
    }

    @Test
    @DisplayName("findMaxElement should throw SimpleArrayException when array is null")
    void testFindMaxElement_NullArray() {
        assertEquals(false, service.findMaxElement(null).isPresent());
    }
}