package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.SimpleArray;

import java.util.Optional;

public interface NumericArrayService<T extends Number> extends ArrayService<SimpleArray<T>, T> {

    Optional<T> findSum(SimpleArray<T> array);

    Optional<Double> findAverage(SimpleArray<T> array);
}