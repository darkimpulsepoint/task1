package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

public class ArrayAllPositiveSpecification implements ArraySpecification {

    @Override
    public boolean isSatisfiedBy(IntegerArray array) {
        if (array == null || array.size() == 0) {
            return false;
        }

        try {
            for (int i = 0; i < array.size(); i++) {
                int current = array.get(i);
                if (current <= 0) {
                    return false;
                }
            }
        } catch (SimpleArrayException e) {
            return false;
        }

        return true;
    }
}
