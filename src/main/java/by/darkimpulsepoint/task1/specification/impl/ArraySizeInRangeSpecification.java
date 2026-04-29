package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

public class ArraySizeInRangeSpecification<T> implements ArraySpecification<SimpleArray<T>> {
    private final int minSize;
    private final int maxSize;

    public ArraySizeInRangeSpecification(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public boolean isSatisfiedBy(SimpleArray<T> array) {
        if (array == null) {
            return false;
        }

        int size = array.size();
        return size >= minSize && size <= maxSize;
    }
}
