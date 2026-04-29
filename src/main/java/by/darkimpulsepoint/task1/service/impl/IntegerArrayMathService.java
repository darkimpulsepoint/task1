package by.darkimpulsepoint.task1.service.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.service.NumericArrayMathService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class IntegerArrayMathService implements NumericArrayMathService<Integer> {

    private static final Logger logger = LogManager.getLogger();

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
        } catch (SimpleArrayException e){
            logger.error("Failed to find max element", e);
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
        } catch (SimpleArrayException e){
            logger.error("Failed to find min element", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> findSum(SimpleArray<Integer> array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

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
        } catch (SimpleArrayException e) {
            logger.error("Failed to find sum", e);
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
            try {
                Integer value = array.get(i);
                sum += value.doubleValue();
            } catch (SimpleArrayException e) {
                logger.error("Failed to find average", e);
                return Optional.empty();
            }

        }

        double average = sum / array.size();

        logger.info("Average of array: {}", average);
        return Optional.of(average);
    }
}
