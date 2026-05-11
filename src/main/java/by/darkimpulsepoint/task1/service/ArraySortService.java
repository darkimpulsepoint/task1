package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;

public interface ArraySortService {

    void bubbleSort(IntegerArray array) throws ArrayServiceException;

    void quickSort(IntegerArray array) throws ArrayServiceException;
}
