package by.darkimpulsepoint.task1.observer.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.observer.SimpleArrayObserver;
import by.darkimpulsepoint.task1.pool.ArrayParameters;
import by.darkimpulsepoint.task1.pool.Warehouse;
import by.darkimpulsepoint.task1.service.NumericArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleArrayObserverImpl<T extends Number> implements SimpleArrayObserver<T> {
    private final Warehouse<T> warehouse;
    private final NumericArrayService<T> service;
    private static final Logger logger = LogManager.getLogger();

    public SimpleArrayObserverImpl(Warehouse<T> warehouse, NumericArrayService<T> service) {
        this.warehouse = warehouse;
        this.service = service;
    }

    @Override
    public void update(SimpleArray<T> array) {
        if (array == null || array.size() == 0) {
            logger.error("Empty or null array");
            return;
        }

        var min = service.findMinElement(array);
        var max = service.findMaxElement(array);
        var sum = service.findSum(array);

        if (min.isPresent() && max.isPresent() && sum.isPresent()) {
            warehouse.put(array, new ArrayParameters<>(
                    min.get(),
                    max.get(),
                    sum.get()
            ));
        }
    }
}