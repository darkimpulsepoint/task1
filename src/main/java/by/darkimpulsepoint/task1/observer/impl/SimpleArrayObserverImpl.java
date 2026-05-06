package by.darkimpulsepoint.task1.observer.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.observer.SimpleArrayObserver;
import by.darkimpulsepoint.task1.pool.ArrayParameters;
import by.darkimpulsepoint.task1.pool.Warehouse;
import by.darkimpulsepoint.task1.service.NumericArrayMathService;

public class SimpleArrayObserverImpl<T extends Number> implements SimpleArrayObserver<T> {
    private final Warehouse<T> warehouse;
    private final NumericArrayMathService<T> mathService;

    public SimpleArrayObserverImpl(Warehouse<T> warehouse, NumericArrayMathService<T> mathService) {
        this.warehouse = warehouse;
        this.mathService = mathService;
    }

    @Override
    public void update(SimpleArray<T> array) {
        var min = mathService.findMinElement(array);
        var max = mathService.findMaxElement(array);
        var sum = mathService.findSum(array);

        if (min.isPresent() && max.isPresent() && sum.isPresent()) {
            warehouse.put(array, new ArrayParameters<>(
                    min.get(),
                    max.get(),
                    sum.get()
            ));
        }
    }
}