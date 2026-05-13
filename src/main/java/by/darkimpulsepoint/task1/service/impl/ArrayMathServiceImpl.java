package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.service.ArrayMathService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArrayMathServiceImpl implements ArrayMathService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<Integer> findMaxElement(IntegerArray array) {
        int[] elements = array.getElements();
        int max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return Optional.of(max);
    }

    @Override
    public Optional<Integer> findMinElement(IntegerArray array) {
        int[] elements = array.getElements();
        int min = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findSum(IntegerArray array) {
        int sum = 0;
        int[] elements = array.getElements();
        for (int element : elements) {
            sum += element;
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> findAverage(IntegerArray array) {

        double sum = 0;
        int[] elements = array.getElements();
        for (int element : elements) {
            sum += element;
        }
        double average = sum / elements.length;
        return Optional.of(average);
    }
}
