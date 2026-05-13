package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortServiceImplTest {

    private ArraySortServiceImpl service;
    private IntegerArray array;

    @BeforeEach
    void setUp() {
        service = new ArraySortServiceImpl();
        array = new IntegerArray(10);
    }

    @Test
    void bubbleSort_ShouldSortArrayInAscendingOrder() throws Exception {
        array.add(5);
        array.add(1);
        array.add(4);
        array.add(2);
        array.add(8);

        service.bubbleSort(array);

        int[] elements = array.getElements();
        assertEquals(1, elements[0]);
        assertEquals(2, elements[1]);
        assertEquals(4, elements[2]);
        assertEquals(5, elements[3]);
        assertEquals(8, elements[4]);
    }

    @Test
    void bubbleSort_NullArray_ShouldThrowException() {
        assertThrows(ArrayServiceException.class, () -> service.bubbleSort(null));
    }
}
