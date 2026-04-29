package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.impl.SimpleArrayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAllPositiveSpecificationTest {

    private ArrayAllPositiveSpecification specification;
    private SimpleArrayImpl<Integer> array;

    @BeforeEach
    void setUp() {
        specification = new ArrayAllPositiveSpecification();
        array = new SimpleArrayImpl<>(10);
    }

    @Test
    void isSatisfiedBy_AllPositive_ShouldReturnTrue() {
        array.add(1);
        array.add(5);
        array.add(10);

        assertTrue(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_ContainsZero_ShouldReturnFalse() {
        array.add(1);
        array.add(0);
        array.add(5);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_ContainsNegative_ShouldReturnFalse() {
        array.add(1);
        array.add(-5);
        array.add(10);

        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_EmptyArray_ShouldReturnFalse() {
        assertFalse(specification.isSatisfiedBy(array));
    }

    @Test
    void isSatisfiedBy_NullArray_ShouldReturnFalse() {
        assertFalse(specification.isSatisfiedBy(null));
    }
}
