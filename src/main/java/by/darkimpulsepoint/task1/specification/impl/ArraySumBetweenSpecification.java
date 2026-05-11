package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.service.ArrayMathService;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

import java.util.Optional;

public class ArraySumBetweenSpecification implements ArraySpecification {
    private final int min;
    private final int max;
    private final ArrayMathService service;

    public ArraySumBetweenSpecification(int min, int max, ArrayMathService service) {
        this.min = min;
        this.max = max;
        this.service = service;
    }

    @Override
    public boolean isSatisfiedBy(IntegerArray array) {
        if (array == null) {
            return false;
        }

        Optional<Integer> sumOptional = service.findSum(array);
        if (sumOptional.isEmpty()) {
            return false;
        }

        int sum = sumOptional.get();
        return sum >= min && sum <= max;
    }
}