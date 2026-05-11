package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMathServiceImplTest {

    private ArrayMathServiceImpl service;
    private IntegerArray array;

    @BeforeEach
    void setUp() {
        service = new ArrayMathServiceImpl();
        array = new IntegerArray(10);
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
    void findSum_EmptyArray_ShouldReturnEmptyOptional() {
        Optional<Integer> sum = service.findSum(array);
        assertTrue(sum.isEmpty());
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
