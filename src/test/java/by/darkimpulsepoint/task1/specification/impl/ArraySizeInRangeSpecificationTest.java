package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySizeInRangeSpecificationTest {

    private IntegerArray array;

    @BeforeEach
    void setUp() {
        array = new IntegerArray(10);
    }

    @Test
    void isSatisfiedBy_SizeInRange_ShouldReturnTrue() {
        array.add(1);
        array.add(2);
        array.add(3);

        ArraySizeInRangeSpecification specification = new ArraySizeInRangeSpecification(2, 5);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeBelowRange_ShouldReturnFalse() {
        array.add(1);

        ArraySizeInRangeSpecification specification = new ArraySizeInRangeSpecification(2, 5);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeAboveRange_ShouldReturnFalse() {
        for (int i = 0; i < 6; i++) {
            array.add(i);
        }

        ArraySizeInRangeSpecification specification = new ArraySizeInRangeSpecification(2, 5);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeAtMinBoundary_ShouldReturnTrue() {
        array.add(1);
        array.add(2);

        ArraySizeInRangeSpecification specification = new ArraySizeInRangeSpecification(2, 5);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeAtMaxBoundary_ShouldReturnTrue() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }

        ArraySizeInRangeSpecification specification = new ArraySizeInRangeSpecification(2, 5);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_NullArray_ShouldReturnFalse() {
        ArraySizeInRangeSpecification specification = new ArraySizeInRangeSpecification(2, 5);

        assertFalse(specification.isSatisfiedBy(null));
    }
}
