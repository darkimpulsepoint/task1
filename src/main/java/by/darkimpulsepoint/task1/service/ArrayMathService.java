package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.SimpleArray;

import java.util.Optional;

public interface ArrayMathService<R extends SimpleArray<T>, T> {

    Optional<T> findMaxElement(R array);

    Optional<T> findMinElement(R array);
}
