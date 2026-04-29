package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.SimpleArray;

import java.util.Optional;

public interface NumericArrayMathService<T extends Number> extends ArrayMathService<SimpleArray<T>, T> {

    Optional<T> findSum(SimpleArray<T> array);

    Optional<Double> findAverage(SimpleArray<T> array);
}
