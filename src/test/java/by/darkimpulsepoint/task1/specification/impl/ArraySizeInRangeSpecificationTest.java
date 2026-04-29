package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.impl.SimpleArrayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySizeInRangeSpecificationTest {

    private SimpleArrayImpl<Integer> array;

    @BeforeEach
    void setUp() {
        array = new SimpleArrayImpl<>(10);
    }

    @Test
    void isSatisfiedBy_SizeInRange_ShouldReturnTrue() {
        array.add(1);
        array.add(2);
        array.add(3);

        ArraySizeInRangeSpecification<Integer> specification = new ArraySizeInRangeSpecification<>(2, 5);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeBelowRange_ShouldReturnFalse() {
        array.add(1);

        ArraySizeInRangeSpecification<Integer> specification = new ArraySizeInRangeSpecification<>(2, 5);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeAboveRange_ShouldReturnFalse() {
        for (int i = 0; i < 6; i++) {
            array.add(i);
        }

        ArraySizeInRangeSpecification<Integer> specification = new ArraySizeInRangeSpecification<>(2, 5);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeAtMinBoundary_ShouldReturnTrue() {
        array.add(1);
        array.add(2);

        ArraySizeInRangeSpecification<Integer> specification = new ArraySizeInRangeSpecification<>(2, 5);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_SizeAtMaxBoundary_ShouldReturnTrue() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }

        ArraySizeInRangeSpecification<Integer> specification = new ArraySizeInRangeSpecification<>(2, 5);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_NullArray_ShouldReturnFalse() {
        ArraySizeInRangeSpecification<Integer> specification = new ArraySizeInRangeSpecification<>(2, 5);

        assertFalse(specification.isSatisfiedBy(null));
    }
}
