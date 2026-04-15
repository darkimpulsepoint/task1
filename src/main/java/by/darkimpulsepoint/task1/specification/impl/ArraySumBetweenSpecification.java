package by.darkimpulsepoint.task1.specification.impl;

import by.darkimpulsepoint.task1.entity.SimpleArrayImpl;
import by.darkimpulsepoint.task1.service.NumericArrayService;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

import java.util.Optional;

public class ArraySumBetweenSpecification<T extends Number & Comparable<T>> implements ArraySpecification<SimpleArrayImpl<T>> {
    private final T min;
    private final T max;
    private final NumericArrayService<T> service;

    public ArraySumBetweenSpecification(T min, T max, NumericArrayService<T> service) {
        this.min = min;
        this.max = max;
        this.service = service;
    }

    @Override
    public boolean isSatisfiedBy(SimpleArrayImpl<T> array) {
        if (array == null || min == null || max == null) {
            return false;
        }

        Optional<T> sumOptional = service.findSum(array);
        if (sumOptional.isEmpty()) {
            return false;
        }

        T sum = sumOptional.get();
        return sum.compareTo(min) >= 0 && sum.compareTo(max) <= 0;
    }
}