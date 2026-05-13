package by.darkimpulsepoint.task1.observer.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.observer.IntegerArrayObserver;
import by.darkimpulsepoint.task1.pool.ArrayParameters;
import by.darkimpulsepoint.task1.pool.Warehouse;
import by.darkimpulsepoint.task1.service.ArrayMathService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class IntegerArrayObserverImpl implements IntegerArrayObserver {
    private static final Logger logger = LogManager.getLogger();
    private final ArrayMathService mathService;

    public IntegerArrayObserverImpl(ArrayMathService mathService) {
        this.mathService = mathService;
    }

    @Override
    public void update(IntegerArray array) {
        Optional<Integer> min = mathService.findMinElement(array);
        Optional<Integer> max = mathService.findMaxElement(array);
        Optional<Integer> sum = mathService.findSum(array);

        ArrayParameters params = new ArrayParameters(
                min.orElse(0),
                max.orElse(0),
                sum.orElse(0));
        Warehouse.getInstance().put(array, params);
        logger.info("Array updated. ID: {}, Size: {}, Parameters: {}",
                array.getId(), array.size(), params);

    }
}