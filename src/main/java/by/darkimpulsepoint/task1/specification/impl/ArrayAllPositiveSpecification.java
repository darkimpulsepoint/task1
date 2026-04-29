package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

public class ArrayAllPositiveSpecification implements ArraySpecification<SimpleArray<Integer>> {

    @Override
    public boolean isSatisfiedBy(SimpleArray<Integer> array) {
        if (array == null || array.size() == 0) {
            return false;
        }

        try {
            for (int i = 0; i < array.size(); i++) {
                Integer current = array.get(i);
                if (current == null || current <= 0) {
                    return false;
                }
            }
        } catch (SimpleArrayException e) {
            return false;
        }

        return true;
    }
}
