package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.IntegerArray;

import java.util.Optional;

public interface ArrayMathService {

    Optional<Integer> findMaxElement(IntegerArray array);

    Optional<Integer> findMinElement(IntegerArray array);

    Optional<Integer> findSum(IntegerArray array);

    Optional<Double> findAverage(IntegerArray array);
}
