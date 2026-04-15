package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.SimpleArrayImpl;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayServiceTest {

    private IntegerArrayService service;
    private SimpleArrayImpl<Integer> array;

    @BeforeEach
    void setUp() {
        service = new IntegerArrayService();
        array = new SimpleArrayImpl<>(10);
    }

    @Test
    void bubbleSort_ShouldSortArrayInAscendingOrder() throws Exception {
        array.add(5);
        array.add(1);
        array.add(4);
        array.add(2);
        array.add(8);

        service.bubbleSort(array);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(4, array.get(2));
        assertEquals(5, array.get(3));
        assertEquals(8, array.get(4));
    }

    @Test
    void bubbleSort_NullArray_ShouldThrowException() {
        assertThrows(ArrayServiceException.class, () -> service.bubbleSort(null));
    }

    @Test
    void findMaxElement_ShouldReturnMaximumValue() {
        array.add(5);
        array.add(15);
        array.add(3);

        Optional<Integer> max = service.findMaxElement(array);

        assertTrue(max.isPresent());
        assertEquals(15, max.get());
    }

    @Test
    void findMaxElement_EmptyArray_ShouldReturnEmptyOptional() {
        Optional<Integer> max = service.findMaxElement(array);
        assertTrue(max.isEmpty());
    }

    @Test
    void findMinElement_ShouldReturnMinimumValue() {
        array.add(5);
        array.add(1);
        array.add(3);

        Optional<Integer> min = service.findMinElement(array);

        assertTrue(min.isPresent());
        assertEquals(1, min.get());
    }

    @Test
    void findMinElement_NullArray_ShouldReturnEmptyOptional() {
        Optional<Integer> min = service.findMinElement(null);
        assertTrue(min.isEmpty());
    }

    @Test
    void findSum_ShouldReturnCorrectSum() {
        array.add(5);
        array.add(10);
        array.add(15);

        Optional<Integer> sum = service.findSum(array);

        assertTrue(sum.isPresent());
        assertEquals(30, sum.get());
    }

    @Test
    void findSum_WithNullElements_ShouldIgnoreNullsAndReturnSum() {
        array.add(5);
        array.add(null);
        array.add(10);

        Optional<Integer> sum = service.findSum(array);

        assertTrue(sum.isPresent());
        assertEquals(15, sum.get());
    }

    @Test
    void findAverage_ShouldReturnCorrectAverage() {
        array.add(2);
        array.add(4);
        array.add(6);
        array.add(8);

        Optional<Double> average = service.findAverage(array);

        assertTrue(average.isPresent());
        assertEquals(5.0, average.get());
    }

    @Test
    void findAverage_EmptyArray_ShouldReturnEmptyOptional() {
        Optional<Double> average = service.findAverage(array);
        assertTrue(average.isEmpty());
    }
}