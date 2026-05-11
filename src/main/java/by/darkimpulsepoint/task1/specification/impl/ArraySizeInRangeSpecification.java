package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

public class ArraySizeInRangeSpecification implements ArraySpecification {
    private final int minSize;
    private final int maxSize;

    public ArraySizeInRangeSpecification(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public boolean isSatisfiedBy(IntegerArray array) {
        if (array == null) {
            return false;
        }

        int size = array.size();
        return size >= minSize && size <= maxSize;
    }
}
