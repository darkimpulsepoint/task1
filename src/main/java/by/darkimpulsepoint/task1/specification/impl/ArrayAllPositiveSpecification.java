package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

public class ArrayAllPositiveSpecification implements ArraySpecification {

    @Override
    public boolean isSatisfiedBy(IntegerArray array) {
            int[] elements = array.getElements();
            for (int element : elements) {
                if (element <= 0) {
                    return false;
                }
            }

        return true;
    }
}
