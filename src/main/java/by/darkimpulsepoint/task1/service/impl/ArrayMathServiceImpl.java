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
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

        try {
            int max = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                int current = array.get(i);
                if (current > max) {
                    max = current;
                }
            }
            return Optional.of(max);
        } catch (SimpleArrayException e){
            logger.error("Failed to find max element", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> findMinElement(IntegerArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

        try {
            int min = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                int current = array.get(i);
                if (current < min) {
                    min = current;
                }
            }
            return Optional.of(min);
        } catch (SimpleArrayException e){
            logger.error("Failed to find min element", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> findSum(IntegerArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

        try {
            int sum = 0;
            for (int i = 0; i < array.size(); i++) {
                sum += array.get(i);
            }
            return Optional.of(sum);
        } catch (SimpleArrayException e) {
            logger.error("Failed to find sum", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Double> findAverage(IntegerArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }

        double sum = 0;
        for (int i = 0; i < array.size(); i++) {
            try {
                sum += array.get(i);
            } catch (SimpleArrayException e) {
                logger.error("Failed to find average", e);
                return Optional.empty();
            }
        }

        double average = sum / array.size();
        return Optional.of(average);
    }
}
