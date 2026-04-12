package by.darkimpulsepoint.task1.entity;

import by.darkimpulsepoint.task1.exception.SimpleArrayException;

public interface SimpleArray<T> {
    void add(T element);

    T get(int index) throws SimpleArrayException;

    void replace(int index, T element);

    int size();
}