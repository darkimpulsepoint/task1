package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {

    @Override
    public void bubbleSort(IntegerArray array) throws ArrayServiceException {
        if (array == null) {
            throw new ArrayServiceException("Array cannot be null");
        }

        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                try {
                    int a = array.get(j);
                    int b = array.get(j + 1);

                    if (a > b) {
                        array.set(j, b);
                        array.set(j + 1, a);
                    }
                } catch (SimpleArrayException e) {
                    throw new ArrayServiceException("Failed to bubble sort array", e);
                }
            }
        }
    }

    @Override
    public void quickSort(IntegerArray array) throws ArrayServiceException {
        if (array == null) {
            throw new ArrayServiceException("Array cannot be null");
        }

        if (array.size() <= 1) {
            return;
        }

        try {
            quickSortRecursive(array, 0, array.size() - 1);
        } catch (SimpleArrayException e) {
            throw new ArrayServiceException("Failed to quick sort array", e);
        }
    }

    private void quickSortRecursive(IntegerArray array, int low, int high) throws SimpleArrayException {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortRecursive(array, low, pivotIndex - 1);
            quickSortRecursive(array, pivotIndex + 1, high);
        }
    }

    private int partition(IntegerArray array, int low, int high) throws SimpleArrayException {
        int pivot = array.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int current = array.get(j);
            if (current <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(IntegerArray array, int i, int j) throws SimpleArrayException {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
