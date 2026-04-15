package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;

import java.util.Optional;

public interface ArrayService<R extends SimpleArray<T>, T> {

    void bubbleSort(R array) throws ArrayServiceException;

    Optional<T> findMaxElement(R array);

    Optional<T> findMinElement(R array);
}