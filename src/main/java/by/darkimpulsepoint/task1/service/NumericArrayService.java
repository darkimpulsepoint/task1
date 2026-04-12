package by.darkimpulsepoint.task1.service;

import by.darkimpulsepoint.task1.entity.SimpleArray;

public interface NumericArrayService<R extends SimpleArray<T>, T extends Number> extends ArrayService<R, T> {
    T findSum(R array);

    Double findAverage(R array);
}