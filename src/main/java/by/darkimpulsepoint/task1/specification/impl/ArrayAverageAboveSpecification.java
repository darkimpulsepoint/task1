package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.service.NumericArrayMathService;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

import java.util.Optional;

public class ArrayAverageAboveSpecification implements ArraySpecification<SimpleArray<Integer>> {
    private final double threshold;
    private final NumericArrayMathService<Integer> mathService;

    public ArrayAverageAboveSpecification(double threshold, NumericArrayMathService<Integer> mathService) {
        this.threshold = threshold;
        this.mathService = mathService;
    }

    @Override
    public boolean isSatisfiedBy(SimpleArray<Integer> array) {
        if (array == null || mathService == null) {
            return false;
        }

        Optional<Double> averageOptional = mathService.findAverage(array);
        if (averageOptional.isEmpty()) {
            return false;
        }

        return averageOptional.get() > threshold;
    }
}
