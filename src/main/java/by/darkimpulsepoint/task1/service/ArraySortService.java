package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;

public interface ArraySortService<R extends SimpleArray<T>, T> {

    void bubbleSort(R array) throws ArrayServiceException;

    void quickSort(R array) throws ArrayServiceException;
}
