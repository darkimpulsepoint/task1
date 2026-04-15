package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.ArrayServiceException;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.service.NumericArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class IntegerArrayService implements NumericArrayService<Integer> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void bubbleSort(SimpleArray<Integer> array) throws ArrayServiceException {
        if (array == null) {
            throw new ArrayServiceException("Array cant be null");
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
                } catch (Exception e) {
                    throw new ArrayServiceException("Failed to bubble sort array");
                }
            }
        }

        logger.info("Bubble sort completed for array");
    }

    @Override
    public Optional<Integer> findMaxElement(SimpleArray<Integer> array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

        try {
            Integer max = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                Integer current = array.get(i);
                if (current != null && (max == null || current.compareTo(max) > 0)) {
                    max = current;
                }
            }
            logger.info("Found max element: {}", max);
            return Optional.ofNullable(max);
        } catch (Exception e){
            logger.error("Failed to found max element");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> findMinElement(SimpleArray<Integer> array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

        try {
            Integer min = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                Integer current = array.get(i);
                if (current != null && (min == null || current.compareTo(min) < 0)) {
                    min = current;
                }
            }

            logger.info("Found min element: {}", min);
            return Optional.ofNullable(min);
        } catch (Exception e){
            logger.error("Failed to found min element");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> findSum(SimpleArray<Integer> array) {
        try {
            Integer sum = 0;
            for (int i = 0; i < array.size(); i++) {
                Integer value = array.get(i);
                if (value != null) {
                    sum = sum + value;
                }
            }
            logger.info("Sum of array: {}", sum);
            return Optional.of(sum);
        } catch (Exception e) {
            logger.error("Failed to found sum");
            return Optional.empty();
        }

    }

    @Override
    public Optional<Double> findAverage(SimpleArray<Integer> array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

        double sum = 0;
        for (int i = 0; i < array.size(); i++) {
            Integer value = null;
            try {
                value = array.get(i);
                sum += value.doubleValue();
            } catch (SimpleArrayException e) {
                return Optional.empty();
            }

        }

        double average = sum / array.size();

        logger.info("Average of array: {}", average);
        return Optional.of(average);
    }
}