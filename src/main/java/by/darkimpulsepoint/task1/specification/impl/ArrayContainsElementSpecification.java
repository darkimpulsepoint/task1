package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

public class ArrayContainsElementSpecification implements ArraySpecification {
    private final int element;

    public ArrayContainsElementSpecification(int element) {
        this.element = element;
    }

    @Override
    public boolean isSatisfiedBy(IntegerArray array) {
        if (array == null) {
            return false;
        }

        try {
            int[] elements = array.getElements();
            for (int current : elements) {
                if (element == current) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
