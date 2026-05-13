package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.service.ArrayMathService;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

import java.util.Optional;

public class ArrayAverageAboveSpecification implements ArraySpecification {
    private final double threshold;
    private final ArrayMathService mathService;

    public ArrayAverageAboveSpecification(double threshold, ArrayMathService mathService) {
        this.threshold = threshold;
        this.mathService = mathService;
    }

    @Override
    public boolean isSatisfiedBy(IntegerArray array) {
        Optional<Double> averageOptional = mathService.findAverage(array);
        if (averageOptional.isEmpty()) {
            return false;
        }

        return averageOptional.get() > threshold;
    }
}
