package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayContainsElementSpecificationTest {

    private IntegerArray array;

    @BeforeEach
    void setUp() {
        array = new IntegerArray(10);
    }

    @Test
    void isSatisfiedBy_ElementExists_ShouldReturnTrue() {
        array.add(1);
        array.add(5);
        array.add(10);

        ArrayContainsElementSpecification specification = new ArrayContainsElementSpecification(5);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_ElementDoesNotExist_ShouldReturnFalse() {
        array.add(1);
        array.add(5);
        array.add(10);

        ArrayContainsElementSpecification specification = new ArrayContainsElementSpecification(99);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_EmptyArray_ShouldReturnFalse() {
        ArrayContainsElementSpecification specification = new ArrayContainsElementSpecification(5);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_NullArray_ShouldReturnFalse() {
        ArrayContainsElementSpecification specification = new ArrayContainsElementSpecification(5);

        assertFalse(specification.isSatisfiedBy(null));
    }
}
