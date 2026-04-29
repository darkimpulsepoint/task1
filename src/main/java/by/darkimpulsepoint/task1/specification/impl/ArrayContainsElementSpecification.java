package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

public class ArrayContainsElementSpecification<T> implements ArraySpecification<SimpleArray<T>> {
    private final T element;

    public ArrayContainsElementSpecification(T element) {
        this.element = element;
    }

    @Override
    public boolean isSatisfiedBy(SimpleArray<T> array) {
        if (array == null || element == null) {
            return false;
        }

        try {
            for (int i = 0; i < array.size(); i++) {
                T current = array.get(i);
                if (element.equals(current)) {
                    return true;
                }
            }
        } catch (SimpleArrayException e) {
            return false;
        }

        return false;
    }
}
