package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.service.ArraySortService;

public class IntegerArraySortService implements ArraySortService<SimpleArray<Integer>, Integer> {

    @Override
    public void bubbleSort(SimpleArray<Integer> array) throws ArrayServiceException {
        if (array == null) {
            throw new ArrayServiceException("Array cannot be null");
        }

        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                try {
                    Integer a = array.get(j);
                    Integer b = array.get(j + 1);

                    if (a != null && b != null) {
                        if (a.compareTo(b) > 0) {
                            array.replace(j, b);
                            array.replace(j + 1, a);
                        }
                    }
                } catch (SimpleArrayException e) {
                    throw new ArrayServiceException("Failed to bubble sort array", e);
                }
            }
        }
    }

    @Override
    public void quickSort(SimpleArray<Integer> array) throws ArrayServiceException {
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

    private void quickSortRecursive(SimpleArray<Integer> array, int low, int high) throws SimpleArrayException {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortRecursive(array, low, pivotIndex - 1);
            quickSortRecursive(array, pivotIndex + 1, high);
        }
    }

    private int partition(SimpleArray<Integer> array, int low, int high) throws SimpleArrayException {
        Integer pivot = array.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            Integer current = array.get(j);
            if (current != null && pivot != null && current.compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(SimpleArray<Integer> array, int i, int j) throws SimpleArrayException {
        Integer temp = array.get(i);
        array.replace(i, array.get(j));
        array.replace(j, temp);
    }
}
