package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.impl.SimpleArrayImpl;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArraySortServiceTest {

    private IntegerArraySortService service;
    private SimpleArrayImpl<Integer> array;

    @BeforeEach
    void setUp() {
        service = new IntegerArraySortService();
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
}
