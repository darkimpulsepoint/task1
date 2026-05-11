package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortServiceQuickSortTestImpl {

    private ArraySortServiceImpl service;
    private IntegerArray array;

    @BeforeEach
    void setUp() {
        service = new ArraySortServiceImpl();
        array = new IntegerArray(10);
    }

    @Test
    void quickSort_ShouldSortArrayInAscendingOrder() throws Exception {
        array.add(5);
        array.add(1);
        array.add(4);
        array.add(2);
        array.add(8);

        service.quickSort(array);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(4, array.get(2));
        assertEquals(5, array.get(3));
        assertEquals(8, array.get(4));
    }

    @Test
    void quickSort_ShouldHandleNegativeNumbers() throws Exception {
        array.add(-5);
        array.add(10);
        array.add(0);
        array.add(-20);
        array.add(1);

        service.quickSort(array);

        assertEquals(-20, array.get(0));
        assertEquals(-5, array.get(1));
        assertEquals(0, array.get(2));
        assertEquals(1, array.get(3));
        assertEquals(10, array.get(4));
    }

    @Test
    void quickSort_ShouldHandleAlreadySortedArray() throws Exception {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        service.quickSort(array);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
        assertEquals(4, array.get(3));
        assertEquals(5, array.get(4));
    }

    @Test
    void quickSort_ShouldHandleReverseSortedArray() throws Exception {
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(2);
        array.add(1);

        service.quickSort(array);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
        assertEquals(4, array.get(3));
        assertEquals(5, array.get(4));
    }

    @Test
    void quickSort_ShouldHandleSingleElement() throws Exception {
        array.add(42);

        service.quickSort(array);

        assertEquals(42, array.get(0));
    }

    @Test
    void quickSort_ShouldHandleEmptyArray() throws Exception {
        service.quickSort(array);
        assertEquals(0, array.size());
    }

    @Test
    void quickSort_NullArray_ShouldThrowException() {
        assertThrows(ArrayServiceException.class, () -> service.quickSort(null));
    }
}
