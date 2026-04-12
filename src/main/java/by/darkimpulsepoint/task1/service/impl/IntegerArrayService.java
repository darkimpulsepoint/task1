package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.service.NumericArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class IntegerArrayService implements NumericArrayService<IntegerArray, Integer> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void bubbleSort(IntegerArray array) {
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.replace(j, array.get(j + 1));
                    array.replace(j + 1, temp);
                }
            }
        }
        logger.info("Sorted array");
    }

    @Override
    public Optional<Integer> findMaxElement(IntegerArray array) {
        if (array.size() == 0) return Optional.empty();

        Integer max = array.get(0);

        for (int i = 1; i < array.size(); i++) {
            Integer current = array.get(i);
            if (current > max) {
                max = current;
            }
        }

        logger.info("Found max element: {}", max);
        return Optional.of(max);
    }

    @Override
    public Optional<Integer> findMinElement(IntegerArray array) {
        if (array.size() == 0) return Optional.empty();

        Integer min = array.get(0);

        for (int i = 1; i < array.size(); i++) {
            Integer current = array.get(i);
            if (current < min) {
                min = current;
            }
        }

        logger.info("Found min element of IntegerArray: {}", min);
        return Optional.of(min);
    }

    @Override
    public Integer findSum(IntegerArray array) {
        int sum = 0;

        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }

        logger.info("Found sum of IntegerArray: {}", sum);
        return sum;
    }

    @Override
    public Double findAverage(IntegerArray array) {
        if (array.size() <= 0) return 0.0;
        long sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        double average = (double) sum / array.size();

        logger.info("Found average of Array: {}", average);
        return average;
    }
}